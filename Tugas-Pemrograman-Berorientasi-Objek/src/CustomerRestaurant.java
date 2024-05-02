import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRestaurant {
    private static List<String> restaurantList = new ArrayList<>();
    private static List<String> orderList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isLoggedIn = false;

        // Simulasi proses login
        while (!isLoggedIn) {
            isLoggedIn = login();
        }

        // Setelah berhasil login, tampilkan menu pelanggan
        displayCustomerMenu();
    }

    public static boolean login() {
        System.out.println("=== Login Customer ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Validasi username dan password
        if (username.equals("customer") && password.equals("customer123")) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
            return false;
        }
    }

    public static void displayCustomerMenu() {
        boolean isCustomerMenuActive = true;

        while (isCustomerMenuActive) {
            System.out.println("\n=== Menu Pelanggan Restoran ===");
            System.out.println("1. Lihat Daftar Restoran");
            System.out.println("2. Buat Pesanan");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Kembali ke Login");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (choice) {
                case 1:
                    showRestaurantList();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    showOrder();
                    break;
                case 4:
                    System.out.println("Keluar dari menu pelanggan.");
                    isCustomerMenuActive = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void showRestaurantList() {
        System.out.println("\nDaftar Restoran:");
        for (String restaurant : restaurantList) {
            System.out.println(restaurant);
        }
    }

    public static void createOrder() {
        System.out.print("Masukkan pesanan Anda: ");
        String order = scanner.nextLine();
        orderList.add(order);
        System.out.println("Pesanan berhasil dibuat: " + order);
    }

    public static void showOrder() {
        if (orderList.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            System.out.println("\nPesanan Anda:");
            for (String order : orderList) {
                System.out.println(order);
            }
        }
    }
}
