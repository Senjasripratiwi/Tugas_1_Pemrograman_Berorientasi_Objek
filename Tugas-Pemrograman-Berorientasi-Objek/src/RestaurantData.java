import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantData {
    private static Map<String, String> restaurantAddressMap = new HashMap<>();
    private static Map<String, Map<String, Double>> restaurantMenuMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isLoggedIn = false;

        // Simulasi proses login
        while (!isLoggedIn) {
            isLoggedIn = login();
        }

        // Setelah berhasil login, tampilkan menu admin
        displayAdminMenu();
    }

    public static boolean login() {
        System.out.println("=== Login Admin ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Validasi username dan password
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
            return false;
        }
    }

    public static void displayAdminMenu() {
        boolean isAdminMenuActive = true;

        while (isAdminMenuActive) {
            System.out.println("\n=== Menu Admin Data Restoran ===");
            System.out.println("1. Tambah Data Restoran");
            System.out.println("2. Lihat Data Restoran");
            System.out.println("3. Kembali ke Login");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (choice) {
                case 1:
                    addRestaurantData();
                    break;
                case 2:
                    showRestaurantData();
                    break;
                case 3:
                    System.out.println("Keluar dari menu admin data restoran.");
                    isAdminMenuActive = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void addRestaurantData() {
        System.out.print("Masukkan nama restoran: ");
        String restaurantName = scanner.nextLine();
        System.out.print("Masukkan alamat restoran: ");
        String restaurantAddress = scanner.nextLine();
        restaurantAddressMap.put(restaurantName, restaurantAddress);

        Map<String, Double> menu = new HashMap<>();
        boolean isAddingMenu = true;

        while (isAddingMenu) {
            System.out.print("Masukkan nama makanan: ");
            String foodName = scanner.nextLine();
            System.out.print("Masukkan harga makanan: ");
            double foodPrice = scanner.nextDouble();
            scanner.nextLine(); // Membersihkan newline dari buffer

            menu.put(foodName, foodPrice);

            System.out.print("Tambah makanan lagi? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                isAddingMenu = false;
            }
        }

        restaurantMenuMap.put(restaurantName, menu);
        System.out.println("Data restoran '" + restaurantName + "' berhasil ditambahkan.");
    }

    public static void showRestaurantData() {
        System.out.println("\n=== Data Restoran ===");
        for (String restaurant : restaurantAddressMap.keySet()) {
            System.out.println("Nama Restoran: " + restaurant);
            System.out.println("Alamat: " + restaurantAddressMap.get(restaurant));
            System.out.println("Menu:");

            Map<String, Double> menu = restaurantMenuMap.get(restaurant);
            for (String food : menu.keySet()) {
                System.out.println("- " + food + ": Rp" + menu.get(food));
            }
            System.out.println();
        }
    }
}
