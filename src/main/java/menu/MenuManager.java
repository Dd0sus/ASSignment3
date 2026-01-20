package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Staff> staffList;
    private Scanner scanner;

    public MenuManager() {
        this.staffList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== Grocery Store Staff Management ===");
        System.out.println("1. Add Cashier");
        System.out.println("2. Add Manager");
        System.out.println("3. Show All Staff");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("5. Exit");
    }

    @Override
    public void run() {
        int choice = 0;

        while (choice != 5) {
            displayMenu();
            System.out.print("Choose option: ");

            try {
                String input = scanner.nextLine();
                choice = Integer.parseInt(input); // Can throw NumberFormatException

                switch (choice) {
                    case 1:
                        addCashier();
                        break;
                    case 2:
                        addManager();
                        break;
                    case 3:
                        for (Staff s : staffList) System.out.println(s);
                        break;
                    case 4:
                        for (Staff s : staffList) s.work(); // Polymorphism in action
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void addCashier() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Register Number: ");
        int reg = Integer.parseInt(scanner.nextLine());

        // This will throw exception if data is invalid
        staffList.add(new Cashier(id, name, salary, reg));
        System.out.println("Cashier added successfully!");
    }

    private void addManager() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Team Size: ");
        int size = Integer.parseInt(scanner.nextLine());

        staffList.add(new Manager(id, name, salary, size));
        System.out.println("Manager added successfully!");
    }
}