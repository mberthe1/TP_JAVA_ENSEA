public class Aeroport
   {
    private String IATA;
    private String Name;
    private String country;
    private Double latitude;
    private Double longitude;

    public Aeroport (String IATA, String Name, String country, Double latitude, Double longitude){
        this.IATA = IATA;
        this.Name = Name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIATA()
    {
        return IATA;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    @Override
    public String toString()
    {
        return ("L'aéroport est " + Name + "\n" + "Le IATA est " + IATA + "\n" + "Le nom est " + Name + "\n"
                + "Le pays est " + country + "\n" + "La latitude est " + latitude + "\n" + "La longétude est " + longitude + "\n");
    }
}
