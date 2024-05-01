import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Restaurant {
    private String name;
    private String address;
    private HashMap<String, Double> foodMenu;
    private HashMap<String, Double> drinkMenu;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.foodMenu = new HashMap<>();
        this.drinkMenu = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addToFoodMenu(String foodItem, double price) {
        foodMenu.put(foodItem, price);
    }

    public void addToDrinkMenu(String drinkItem, double price) {
        drinkMenu.put(drinkItem, price);
    }

    public void displayMenu() {
        System.out.println("Menu of " + name + ":");
        System.out.println("Food Menu:");
        for (String foodItem : foodMenu.keySet()) {
            System.out.println("- " + foodItem + ": $" + foodMenu.get(foodItem));
        }
        System.out.println("Drink Menu:");
        for (String drinkItem : drinkMenu.keySet()) {
            System.out.println("- " + drinkItem + ": $" + drinkMenu.get(drinkItem));
        }
    }
}

class Customer {
    private String name;
    private ArrayList<String> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(String order) {
        orders.add(order);
        System.out.println("Order placed successfully: " + order);
    }

    public void viewOrders() {
        System.out.println("Orders of " + name + ":");
        for (String order : orders) {
            System.out.println("- " + order);
        }
    }
}

class OnlineFoodDelivery {
    private HashMap<String, String> adminCredentials;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Customer> customers;
    private Scanner scanner;
    private String loggedInUser;

    public OnlineFoodDelivery() {
        adminCredentials = new HashMap<>();
        adminCredentials.put("admin", "admin123");
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        scanner = new Scanner(System.in);
        loggedInUser = null;
    }

    public void start() {
        System.out.println("Welcome to Online Food Delivery System!");

        while (true) {
            System.out.println("\n1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loginAsAdmin();
                    break;
                case 2:
                    loginAsCustomer();
                    break;
                case 3:
                    System.out.println("Thank you for using our system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void loginAsAdmin() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
            loggedInUser = username;
            adminMenu();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View Restaurants");
            System.out.println("2. Add Restaurant");
            System.out.println("3. Delete Restaurant");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewRestaurants();
                    break;
                case 2:
                    addRestaurant();
                    break;
                case 3:
                    deleteRestaurant();
                    break;
                case 4:
                    loggedInUser = null;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewRestaurants() {
        System.out.println("\nList of Restaurants:");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant.getName());
        }

        System.out.print("\nEnter the name of the restaurant to view details (or type 'back' to return): ");
        String restaurantName = scanner.nextLine();
        if (restaurantName.equalsIgnoreCase("back")) {
            return;
        }

        Restaurant selectedRestaurant = findRestaurant(restaurantName);
        if (selectedRestaurant != null) {
            System.out.println("\nRestaurant Details:");
            System.out.println("Name: " + selectedRestaurant.getName());
            System.out.println("Address: " + selectedRestaurant.getAddress());
            selectedRestaurant.displayMenu();
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    private void addRestaurant() {
        System.out.print("\nEnter the name of the restaurant: ");
        String name = scanner.nextLine();
        System.out.print("Enter the address of the restaurant: ");
        String address = scanner.nextLine();
        Restaurant restaurant = new Restaurant(name, address);

        System.out.println("Adding food menu items (Enter item name and price separated by space, type 'done' to finish):");
        while (true) {
            System.out.print("Enter food item and price (e.g., Burger 5.99): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                String foodItem = parts[0];
                double price = Double.parseDouble(parts[1]);
                restaurant.addToFoodMenu(foodItem, price);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println("Adding drink menu items (Enter item name and price separated by space, type 'done' to finish):");
        while (true) {
            System.out.print("Enter drink item and price (e.g., Coke 1.99): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                String drinkItem = parts[0];
                double price = Double.parseDouble(parts[1]);
                restaurant.addToDrinkMenu(drinkItem, price);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        restaurants.add(restaurant);
        System.out.println("Restaurant added successfully.");
    }

    private void deleteRestaurant() {
        System.out.print("\nEnter the name of the restaurant to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().equals(name)) {
                restaurants.remove(i);
                System.out.println("Restaurant deleted successfully.");
                return;
            }
        }
        System.out.println("Restaurant not found.");
    }

    private void loginAsCustomer() {
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        Customer customer = findCustomer(name);
        if (customer == null) {
            customer = new Customer(name);
            customers.add(customer);
        }
        loggedInUser = name;
        customerMenu(customer);
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    private void customerMenu(Customer customer) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Restaurants");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewRestaurants();
                    break;
                case 2:
                    placeOrder(customer);
                    break;
                case 3:
                    customer.viewOrders();
                    break;
                case 4:
                    loggedInUser = null;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void placeOrder(Customer customer) {
        System.out.print("\nEnter the restaurant name: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = findRestaurant(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }
        restaurant.displayMenu();
        System.out.print("Enter the item you want to order: ");
        String item = scanner.nextLine();
        customer.placeOrder(restaurantName + ": " + item);
    }

    private Restaurant findRestaurant(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineFoodDelivery app = new OnlineFoodDelivery();
        app.start();
    }
}
