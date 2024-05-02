import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminRestaurant {
    private static List<String> restaurantList = new ArrayList<>();
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
            System.out.println("\n=== Menu Admin Restoran ===");
            System.out.println("1. Lihat Daftar Restoran");
            System.out.println("2. Tambah Restoran");
            System.out.println("3. Hapus Restoran");
            System.out.println("4. Kembali ke Login");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (choice) {
                case 1:
                    showRestaurantList();
                    break;
                case 2:
                    addRestaurant();
                    break;
                case 3:
                    deleteRestaurant();
                    break;
                case 4:
                    System.out.println("Keluar dari menu admin.");
                    isAdminMenuActive = false;
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

    public static void addRestaurant() {
        System.out.print("Masukkan nama restoran yang baru: ");
        String newRestaurant = scanner.nextLine();
        restaurantList.add(newRestaurant);
        System.out.println("Restoran '" + newRestaurant + "' berhasil ditambahkan.");
    }

    public static void deleteRestaurant() {
        System.out.println("Daftar Restoran:");
        for (int i = 0; i < restaurantList.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantList.get(i));
        }

        System.out.print("Pilih nomor restoran yang akan dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline dari buffer

        if (index >= 1 && index <= restaurantList.size()) {
            String deletedRestaurant = restaurantList.remove(index - 1);
            System.out.println("Restoran '" + deletedRestaurant + "' berhasil dihapus.");
        } else {
            System.out.println("Nomor restoran tidak valid.");
        }
    }
}
