import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Math.*;

public class World
{
    ArrayList<Aeroport> AeroportArrayList;

    public ArrayList<Aeroport> getlist()
    {
        return AeroportArrayList;
    }


    public World(String fileName)
    {
        AeroportArrayList = new ArrayList<Aeroport>();

        try
        {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null)
            {
                s = s.replaceAll("\"", "");

                String fields[] = s.split(",");

                if (fields[1].equals("large_airport"))
                {
                    Aeroport aeroport;
                    AeroportArrayList.add(aeroport = new Aeroport(fields[9], fields[2], fields[5], Double.parseDouble(fields[12]), Double.parseDouble(fields[11])));
                }
                s = buf.readLine();
            }

        }
        catch (Exception e)
        {
            System.out.println("Maybe the file isn't there ?");
            System.out.println(AeroportArrayList.get(AeroportArrayList.size() - 1));
            e.printStackTrace();
        }
    }

    public Double Distance(Double lat1, Double lat2, Double long1, Double long2)
    {
        Double norme = pow(lat2 - lat1, 2) + pow((long2 - long1) * cos(toRadians((lat2 + lat1) / 2)), 2);
        return norme;
    }

    public Aeroport findNearestAirport(double longitude, double latitude)
    {
        double Dist = Distance(longitude, latitude, AeroportArrayList.get(0).getLongitude(), AeroportArrayList.get(0).getLatitude());
        Aeroport aeroport = null;
        for (Aeroport a : AeroportArrayList)
        {
            Double lat1 = a.getLatitude();
            Double long1 = a.getLongitude();
            Double d = Distance(latitude, lat1, longitude, long1);
            if (d < Dist)
            {
                aeroport = a;
                Dist = d;
            }
        }
        return aeroport;
    }

    public Aeroport findByCode(String code)
    {
        for (Aeroport aeroport : AeroportArrayList)
        {
            if (aeroport.getIATA().equals(code))
            {
                return aeroport;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        World w = new World("./data/airport-codes_no_comma.csv");
        System.out.println("Found " + w.getlist().size() + " airports.");
        Aeroport paris = w.findNearestAirport(2.316, 48.866);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.Distance(2.316, 48.866, paris.getLongitude(), paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.Distance(2.316, 48.866, cdg.getLongitude(), cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);
    }
}