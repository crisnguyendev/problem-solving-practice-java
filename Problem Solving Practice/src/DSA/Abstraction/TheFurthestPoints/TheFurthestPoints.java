package DSA.Abstraction.TheFurthestPoints;

import java.util.Scanner;

public class TheFurthestPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point pointM = new Point(scanner.nextInt(), scanner.nextInt());
        int n = scanner.nextInt();
        Point furthestPoint = pointM;
        double max = 0;
        for (int i = 0; i < n; i++) {
            Point pointN = new Point(scanner.nextInt(), scanner.nextInt());
            double distance = pointM.distance(pointN);
            if (distance > max) {
                furthestPoint = pointN;
                max = distance;
            }
        }
        System.out.println(furthestPoint);

    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
