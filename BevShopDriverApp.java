import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop shop = new BevShop();
        double totalAmountForAllOrders = 0.0;

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());

        while (true) {
            boolean startOrder = getValidBoolean(scanner, "Would you like to start a new order? (yes/no): ");
            if (!startOrder) {
                System.out.printf("\n\u2022 Total amount for all Orders: %.2f\n", totalAmountForAllOrders);
                break;
            }

            System.out.println("\nStart a new order:");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            int age = getValidInteger(scanner, "Enter your age: ", 6, 100);

            shop.startNewOrder(10, Day.MONDAY, name, age);

            if (age > 21) {
                System.out.println("Your age is above 21 and you are eligible to order alcohol.");
            } else {
                System.out.println("Your age is below the minimum requirement for alcohol.");
            }

            while (true) {
                System.out.println("\nWhat would you like to add to your order?");
                System.out.println("1. Alcohol");
                System.out.println("2. Coffee");
                System.out.println("3. Smoothie");
                System.out.println("4. Finish Order");
                int choice = getValidInteger(scanner, "Enter your choice: ", 1, 4);

                if (choice == 1) {
                    if (age < shop.getMinAgeForAlcohol()) {
                        System.out.println("You are not eligible to order alcohol.");
                    } else if (!shop.isEligibleForMore()) {
                        System.out.println("You have reached the maximum limit for alcohol beverages.");
                    } else {
                        System.out.print("Enter the name of the alcohol: ");
                        String bevName = scanner.nextLine();
                        Size size = getValidSize(scanner);
                        shop.processAlcoholOrder(bevName, size);
                        System.out.println("Alcohol added to the order.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter the name of the coffee: ");
                    String bevName = scanner.nextLine();
                    Size size = getValidSize(scanner);
                    boolean extraShot = getValidBoolean(scanner, "Extra shot? (yes/no): ");
                    boolean extraSyrup = getValidBoolean(scanner, "Extra syrup? (yes/no): ");
                    shop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
                    System.out.println("Coffee added to the order.");
                } else if (choice == 3) {
                    System.out.print("Enter the name of the smoothie: ");
                    String bevName = scanner.nextLine();
                    Size size = getValidSize(scanner);
                    int numOfFruits = getValidInteger(scanner, "Enter the number of fruits (1 to 5): ", 1, 5);
                    boolean addProtein = getValidBoolean(scanner, "Add protein? (yes/no): ");
                    shop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
                    System.out.println("Smoothie added to the order.");
                } else {
                    double orderTotal = shop.getCurrentOrder().calcOrderTotal();
                    System.out.printf("\nTotal price for this order: %.2f\n", orderTotal);
                    totalAmountForAllOrders += orderTotal;
                    System.out.println("#------------------------------------#");
                    break;
                }

                int totalItems = shop.getCurrentOrder().getTotalItems();
                double orderTotal = shop.getCurrentOrder().calcOrderTotal();
                System.out.printf("The current order of drinks is %d\n", totalItems);
                System.out.printf("The Total Price on the Order: %.2f\n", orderTotal);
            }
        }

        scanner.close();
    }

    private static boolean getValidBoolean(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("Invalid input. Please enter yes or no.");
        }
    }

    private static int getValidInteger(Scanner scanner, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) return value;
                System.out.printf("Please enter a value between %d and %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static Size getValidSize(Scanner scanner) {
        while (true) {
            System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
            try {
                return Size.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid size. Please enter one of the following: SMALL, MEDIUM, LARGE.");
            }
        }
    }
}