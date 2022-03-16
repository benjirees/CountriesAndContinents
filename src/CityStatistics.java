import java.util.ArrayList;

/* This class makes accessing and manipulating certain city statistics very easy
   Allowing you to get the name of a specific city returned as a string,
   work out the time difference between two time zones and return whether
   a city's data is legal.
 */

public class CityStatistics {

    private ArrayList<City> citiesArray = new ArrayList<City>();
    private String cityName;

    public CityStatistics(ArrayList<City> cities, String name) {

        /* 'CityStatistics' constructor, taking in an ArrayList with all city objects,
            and name of specific city that we want the data of.
         */

        citiesArray = cities;
        cityName = name;
    }

    public String getName() {

        /* Returns the name of the desired city as a String,
           so it can be printed in the 'Main' method.
         */

        return cityName;
    }

    private int getTimeZone(String nameOfCity) {

        /* Gets the time zone of a specific city,
           so it can be used when calculating the difference
           between two time zones. This is private as it only needs to
           be accessed within this class.
         */

        // Loop through all cities and get the time zone of the desired city:
        for (City elem : citiesArray) {
            if (elem.getCityName().equals(nameOfCity)) {
                return elem.getCityTimeZone();
            }
        }

        // City does not exist:
        return -1;
    }

    public int timeDifference(CityStatistics otherCountry) {

         /* Works out the time difference between two cities.
           It is an integrated object, allowing us to work out the difference
           of the current city we are already referring to and the city we then are
           getting through the new 'CityStatistics' object created within this method.
         */

        // Get name of 2nd city, get time zone of 2nd city and first city, return result of subtracting them both:
        String otherCityName = otherCountry.getName();
        int otherCityTimeZone = otherCountry.getTimeZone(otherCityName);
        int currentCityTimeZone = getTimeZone(cityName);
        return currentCityTimeZone - otherCityTimeZone;
    }

    public boolean isLegalData() {

        /* Checks to see whether city data is legal. If the timezone is valid (> -12 & < 11)
           and the city population figure is > 0.
         */

        // Loop through all cities, returning whether the data is for desired city is legal:
        for (City elem : citiesArray) {
            if (elem.getCityName().equals(cityName)) {
                return elem.isLegalTimeZone() && elem.isLegalPopulation();
            }
        }

        // If city doesn't exist return false:
        return false;
    }

}
