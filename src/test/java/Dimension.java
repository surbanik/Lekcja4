import java.util.ArrayList;
import java.util.List;

public class Dimension {
    int high;
    int width;
    int trunkCapacity;

    public Dimension(int high, int width, int trunkCapacity) {
        this.high = high;
        this.width = width;
        this.trunkCapacity = trunkCapacity;
    }

    private static final int[] HIGH_LIST = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
    private static final int[] WIDTH_LIST = {15, 25, 35, 45, 55, 65, 75, 85, 95, 105 };
    private static final int[] TRUNK_CAPACITY_LIST = {200, 220, 240, 260, 280, 300, 320, 340, 360, 380};

    static List<Dimension> createDimensionList() {
        List<Dimension> dimensionList = new ArrayList<>();
        for (int i = 0; i< HIGH_LIST.length; i++){
            Dimension dimension = new Dimension(HIGH_LIST[i], WIDTH_LIST[i], TRUNK_CAPACITY_LIST[i]);
            dimensionList.add(dimension);
        }
        return dimensionList;
    }
}
