package menu;

import model.*;
import exception.InvalidInputException;
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

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("That is not a number!");
                }

                if (choice < 1 || choice > 5) {
                    throw new InvalidInputException("Option must be between 1 and 5");
                }

                switch (choice) {
                    case 1: addCashier(); break;
                    case 2: addManager(); break;
                    case 3:
                        for (Staff s : staffList) System.out.println(s);
                        break;
                    case 4: demonstratePolymorphism(); break;
                    case 5: System.out.println("Exiting......................................................................................................................"); break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Input Error: " + e.getMessage());


            } catch (InvalidInputException e) {
                System.out.println("Menu Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("--- Polymorphism Demo ---");
        for (Staff s : staffList) {
            s.work();
            if (s instanceof Promotable) {
                ((Promotable) s).promote();
            }
        }
    }

    private void addCashier() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            System.out.print("Register Number: ");
            int reg = Integer.parseInt(scanner.nextLine());

            staffList.add(new Cashier(id, name, salary, reg));
            System.out.println("Cashier added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Enter valid numbers for ID/Salary!!!!!!!!!!!!!!!!");
        }
    }

    private void addManager() {
        try {
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
        } catch (NumberFormatException e) {
            System.out.println("Error: Enter valid numbers for ID/Salary!!!!!!!!!!!!!!!!");
        }
    }
}