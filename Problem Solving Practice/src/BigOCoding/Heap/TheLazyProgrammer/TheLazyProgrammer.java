package BigOCoding.Heap.TheLazyProgrammer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheLazyProgrammer {
    private static int n;
    private static Contract[] contracts;
    private static PriorityQueue<Contract> maxHeap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            contracts = new Contract[n];
            for (int j = 0; j < n; j++) {
                contracts[j] = new Contract(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }
            System.out.printf("%.2f\n", findMinExtraMoney());
        }
    }

    private static double findMinExtraMoney() {
        maxHeap = new PriorityQueue<>(Comparator.comparingInt(Contract::getBoostTime).reversed());
        Arrays.sort(contracts, Comparator.comparingInt(Contract::getDeadline));
        double sum = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            time += contracts[i].getOriginalTime();
            maxHeap.add(contracts[i]);
            while (time > contracts[i].getDeadline()) {
                Contract topContract = maxHeap.poll();
                if (topContract.getOriginalTime() > time - contracts[i].getDeadline()) {
                    sum += (time - contracts[i].getDeadline()) * 1.0 / topContract.getBoostTime();
                    topContract.setOriginalTime(topContract.getOriginalTime() - time + contracts[i].getBoostTime());
                    maxHeap.add(topContract);
                    time = contracts[i].getDeadline();
                } else {
                    sum += topContract.getOriginalTime() * 1.0 / topContract.getBoostTime();
                    time -= topContract.getOriginalTime();
                    topContract.setOriginalTime(0);
                }
            }
        }
        return sum;
    }

    static class Contract {
        final int deadline;
        final int boostTime;
        int originalTime;

        public Contract(int boostTime, int originalTime, int deadline) {
            this.deadline = deadline;
            this.boostTime = boostTime;
            this.originalTime = originalTime;
        }

        @Override
        public String toString() {
            return deadline + " " + boostTime + " " + originalTime;
        }

        public int getDeadline() {
            return deadline;
        }

        public int getBoostTime() {
            return boostTime;
        }

        public int getOriginalTime() {
            return originalTime;
        }

        public void setOriginalTime(int originalTime) {
            this.originalTime = originalTime;
        }
    }
}
