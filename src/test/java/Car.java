import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Car {
/*
    Zadanie domowe:
1. Napisz klasę Car. Jest to klasa główna, agregująca inne klasy, która posiada następujące elementy:
- pole producent, typu Producent: String model, String Type
- pole isAutomaticGear, typu boolean
- pole market, typu Market: String name, List<Country> countries, (każdy Market ma listę co najmniej 3 krajów w których chce sprzedawać auta)
- pole segment, typu String. Możliwe wartości: standard, medium, premium
- ArrayList dimensions, typu Dimension: int high, int width, int trankCapacity

2. Dodatkowe klasy: 
Producent: String model, String type (np: Toyota Corolla)
Dimension: int high(cm), int width (cm), int trankCapacity (litr) (przykład: 75, 145, 240)
Market: String name, List<Country> countries (Przykład: name = business, cargo, transport, taxi, bus)
Country: String countryName, char countrySign (przykład - Polska - P, Niemcy - D, Chiny - C, Holandia - N, Korea - K)

3. Stwórz z klasie uruchomieniowej następującą liczbę obiektów:

- Country - 5
- Market - 5
- Dimension - 10
- Producent - 10

Klasa głowna - Car - będzie posiadała 15 obiektów. 

4. Utwórz metodę w klasie Car, która przeszuka wszystkie obiekty i wypisze na konsoli kraj - countryName, oraz oznaczenie kraju - countrySign (w formacie: Poland - P) 
gdzie producentem jest BMW, z automatyczną skrzynią biegów oraz pojemnością barażnia - trankCapacity większą niż 300 litrów. 
*/

    Producent producent;
    boolean isAutomaticGear;
    Market market;
    String segment;
    Dimension dimensions;

    public Car(Producent producent, boolean isAutomaticGear, Market market, String segment, Dimension dimensions) {
        this.producent = producent;
        this.isAutomaticGear = isAutomaticGear;
        this.market = market;
        this.segment = segment;
        this.dimensions = dimensions;
    }

    private static String getRandomSegment() {
        Random rn = new Random();
        int random = rn.nextInt(3);
        String[] segmentArrayList = {"standard", "medium", "premium"};
        return segmentArrayList[random];
    }

    private static Market getRandomMarket() {
        Random rn = new Random();
        int random = rn.nextInt(5);

        List<Market> marketList = Market.createMarketList();
        return marketList.get(random);
    }

    private static Producent getRandomProducent() {
        Random rn = new Random();
        int random = rn.nextInt(10);

        List<Producent> producentList = Producent.createProducentList();
        return producentList.get(random);
    }

    private static Dimension getRandomDimension() {
        Random rn = new Random();
        int random = rn.nextInt(10);

        List<Dimension> dimensionList = Dimension.createDimensionList();
        return dimensionList.get(random);
    }

    private static boolean getRandomBoolean() {
        Random rn = new Random();
        int random = rn.nextInt(2);

        boolean[] booleanArrayList = {true, false};
        return booleanArrayList[random];
    }

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i <= 14; i++) {
            Car car = new Car(getRandomProducent(), getRandomBoolean(), getRandomMarket(), getRandomSegment(), getRandomDimension());
            carList.add(car);
        }
//          Arrow Anti-Pattern
//        for (Car car:carList){
//            if (car.producent.model=="BMW" && car.isAutomaticGear==true && car.dimensions.trankCapacity > 300){
//                for (int i=0; i<car.market.countries.size(); i++){
//                    System.out.println(car.market.countries.get().countryName);
//                    System.out.println(car.market.countries.get().countrySign);
//                }
//            }
//        }
        List<Country> availableCountryList = new ArrayList<>();
        carList.stream()
                .filter(c -> c.producent.model.equals("BMW"))
                .filter(c -> c.isAutomaticGear)
                .filter(c -> c.dimensions.trunkCapacity > 300)
                .map(c -> c.market.countries)
                .forEach(availableCountryList::addAll);
        if (availableCountryList.isEmpty()) {
            System.out.println("No results");
        } else {
            for (Country country : availableCountryList) {
                System.out.println(country.countryName + " - " + country.countrySign);
            }
        }
    }
}


