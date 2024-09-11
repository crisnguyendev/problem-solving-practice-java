package BigOCoding.Abstraction.BuyingApples;

import java.util.Scanner;

public class BuyingApples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Apple[] apples = new Apple[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            apples[i] = new Apple(a, b);
        }
        Apple bestApple = apples[0];
        int index = 0;

        for (int i = 1; i < n; i++) {
            if(apples[i].compareTo(bestApple) > 0) {
                bestApple = apples[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}

class Apple implements Comparable<Apple> {
    private final int weight;
    private final int price;

    public Apple(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Apple apple) {
        if (this.weight != apple.getWeight()) {
            return this.weight - apple.getWeight();
        }
        return this.price - apple.getPrice();
    }
}
