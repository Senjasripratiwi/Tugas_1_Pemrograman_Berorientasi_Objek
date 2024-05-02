import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderData {
    private static Map<String, Map<String, Double>> restaurantMenuMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        // Tambahkan data restoran dan menu sebagai contoh
        addSampleData();

        // Tampilkan menu pesanan
        displayOrderMenu();
    }

    public static void addSampleData() {
        // Contoh data restoran dan menu
        Map<String, Double> menu1 = new HashMap<>();
        menu1.put("Nasi Goreng", 25000.0);
        menu1.put("Mie Ayam", 20000.0);
        restaurantMenuMap.put("Restoran A", menu1);

        Map<String, Double> menu2 = new HashMap<>();
        menu2.put("Ayam Bakar", 35000.0);
        menu2.put("Sop Buntut", 40000.0);
        restaurantMenuMap.put("Restoran B", menu2);
    }

    public static void displayOrderMenu() {
        // Tampilkan daftar restoran
        System.out.println("Daftar Restoran:");
        int restaurantId = 1;
        for (String restaurantName : restaurantMenuMap.keySet()) {
            System.out.println(restaurantId + ". " + restaurantName);
            restaurantId++;
        }

        // Pilih restoran
        System.out.print("Pilih nomor restoran: ");
        int selectedRestaurantId = scanner.nextInt();
        scanner.nextLine(); // Bersihkan newline dari buffer

        // Validasi nomor restoran
        if (selectedRestaurantId < 1 || selectedRestaurantId > restaurantMenuMap.size()) {
            System.out.println("Nomor restoran tidak valid.");
            return;
        }

        // Ambil nama restoran dari nomor restoran yang dipilih
        String selectedRestaurant = "";
        int index = 1;
        for (String restaurantName : restaurantMenuMap.keySet()) {
            if (index == selectedRestaurantId) {
                selectedRestaurant = restaurantName;
                break;
            }
            index++;
        }

        // Tampilkan menu restoran yang dipilih
        System.out.println("\nMenu Restoran " + selectedRestaurant + ":");
        Map<String, Double> menu = restaurantMenuMap.get(selectedRestaurant);
        int menuId = 1;
        for (String itemName : menu.keySet()) {
            System.out.println(menuId + ". " + itemName + " - Rp" + menu.get(itemName));
            menuId++;
        }

        // Pilih menu
        System.out.print("Pilih nomor menu: ");
        int selectedMenuId = scanner.nextInt();
        scanner.nextLine(); // Bersihkan newline dari buffer

        // Validasi nomor menu
        if (selectedMenuId < 1 || selectedMenuId > menu.size()) {
            System.out.println("Nomor menu tidak valid.");
            return;
        }

        // Ambil nama dan harga menu dari nomor menu yang dipilih
        String selectedMenuItem = "";
        double selectedMenuPrice = 0.0;
        int counter = 1;
        for (String itemName : menu.keySet()) {
            if (counter == selectedMenuId) {
                selectedMenuItem = itemName;
                selectedMenuPrice = menu.get(itemName);
                break;
            }
            counter++;
        }

        // Masukkan jumlah pesanan
        System.out.print("Masukkan kuantitas pesanan: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Bersihkan newline dari buffer

        // Masukkan jarak ke lokasi antar
        System.out.print("Masukkan jarak ke lokasi antar (km): ");
        double distance = scanner.nextDouble();
        scanner.nextLine(); // Bersihkan newline dari buffer

        // Hitung total harga pesanan
        double total = selectedMenuPrice * quantity * distance;

        // Tampilkan detail pesanan
        System.out.println("\nDetail Pesanan:");
        System.out.println("ID Restaurant: " + selectedRestaurantId);
        System.out.println("ID Menu: " + selectedMenuId);
        System.out.println("Menu: " + selectedMenuItem);
        System.out.println("Kuantitas: " + quantity);
        System.out.println("Jarak ke Lokasi Antar: " + distance + " km");
        System.out.println("Total Harga Pesanan: Rp" + total);
    }
}
