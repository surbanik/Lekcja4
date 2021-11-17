import java.util.ArrayList;
import java.util.List;

public class Market {
    String name;
    List<Country> countries;

    public Market(String name, List<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    private static final List<Country> COUNTRY_LIST = Country.createCountryList();
    private static final String[] MARKET_NAME_LIST = {"business", "cargo", "transport", "taxi", "bus"};

    static List<Market> createMarketList() {
        List<Market> marketList = new ArrayList<>();
        for (int i=0; i<=4; i++){
            List<Country> marketCountryList = new ArrayList<>();
            marketCountryList.add(COUNTRY_LIST.get(i));
            if (i<4) {
                marketCountryList.add(COUNTRY_LIST.get(i+1));
            }
            Market market = new Market(MARKET_NAME_LIST[i], marketCountryList);
            marketList.add(market);
        }
        return marketList;
    }
}
