public class City {

    /* This class creates a city object, allowing you to
       get the name of city, population of city, time zone of city,
       legality of city data and print city name.
     */

    // Initialising private city variables, making them usable throughout the class:
    private String cityName;
    private int cityPopulation;
    private int cityTimeZone;
    private boolean legalTimeZone;
    private boolean legalPop;

    public City(String name, int population, int timeZone, boolean isLegalTimeZone, boolean isLegalPop){

        /* City constructor, taking in name, population, time zone,
           if the time zone is legal, if the population is legal. Allowing
           users to create city objects within a country.
         */

        // Assigning constructor variables to appropriate private variables:
        cityName = name;
        cityPopulation = population;
        cityTimeZone = timeZone;
        legalTimeZone = isLegalTimeZone;
        legalPop = isLegalPop;

    }

    public String getCityName() {
        /* Returns name of city
           when called.
         */

        return cityName;
    }

    public int getPopulation() {
        /* Returns population of city
           when called.
         */

        return cityPopulation;
    }

    public int getCityTimeZone() {
        /* Returns time zone of city
           when called (Will be used to
           calculate time zone differences).
         */

        return cityTimeZone;
    }

    public boolean isLegalTimeZone() {
        /* Returns whether the time zone
           data is legal.
         */

        return legalTimeZone;
    }

    public boolean isLegalPopulation() {
        /* Returns whether the population
           data is legal.
         */

        return legalPop;
    }

    public String toString() {
        /* Prints city name
           when called
         */

        return cityName;
    }
}
