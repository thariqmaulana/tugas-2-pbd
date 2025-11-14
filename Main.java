import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
   static ArrayList<Order> orders = new ArrayList<>();
   static Scanner input = new Scanner(System.in);
   static boolean mainMenuCondition = true;
   static ArrayList<Menu> menus = new ArrayList<>(Arrays.asList(
         new Menu("Bakso", 15000, "Foods"),
         new Menu("Ayam Goreng", 20000, "Foods"),
         new Menu("Rendang", 30000, "Foods"),
         new Menu("Spageti", 20000, "Foods"),
         new Menu("Jus Apel", 12000, "Drinks"),
         new Menu("Milkshake", 25000, "Drinks"),
         new Menu("Air Mineral", 5000, "Drinks"),
         new Menu("Wedang Jahe", 10000, "Drinks")));

   public static void main(String[] args) {

      while (mainMenuCondition) {
         System.out.println("=== Aplikasi Restoran Java ===");
         System.out.println("Pilih Menu dengan tulis angka");
         System.out.println("1. Menu Pelanggan");
         System.out.println("2. Menu Karyawan");
         System.out.println("3. Keluar");
         String pilihanMenu = input.nextLine();

         switch (pilihanMenu) {
            case "1":
               menuPelanggan();
               break;
            case "2":
               menuKaryawan();
               break;
            case "3":
               System.out.println("Terimakasih telah menggunakan aplikasi restoran java");
               mainMenuCondition = false;
               break;
            default:
               System.out.println("Pilihan tidak valid. Masukkan nomor yang tersedia");
         }
         // break;
      }
      input.close();
   }

   static void menuKaryawan() {
      boolean karyawan = true;
      while (karyawan) {
         System.out.println("Selamat datang di menu karyawan restoran java");
         System.out.println("Pilih Menu dengan tulis angka");
         System.out.println("1. Tambah menu");
         System.out.println("2. Ubah harga");
         System.out.println("3. Hapus menu");
         System.out.println("(Tulis 'x' jika ingin kembali ke menu utama)");
         String pilihanMenuKaryawan = input.nextLine();

         switch (pilihanMenuKaryawan) {
            case "1":
               tambahMenu();
               break;
            case "2":
               ubahHarga();
               break;
            case "3":
               hapusMenu();
               break;
            case "x":
               karyawan = false;
               break;
            default:
               System.out.println("Pilihan tidak valid. Masukkan nomor yang tersedia");
         }
      }
   }

   static void ubahHarga() {
      while (true) {
         System.out.println(
               "Silakan mengubah harga menu dengan format nama menu = harga menu baru. contoh: bakso = 25000");
         System.out.println("Tekan x untuk kembali");
         System.out.println("Daftar Menu");
         int noDaftarMenu = 1;
         System.out.println("Makanan");
         for (int i = 0; i < menus.size(); i++) {
            if ("Foods".equalsIgnoreCase(menus.get(i).category)) {
               Menu item = menus.get(i);
               System.out
                     .println((noDaftarMenu) + ". " + item.name + ": " + item.price + " - "
                           + item.category);
               noDaftarMenu++;
            }
         }

         System.out.println("Minuman");
         for (int i = 0; i < menus.size(); i++) {
            if ("Drinks".equalsIgnoreCase(menus.get(i).category)) {
               Menu item = menus.get(i);
               System.out
                     .println((noDaftarMenu) + ". " + item.name + ": " + item.price + " - "
                           + item.category);
               noDaftarMenu++;
            }
         }
         String item = input.nextLine();

         if ("x".equalsIgnoreCase(item)) {
            break;
         }

         if (item.trim().isEmpty()) {
            continue;
         }

         String[] parts = item.split("=");

         if (parts.length != 2) {
            System.out.println("Format yang anda masukkan salah");
            continue;
         }

         String name = parts[0].trim();
         int price = Integer.parseInt(parts[1].trim());
         boolean found = false;
         for (Menu menu : menus) {
            if (menu.name.equalsIgnoreCase(name)) {
               menu.price = price;
               System.out.println("Harga berhasil diubah");
               found = true;
               break;
            }
         }

         if (!found) {
            System.out.println("Menu tidak ditemukan. Mohon input menu yang tersedia");
         }
      }
   }

   static void hapusMenu() {
      while (true) {
         System.out.println(
               "Silakan hapus menu dengan format menulis nama menu");
         System.out.println("Tekan x untuk kembali");
         System.out.println("Daftar Menu");
         int noDaftarMenu = 1;
         System.out.println("Makanan");
         for (int i = 0; i < menus.size(); i++) {
            if ("Foods".equalsIgnoreCase(menus.get(i).category)) {
               Menu item = menus.get(i);
               System.out
                     .println((noDaftarMenu) + ". " + item.name + ": " + item.price + " - "
                           + item.category);
               noDaftarMenu++;
            }
         }

         System.out.println("Minuman");
         for (int i = 0; i < menus.size(); i++) {
            if ("Drinks".equalsIgnoreCase(menus.get(i).category)) {
               Menu item = menus.get(i);
               System.out
                     .println((noDaftarMenu) + ". " + item.name + ": " + item.price + " - "
                           + item.category);
               noDaftarMenu++;
            }
         }
         String item = input.nextLine();

         if ("x".equalsIgnoreCase(item)) {
            break;
         }

         if (item.trim().isEmpty()) {
            continue;
         }

         boolean found = false;
         for (int i = 0; i < menus.size(); i++) {
             if (menus.get(i).name.equalsIgnoreCase(item)) {
               menus.remove(i);
               System.out.println("Menu berhasil dihapus");
               found = true;
               break;
            }
         }

         if (!found) {
            System.out.println("Menu tidak ditemukan. Mohon input menu yang tersedia");
         }
      }
   }

   static void tambahMenu() {
      while (true) {
         System.out.println(
               "Silakan menambah menu dengan format nama menu = harga menu = kategori. contoh: bakso = 15000 = Foods / Drinks");
         System.out.println("Tekan x untuk kembali");
         String item = input.nextLine();

         if ("x".equalsIgnoreCase(item)) {
            break;
         }

         if (item.trim().isEmpty()) {
            continue;
         }

         String[] parts = item.split("=");

         if (parts.length != 3) {
            System.out.println("Format yang anda masukkan salah");
            return;
         } else {
            String name = parts[0].trim();
            int price = Integer.parseInt(parts[1].trim());
            String category = parts[2].trim();

            menus.add(new Menu(name, price, category));
         }

      }
   }

   static void menuPelanggan() {
      boolean pelanggan = true;
      while (pelanggan) {
         System.out.println("=== Daftar Menu Restoran Java ===");
         System.out.println("(Tulis 'kembali' jika ingin kembali ke menu utama)");

         int noDaftarMenu = 1;
         System.out.println("Makanan");
         for (int i = 0; i < menus.size(); i++) {
            if ("Foods".equalsIgnoreCase(menus.get(i).category)) {
               Menu item = menus.get(i);
               System.out
                     .println((noDaftarMenu) + ". " + item.name + ": " + item.price + " - "
                           + item.category);
               noDaftarMenu++;
            }
         }

         System.out.println("Minuman");
         for (int i = 0; i < menus.size(); i++) {
            if ("Drinks".equalsIgnoreCase(menus.get(i).category)) {
               Menu item = menus.get(i);
               System.out
                     .println((noDaftarMenu) + ". " + item.name + ": " + item.price + " - "
                           + item.category);
               noDaftarMenu++;
            }
         }

         System.out.println(
               "Masukkan pesanan anda dalam format -> Nama menu = Kuantitas. Tulis 'selesai' untuk menyelesaikan");

         int total = 0;
         do {
            System.out.println("Pesanan :");
            String item = input.nextLine();

            if (orders.isEmpty() && item.trim().equalsIgnoreCase("kembali")) {
               pelanggan = false;
               break;
            }

            if (item.trim().equalsIgnoreCase("selesai")) {
               mainMenuCondition = false;
               System.out.println("Terimakasih atas kunjungan anda");
               break;
            }
            total += calculateOrders(item, menus);
         } while (true);

         boolean b1g1 = total > 50000;
         String freeDrink;

         while (b1g1) {
            System.out
                  .println("Total biaya pesanan anda melebihi 50000. anda mendapat kesempatan beli minum 1 gratis 1");
            System.out
                  .println(
                        "Masukka minuman yang anda pilih dengan format nama minuman = kuantitas. tulis 'selesai' untuk membatalkan");
            System.out.println("Daftar Minuman");

            int nomor = 1;
            for (int i = 0; i < menus.size(); i++) {
               if ("Drinks".equalsIgnoreCase(menus.get(i).category)) {
                  Menu item = menus.get(i);
                  System.out.println((nomor) + ". " + item.name + ": "
                        + item.price + " - "
                        + item.category);
                  nomor++;
               }
            }

            freeDrink = input.nextLine();
            if (!freeDrink.equalsIgnoreCase("selesai") && !freeDrink.isEmpty()) {
               int bonusSubtotal = calculateFreeDrinks(freeDrink, menus);
               total += bonusSubtotal;
               if (bonusSubtotal != 0) {
                  break;
               }
            }
            if (freeDrink.equalsIgnoreCase("selesai")) {
               break;
            }
         }

         double discount = 0;
         if (total > 100_000) {
            discount = total * 0.1;
         }

         double totalAfterDiscount = total - discount;
         double tax = totalAfterDiscount * 0.1;
         int serviceFee = 20000;
         double finalTotal = totalAfterDiscount + tax + serviceFee;

         if (!orders.isEmpty()) {
            System.out.println("=== Struk Pembayaran ===");
            for (int i = 0; i < orders.size(); i++) {
               Order order = orders.get(i);
               if ("free".equalsIgnoreCase(order.type)) {
                  System.out.println(
                        order.name + " (" + order.qty + "pcs) + 1(gratis) = " + "Rp. " + order.subtotal);
               } else {
                  System.out.println(
                        order.name + " (" + order.qty + "pcs) = Rp. " + order.subtotal);
               }

            }
            System.out.println("-----------------");
            System.out.println("Total biaya pesanan = Rp. " + total);
            if (discount != 0) {
               System.out.println("Selamat anda mendapat diskon sebesar 10% - " + discount);
               System.out.println("Total setelah diskon Rp. " + totalAfterDiscount);
            }

            System.out.println("Pajak 10% = " + tax);
            System.out.println("Service fee = " + serviceFee);
            System.out.println("----------");
            System.out.println("Total Akhir = " + finalTotal);
            System.out.println("Terimakasih atas kunjungan anda");

            mainMenuCondition = false;
         }
         break;
      }

   }

   static int calculateOrders(String item, ArrayList<Menu> menus) {
      if (item.trim().isEmpty())
         return 0;

      String[] parts = item.split("=");

      if (parts.length != 2) {
         return 0;
      }

      String name = parts[0].trim();
      int qty = Integer.parseInt(parts[1].trim());

      int subtotal = 0;
      for (Menu menu : menus) {
         if (menu.name.equalsIgnoreCase(name)) {
            subtotal = menu.price * qty;
            break;
         }
      }

      orders.add(new Order(name, qty, subtotal, "default"));

      return subtotal;
   }

   static int calculateFreeDrinks(String item, ArrayList<Menu> menus) {
      String[] parts = item.split("=");

      if (parts.length != 2) {
         return 0;
      }

      String name = parts[0].trim();
      int qty = Integer.parseInt(parts[1].trim());

      int subtotal = 0;
      for (Menu menu : menus) {
         if (menu.name.equalsIgnoreCase(name)) {
            subtotal = menu.price * qty;
            break;
         }
      }

      orders.add(new Order(name, qty, subtotal, "free"));
      return subtotal;
   }
}
