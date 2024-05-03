import java.util.*;

public class OnlineFoodOrderingSystem {
    private static Map<String, String> adminCredentials = new HashMap<>();
    private static Map<String, String> customerCredentials = new HashMap<>();
    private static List<String> orderList = new ArrayList<>();
    private static Map<String, String> restaurantAddressMap = new HashMap<>();
    private static Map<String, Map<String, Double>> restaurantFoodMenuMap = new HashMap<>();
    private static Map<String, Map<String, Double>> restaurantDrinkMenuMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        // Admin credentials
        adminCredentials.put("admin", "admin123");

        // Customer credentials
        customerCredentials.put("customer", "customer123");
    }

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===================================================");
            System.out.println("Selamat Datang di Sistem Pemesanan Makanan Online");
            System.out.println("===================================================");
            System.out.println("         Silakan pilih tipe pengguna:   ");
            System.out.println("             1. Admin    ");
            System.out.println("             2. Customer ");
            System.out.println("             3. Keluar   ");
            System.out.println("===================================================");
            System.out.print("            Pilihan Anda:  ");

            int userType = scanner.nextInt();
            scanner.nextLine(); // Clear newline from buffer

            switch (userType) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerLogin();
                    break;
                case 3:
                    System.out.println(" Terima kasih telah menggunakan sistem pemesanan makanan online. ");
                    isRunning = false;
                    break;
                default:
                    System.out.println(" Pilihan tidak valid. Silakan pilih kembali. ");
            }
        }
    }

    public static void adminLogin() {
        System.out.println("===================================================");
        System.out.println("            Login Admin            ");
        System.out.print("            Username: ");
        String username = scanner.nextLine();
        System.out.print("            Password: ");
        String password = scanner.nextLine();

        if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
            System.out.println("Login admin berhasil!");
            displayAdminMenu();
        } else {
            System.out.println("Username atau password admin salah.");
        }
    }

    public static void customerLogin() {
        System.out.println("===================================================");
        System.out.println("          Login Customer          ");
        System.out.print("            Username: ");
        String username = scanner.nextLine();
        System.out.print("            Password: ");
        String password = scanner.nextLine();

        if (customerCredentials.containsKey(username) && customerCredentials.get(username).equals(password)) {
            System.out.println("Login customer berhasil!");
            displayCustomerMenu();
        } else {
            System.out.println("Username atau password customer salah.");
        }
    }

    public static void displayAdminMenu() {
        boolean isAdminMenuActive = true;

        while (isAdminMenuActive) {
            System.out.println("===================================================");
            System.out.println("                 Menu Admin                 ");
            System.out.println("      1. Lihat Daftar Restoran dan Menu      ");
            System.out.println("                2. Tambah Restoran                ");
            System.out.println("               3. Hapus Restoran               ");
            System.out.println("             4. Kembali ke Login             ");
            System.out.println("===================================================");
            System.out.print("            Pilihan Anda:   ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline from buffer

            switch (choice) {
                case 1:
                    showRestaurantMenu();
                    break;
                case 2:
                    addRestaurant();
                    break;
                case 3:
                    deleteRestaurant();
                    break;
                case 4:
                    System.out.println("        Keluar dari menu admin.        ");
                    isAdminMenuActive = false;
                    break;
                default:
                    System.out.println("        Pilihan tidak valid.        ");
            }
        }
    }

    public static void displayCustomerMenu() {
        boolean isCustomerMenuActive = true;

        while (isCustomerMenuActive) {
            System.out.println("===================================================");
            System.out.println("               Menu Pelanggan               ");
            System.out.println("      1. Lihat Daftar Restoran dan Menu      ");
            System.out.println("              2. Buat Pesanan              ");
            System.out.println("               3. Lihat Pesanan               ");
            System.out.println("             4. Kembali ke Login             ");
            System.out.println("===================================================");
            System.out.print("            Pilihan Anda:   ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline from buffer

            switch (choice) {
                case 1:
                    showRestaurantMenu();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    showOrder();
                    break;
                case 4:
                    System.out.println("        Keluar dari menu pelanggan.        ");
                    isCustomerMenuActive = false;
                    break;
                default:
                    System.out.println("        Pilihan tidak valid.        ");
            }
        }
    }

    public static void showRestaurantMenu() {
        System.out.println("===================================================");
        System.out.println("\n         Daftar Restoran dan Menu:         ");

        for (String restaurant : restaurantAddressMap.keySet()) {
            System.out.println("       Restoran: " + centerText(restaurant, 2));
            System.out.println("       Alamat: " + restaurantAddressMap.get(restaurant));

            System.out.println("       Menu Makanan: ");
            Map<String, Double> foodMenu = restaurantFoodMenuMap.get(restaurant);
            for (Map.Entry<String, Double> entry : foodMenu.entrySet()) {
                System.out.println("- " + centerText(entry.getKey(), 38) + " - Rp" + entry.getValue());
            }

            System.out.println("       Menu Minuman: ");
            Map<String, Double> drinkMenu = restaurantDrinkMenuMap.get(restaurant);
            for (Map.Entry<String, Double> entry : drinkMenu.entrySet()) {
                System.out.println("- " + centerText(entry.getKey(), 38) + " - Rp" + entry.getValue());
            }

            System.out.println();
        }
    }

    public static void addRestaurant() {
        System.out.println("===================================================");
        System.out.print("       Masukkan nama restoran yang baru:   ");
        String newRestaurant = scanner.nextLine();
        System.out.print("       Masukkan alamat restoran:   ");
        String restaurantAddress = scanner.nextLine();

        // Add food menu
        Map<String, Double> foodMenu = new HashMap<>();
        boolean isAddingFood = true;

        while (isAddingFood) {
            System.out.print("       Masukkan nama makanan:   ");
            String foodName = scanner.nextLine();
            System.out.print("       Masukkan harga makanan:   ");
            double foodPrice = scanner.nextDouble();
            scanner.nextLine(); // Clear newline from buffer

            foodMenu.put(foodName, foodPrice);

            System.out.print("       Tambah makanan lagi? (y/n):   ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                isAddingFood = false;
            }
        }

        // Add drink menu
        Map<String, Double> drinkMenu = new HashMap<>();
        boolean isAddingDrink = true;

        while (isAddingDrink) {
            System.out.print("       Masukkan nama minuman:   ");
            String drinkName = scanner.nextLine();
            System.out.print("       Masukkan harga minuman:   ");
            double drinkPrice = scanner.nextDouble();
            scanner.nextLine(); // Clear newline from buffer

            drinkMenu.put(drinkName, drinkPrice);

            System.out.print("       Tambah minuman lagi? (y/n):   ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                isAddingDrink = false;
            }
        }

        restaurantAddressMap.put(newRestaurant, restaurantAddress);
        restaurantFoodMenuMap.put(newRestaurant, foodMenu);
        restaurantDrinkMenuMap.put(newRestaurant, drinkMenu);

        System.out.println("       Restoran '" + newRestaurant + "' berhasil ditambahkan.       ");
    }

    public static void deleteRestaurant() {
        System.out.println("===================================================");
        System.out.println("         Daftar Restoran:   ");
        int index = 1;
        for (String restaurant : restaurantAddressMap.keySet()) {
            System.out.println(index + ". " + centerText(restaurant, 38));
            index++;
        }

        System.out.print("         Pilih nomor restoran yang akan dihapus:   ");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine(); // Clear newline from buffer

        if (selectedIndex >= 1 && selectedIndex <= restaurantAddressMap.size()) {
            String selectedRestaurant = restaurantAddressMap.keySet().toArray(new String[0])[selectedIndex - 1];
            restaurantAddressMap.remove(selectedRestaurant);
            restaurantFoodMenuMap.remove(selectedRestaurant);
            restaurantDrinkMenuMap.remove(selectedRestaurant);

            System.out.println("       Restoran '" + selectedRestaurant + "' berhasil dihapus.       ");
        } else {
            System.out.println("       Nomor restoran tidak valid.       ");
        }
    }

    public static void createOrder() {
        System.out.println("===================================================");
        System.out.println("         Daftar Restoran:   ");
        int index = 1;
        for (String restaurant : restaurantAddressMap.keySet()) {
            System.out.println(index + ". " + centerText(restaurant, 38));
            index++;
        }

        System.out.print("         Pilih nomor restoran untuk memesan:   ");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine(); // Clear newline from buffer

        if (selectedIndex >= 1 && selectedIndex <= restaurantFoodMenuMap.size()) {
            String selectedRestaurant = restaurantFoodMenuMap.keySet().toArray(new String[0])[selectedIndex - 1];
            Map<String, Double> foodMenu = restaurantFoodMenuMap.get(selectedRestaurant);
            Map<String, Double> drinkMenu = restaurantDrinkMenuMap.get(selectedRestaurant);

            System.out.println("       Menu Restoran " + selectedRestaurant + ":");

            System.out.println("       Menu Makanan: ");
            int itemIndex = 1;
            for (String foodItem : foodMenu.keySet()) {
                System.out.println(itemIndex + ". " + centerText(foodItem, 36) + " - Rp" + foodMenu.get(foodItem));
                itemIndex++;
            }

            System.out.println("       Menu Minuman: ");
            for (String drinkItem : drinkMenu.keySet()) {
                System.out.println(itemIndex + ". " + centerText(drinkItem, 36) + " - Rp" + drinkMenu.get(drinkItem));
                itemIndex++;
            }

            System.out.print("         Pilih nomor menu:   ");
            int selectedMenuIndex = scanner.nextInt();
            scanner.nextLine(); // Clear newline from buffer

            if (selectedMenuIndex >= 1 && selectedMenuIndex <= foodMenu.size() + drinkMenu.size()) {
                String selectedItem;
                double price;

                if (selectedMenuIndex <= foodMenu.size()) {
                    selectedItem = (String) foodMenu.keySet().toArray()[selectedMenuIndex - 1];
                    price = foodMenu.get(selectedItem);
                } else {
                    selectedItem = (String) drinkMenu.keySet().toArray()[selectedMenuIndex - foodMenu.size() - 1];
                    price = drinkMenu.get(selectedItem);
                }

                System.out.print("       Masukkan kuantitas pesanan:   ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Clear newline from buffer

                System.out.print("       Masukkan jarak ke lokasi antar (km):   ");
                double distance = scanner.nextDouble();
                scanner.nextLine(); // Clear newline from buffer

                double total = price * quantity * distance;
                System.out.println("       Pesanan berhasil dibuat: " + centerText(selectedItem, 30) + " sejumlah " + quantity + " dengan total harga Rp" + total);
                orderList.add(selectedItem + " (" + selectedRestaurant + ")");

                System.out.print("       Apakah Anda ingin melakukan pemesanan lagi? (y/n):   ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("y")) {
                    return;
                }
            } else {
                System.out.println("       Nomor menu tidak valid.       ");
            }
        } else {
            System.out.println("       Nomor restoran tidak valid.       ");
        }
    }

    public static void showOrder() {
        if (orderList.isEmpty()) {
            System.out.println("===================================================");
            System.out.println("       Belum ada pesanan.       ");
        } else {
            System.out.println("===================================================");
            System.out.println("\n       Pesanan Anda:       ");
            for (String order : orderList) {
                System.out.println(order);
            }
        }
    }

    // Method to center text
    public static String centerText(String text, int width) {
        return String.format("%-" + width / 2 + "s%s%" + width / 2 + "s", "", text, "");
    }
}
