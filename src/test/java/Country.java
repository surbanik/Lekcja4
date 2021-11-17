import java.util.ArrayList;
import java.util.List;

public class Country {

    String countryName;
    char countrySign;

    public Country(String countryName, char countrySign) {
        this.countryName = countryName;
        this.countrySign = countrySign;
    }

    private static final String[] COUNTRY_NAME_LIST = {"Polska", "Niemcy", "Chiny", "Holandia", "Korea"};
    private static final char[] COUNTRY_SIGN_LIST = {'P', 'N', 'C', 'H', 'K'};

    static List<Country> createCountryList() {
        List<Country> countryList = new ArrayList<>();
        for (int i = 0; i< COUNTRY_NAME_LIST.length; i++){
            Country country = new Country(COUNTRY_NAME_LIST[i], COUNTRY_SIGN_LIST[i]);
            countryList.add(country);
        }
        return countryList;
    }
}
