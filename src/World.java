/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class World {
    ArrayList<Aeroport> aeroportArrayList;

    public World(String fileName) {
        aeroportArrayList = new ArrayList<Aeroport>();

        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");

                String fields[] = s.split(",");

                if (fields[1].equals("large_airport")) {
                    Aeroport aeroport;
                    aeroportArrayList.add(aeroport = new Aeroport(fields[9], fields[2], fields[5], Double.parseDouble(10), Double.parseDouble(11)));
                }
                s = buf.readLine();
            }

        } catch (Exception e) {
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size() - 1));
            e.printStackTrace();
        }
    }

    public Double Distance (Double lat1, Double lat2, Double long1, Double long2)
    {
        Double norme
    }
}
*/
