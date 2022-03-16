public class Main {

    public static void main(String[] args) {

        Country argentina = new Country("Argentina", 45605800);
        argentina.addCity("Buenos Aires",13588200, -3);
        argentina.addCity("Cordoba", 1454650, -3);
        argentina.addCity("Rosario", 1236000, -3);
        argentina.addCity("Mendoza", 937200,-3);
        argentina.addCity("La Plata", 794300, -3);

        System.out.println(argentina);

        Country usa = new Country("USA", 331449300);
        usa.addCity("New York", 20140470, -5);
        usa.addCity("Dallas", 7637390, -6);
        usa.addCity("Phoenix", 4845800, -7);
        usa.addCity("Los Angeles", 13201000, -8);

        System.out.println(usa);

        Country russia = new Country("Russia", 146171000);
        russia.addCity("Moscow", 12506500, 3);
        russia.addCity("Vladivostok", 60500, 10);
        russia.addCity("Yekaterinburg", 1350000, 5);
        russia.addCity("Novosibirsk", 143750, 7);

        Country cuntLand = new Country("Cunt Land", 1232324);

        System.out.println(russia);
    }

}
