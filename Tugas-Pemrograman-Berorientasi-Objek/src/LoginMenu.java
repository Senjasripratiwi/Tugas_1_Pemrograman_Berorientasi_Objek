import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginMenu {
    private static Map<String, String> adminCredentials = new HashMap<>();
    private static Map<String, String> customerCredentials = new HashMap<>();

    static {
        // Menambahkan informasi login untuk admin
        adminCredentials.put("admin", "admin123");

        // Menambahkan informasi login untuk pelanggan
        customerCredentials.put("customer", "customer123");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selamat Datang di Sistem Login Restoran");
            System.out.println("Silakan pilih tipe pengguna:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerLogin();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem login Restoran.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }

    public static void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.println("Masukkan password admin: ");
        String password = scanner.nextLine();

        // Memeriksa keberadaan kredensial admin
        if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
            System.out.println("Login admin berhasil!");
            // Lakukan tindakan admin yang sesuai setelah login berhasil
        } else {
            System.out.println("Username atau password admin salah.");
        }
    }

    public static void customerLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan username customer: ");
        String username = scanner.nextLine();
        System.out.println("Masukkan password customer: ");
        String password = scanner.nextLine();

        // Memeriksa keberadaan kredensial pelanggan
        if (customerCredentials.containsKey(username) && customerCredentials.get(username).equals(password)) {
            System.out.println("Login customer berhasil!");
            // Lakukan tindakan pelanggan yang sesuai setelah login berhasil
        } else {
            System.out.println("Username atau password customer salah.");
        }
    }
}
