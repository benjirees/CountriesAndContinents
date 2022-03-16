/* Improvements based on feedback from coursework 1:
   Firstly, I have made sure to leave more space between each logical block,
   making comments easier to read and understand. I have also tried to make sure that
   comments focus on what the program does and not how it works. I have also tried
   to ensure that variables are named appropriately and descriptively along with the
   appropriate use of final variables when necessary. Finally, I have attempted to
   keep code repetition to a minimum. However, I have had some trouble with looping
   through the object array which has meant some code is repeated, as when I was storing the index
   as a variable it was actually making more for loops. I have also made sure that all the text
   is stored in final variable Strings.
 */

import java.util.ArrayList;

public class Country {

    /* This class creates a country object. Allowing the addition of cities,
       deletion of cities, an option to print country information using
       the toString() method, and check the validity of country data.
     */

    // Final variables:
    private static final int MEGA_CITY_POPULATION_VALUE = 10000000;
    private static final int TIME_ZONE_MINIMUM = -12;
    private static final int TIME_ZONE_MAXIMUM = 11;

    // Country variables:
    private String countryName;
    private int countryPopulation;
    private boolean countryLegalData;

    // City variables:
    private boolean isMegaCity;
    private int totalCityPopulation = 0;
    private boolean isLegalPop;
    private boolean isLegalTimeZone;

    // String variables (Easier for translation):
    private static final String IS_MEGA_CITY_TEXT = " It IS a megacity";
    private static final String IS_NOT_MEGA_CITY_TEXT = " It IS NOT a megacity";
    private static final String HAS_POPULATION = ": has population ";
    private static final String AND_IS_IN_TIME_ZONE =  " and is in time zone ";
    private static final String TOTAL_POPULATION_TEXT = ": total population: ";
    private static final String POPULATION_OUTSIDE_CITIES = ", population outside listed cities: ";
    private static final String WITH_CITIES = ", with cities";

    // ArrayList to store all city objects in this country:
    private ArrayList<City> cities = new ArrayList<City>();

    public Country(String name, int population) {

        /* Constructor for the country class, taking the
           name of the Country and Population and storing them
           as private variables that can be used throughout the
           class.
         */

        // Variable declaration for country variables:
        countryName = name;

        // If the population is invalid, store it as '0':
        if (population <= 0) {
            countryPopulation = 0;
            countryLegalData = false;
            // If the population is valid, store the original population:
        } else {
            countryPopulation = population;
            countryLegalData = true;
        }

    }

    public void addCity(String name, int population, int timeZone) {

         /* Adds a city to a country object. It does this by
           populating the city array with city objects,
           making it easy to keep track and access all city statistics.
           If data is invalid add '0' to the array as this needs to be represented in
           the output.
         */

        // Variable declaration:
        String cityName = name;
        int cityPopulation = population;
        int cityTimeZone = timeZone;

        // Find out whether city data is legal:
        isLegalTimeZone = isTimeZoneLegal(cityTimeZone);
        isLegalPop = isPopLegal(cityPopulation);

        // Initialise population and time zone values based on whether the data is valid and update ArrayList:
        if (!isLegalTimeZone && !isLegalPop) {
            cityPopulation = 0;
            cityTimeZone = 0;
            cities.add(new City(cityName, cityPopulation, cityTimeZone, false, false));
        } else if (isLegalTimeZone && !isLegalPop) {
            cityPopulation = 0;
            cities.add(new City(cityName, cityPopulation, cityTimeZone, true, false));
        } else if (!isLegalTimeZone) {
            cityTimeZone = 0;
            cities.add(new City(cityName, cityPopulation, cityTimeZone, false, true));
            totalCityPopulation += cityPopulation;
        } else {
            cities.add(new City(cityName, cityPopulation, cityTimeZone, true, true));
            totalCityPopulation += cityPopulation;
        }
    }

    private boolean isPopLegal(int population) {

        /* Returns whether the population
           is a legal value (greater than 0).
         */

        return population > 0;
    }

    private boolean isTimeZoneLegal(int timeZone) {

        /* Returns whether the time zone
           is a legal value (greater than -12, less than 11)
        */

        return timeZone >= TIME_ZONE_MINIMUM && timeZone <= TIME_ZONE_MAXIMUM;
    }

    public CityStatistics getCityByName(String userCityName) {

        /* Creates a new 'CityStatistics' object
           and returns it upon call.
         */

        CityStatistics timeZoneDifference = new CityStatistics(cities, userCityName);

        return timeZoneDifference;
    }

    public boolean deleteCity(String cityToDelete) {

        /* Finds city in ArrayList and then deletes
           it. Returns 'true' if successful 'false'
           if not.
         */

        // Loop over each element and delete desired city from ArrayList:
        for (City elem : cities) {
            if (elem.getCityName().equals(cityToDelete)) {
                totalCityPopulation -= elem.getPopulation(); // Decrement total population by deleted population
                cities.remove(elem);
                return true;
            }
        }
        return false;
    }

    public boolean isLegalData() {

        /* Returns the verdict on whether
           the country data is valid.
           (Population > 0)
         */

        return countryLegalData;
    }

    private String printCityStatistics() {

        /* This method presents each city's data in a formatted
           manner allowing it to be printed in the toString() method, starts
           with an empty String and then concatenates every city's data to this String.
         */

        // Use a 'StringBuilder' to add each city's stats to the output String:
        StringBuilder cityStatsOutput = new StringBuilder();

        // Loop over every city printing out the information stored on each city:
        for (City elem : cities) {
            cityStatsOutput.append(elem.getCityName()).append(HAS_POPULATION)
                    .append(elem.getPopulation()).append(AND_IS_IN_TIME_ZONE)
                    .append(elem.getCityTimeZone()).append(".");

            // Different output required depending on whether city is a mega-city:
            if (elem.getPopulation() >= MEGA_CITY_POPULATION_VALUE) {
                cityStatsOutput.append(IS_MEGA_CITY_TEXT).append(System.lineSeparator());
            } else {
                cityStatsOutput.append(IS_NOT_MEGA_CITY_TEXT).append(System.lineSeparator());
            }
        }

        // Return the completed String:
        return cityStatsOutput.toString();
    }

    public String toString() {

        /* Prints out country data in a presentable manner.
           And also prints data on every city line by line,
           calling the printCityStatistics() method.
         */

        // Work out population of people that are not in the listed cities:
        int populationNotInCities = countryPopulation - totalCityPopulation;

        // First line output (Country statistics):
        String countryOutput = (countryName + TOTAL_POPULATION_TEXT + countryPopulation
                                + POPULATION_OUTSIDE_CITIES
                                + (populationNotInCities) + WITH_CITIES);

        // Get output for cities:
        String cityOutput = printCityStatistics();

        return (countryOutput + System.lineSeparator() + cityOutput);

    }

}
