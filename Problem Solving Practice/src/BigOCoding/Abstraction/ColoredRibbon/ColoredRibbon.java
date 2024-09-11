package BigOCoding.Abstraction.ColoredRibbon;

import java.util.*;

public class ColoredRibbon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, RibbonStatistic> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int code = scanner.nextInt();
            int length = scanner.nextInt();
            if (map.containsKey(code)) {
                RibbonStatistic statistic = map.get(code);
                statistic.increaseCount();
                statistic.addLength(length);
                map.put(code, statistic);
            } else {
                map.put(code, new RibbonStatistic(code, length));
            }
        }

        List<RibbonStatistic> statistics = new ArrayList<>(map.values());
        statistics.sort(Comparator.comparing(RibbonStatistic::getCode));
        System.out.println(statistics.size());
        for (RibbonStatistic statistic: statistics) {
            System.out.println(statistic);
        }
    }
}

class RibbonStatistic {
    private final int code;
    private int length;
    private int count;

    public RibbonStatistic(int code, int length) {
        this.code = code;
        this.length = length;
        this.count = 1;
    }

    public int getCode() {
        return code;
    }

    public void increaseCount() {
        count++;
    }

    public void addLength(int length) {
        this.length += length;
    }

    @Override
    public String toString() {
        return code + " " + length + " " + count;
    }
}
