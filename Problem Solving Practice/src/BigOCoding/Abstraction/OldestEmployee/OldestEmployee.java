package BigOCoding.Abstraction.OldestEmployee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OldestEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Employee[] employees = new Employee[N];
        for (int i = 0; i < N; i++) {
            String index = scanner.next();
            String name = scanner.next();
            int yearOfBirth = scanner.nextInt();
            employees[i] = new Employee(index, name, yearOfBirth);
        }
        Arrays.sort(employees, Comparator.comparing(Employee::getYearOfBirth).thenComparing(Employee::getIndex));
        System.out.println(employees[0]);
    }
}

class Employee {
    private final String index;
    private final String name;
    private final int yearOfBirth;

    public Employee(String index, String name, int yearOfBirth) {
        this.index = index;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return index + " " + name + " " + yearOfBirth;
    }
}
