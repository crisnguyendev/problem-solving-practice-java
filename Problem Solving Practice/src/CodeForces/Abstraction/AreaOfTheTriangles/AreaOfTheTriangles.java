package CodeForces.Abstraction.AreaOfTheTriangles;

import java.util.Scanner;

public class AreaOfTheTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 0;
        for (int i = 0; i < n; i++) {
            Vertex[] vertices = new Vertex[3];
            for (int j = 0; j < 3; j++) {
                vertices[j] = new Vertex(scanner.nextInt(), scanner.nextInt());
            }
            double a = vertices[0].distance(vertices[1]);
            double b = vertices[1].distance(vertices[2]);
            double c = vertices[2].distance(vertices[0]);
            double s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            result = result + area;
        }
        System.out.printf("%.2f", result);
    }
}

class Vertex {
    private final int x;
    private final int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Vertex vertex) {
        return Math.sqrt(Math.pow(vertex.x - x, 2) + Math.pow(vertex.y - y, 2));
    }
}
