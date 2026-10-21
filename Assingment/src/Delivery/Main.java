package Delivery;


import java.util.ArrayList;
import java.util.Scanner;

// 1. ABSTRACT PARENT CLASS
abstract class Delivery {
    protected int distance;
    protected int weight;

    public Delivery() {
        this.distance = 0;
        this.weight = 0;
    }

    public Delivery(int distance, int weight) {
        this();
        this.distance = distance;
        this.weight = weight;
    }

    public abstract long calculateFee();
}

// 2. CHILD CLASS 1
class RegularDelivery extends Delivery {
    public RegularDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 10 + (2L * distance) + weight;
    }
}

// 3. CHILD CLASS 2
class ExpressDelivery extends Delivery {
    public ExpressDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 25 + (4L * distance) + (2L * weight);
    }
}

// 4. MAIN CLASS
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Delivery> deliveries = new ArrayList<>();

        System.out.print("How many deliveries? ");
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print("Delivery " + i + " type (R/E): ");
            String type = scanner.next();

            System.out.print("Delivery " + i + " distance (km): ");
            int distance = scanner.nextInt();

            System.out.print("Delivery " + i + " weight (kg): ");
            int weight = scanner.nextInt();

            if (type.equalsIgnoreCase("R")) {
                deliveries.add(new RegularDelivery(distance, weight));
            } else if (type.equalsIgnoreCase("E")) {
                deliveries.add(new ExpressDelivery(distance, weight));
            }
        }

        System.out.println("--- DELIVERY FEE SUMMARY");
        long totalFee = 0;

        for (int i = 0; i < deliveries.size(); i++) {
            long fee = deliveries.get(i).calculateFee();
            totalFee += fee;
            System.out.println("Delivery " + (i + 1) + ": " + fee + " units");
        }

        System.out.println("Total delivery fees: " + totalFee + " units");

    }
}