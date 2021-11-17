import java.util.ArrayList;
import java.util.List;

public class Producent {

    String model;
    String type;

    public Producent(String model, String type) {
        this.model = model;
        this.type = type;
    }

    private static final String[] MODEL_LIST = {"Toyota", "BMW", "Mercedes", "Hyundai", "Fiat", "Ford", "Renault", "Peugeot", "Suzuki", "Kia", "Ford"};
    private static final String[] TYPE_LIST = {"Yaris", "X5", "CLA", "I20", "Punto", "Fiesta", "Megan", "307", "Swift", "Ceed", "Focus"};

    static List<Producent> createProducentList() {
        List<Producent> producentList = new ArrayList<>();
        for (int i = 0; i< MODEL_LIST.length; i++){
            Producent producent = new Producent(MODEL_LIST[i], TYPE_LIST[i]);
            producentList.add(producent);
        }
        return producentList;
    }
}
