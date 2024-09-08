package LeetCode.Medium.InsertDeleteGetRandomO1;

import java.util.*;

public class InsertDeleteGetRandomO1 {

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        int param_3 = obj.getRandom();
    }
}

class RandomizedSet {

    private final Map<Integer, Integer> indexes;
    private final List<Integer> values;
    private final Random random;

    public RandomizedSet() {
        indexes = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        indexes.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        int index = indexes.get(val);
        int lastElement = values.get(values.size() - 1);
        values.set(index, lastElement);
        indexes.put(lastElement, index);
        values.remove(values.size() - 1);
        indexes.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}

