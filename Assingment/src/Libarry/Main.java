package Libarry;
import java.util.ArrayList;
import java.util.Scanner;

// 1. ABSTRACT PARENT CLASS
abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem() {
        this.title = "Unknown";
        this.daysLate = 0;
    }

    public LibraryItem(String title, int daysLate) {
        this();
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract long calculateFine();
}

// 2. CHILD CLASS 1
class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public long calculateFine() {
        return 2L * daysLate;
    }
}

// 3. CHILD CLASS 2
class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public long calculateFine() {
        if (daysLate == 0) {
            return 0;
        }
        return 10 + (5L * daysLate);
    }
}

// 4. MAIN CLASS
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();

        System.out.print("How many returned items? ");
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print("Item " + i + " type (B/D): ");
            String type = scanner.next();

            System.out.print("Item " + i + " title: ");
            String title = scanner.next();

            System.out.print("Item " + i + " days late: ");
            int daysLate = scanner.nextInt();

            if (type.equalsIgnoreCase("B")) {
                items.add(new BookItem(title, daysLate));
            } else if (type.equalsIgnoreCase("D")) {
                items.add(new DVDItem(title, daysLate));
            }
        }

        System.out.println("--- LIBRARY FINE SUMMARY");
        long totalFine = 0;

        for (LibraryItem item : items) {
            long fine = item.calculateFine();
            totalFine += fine;
            System.out.println(item.getTitle() + ": " + fine + " units");
        }

        System.out.println("Total fines: " + totalFine + " units");

    }
}