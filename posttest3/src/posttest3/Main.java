package posttest3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList <ikanHias> arrIkanHias = new ArrayList<ikanHias>();
  static Scanner inputData = new Scanner(System.in);
  
  static void readData(){
    for (int i = 0; i < arrIkanHias.size(); i++) {
      System.out.println(i+1);
      System.out.println("\tNama Ikan   : "+arrIkanHias.get(i).getKode());
      System.out.println("\tNama Ikan   : "+arrIkanHias.get(i).getNama());
      System.out.println("\tWarna Ikan  : "+arrIkanHias.get(i).getWarna());
      System.out.println("\tJumlah Ikan : "+arrIkanHias.get(i).getJumlah());
    }
  }

  public static void main(String[] args) throws IOException {
    
    String pilihMenu, namaIkan, warnaIkan, data;
    int jumlahIkan=0, ind, kodeDef = 10001;
    boolean lanjutProgram = true;

    
    
    System.out.println("-------------------------------------------");
    System.out.println("      S i s t e m   M a n a j e m e n      ");
    System.out.println("   P e n j u a l a n   I k a n   H i a s   ");
    System.out.println("-------------------------------------------");

    while (lanjutProgram == true) {
      // clearScreen();
      System.out.println("[1] Tambah data ikan");
      System.out.println("[2] Tampil data ikan");
      System.out.println("[3] Ubah data ikan");
      System.out.println("[4] Hapus data ikan");
      System.out.println("[5] Keluar program\n");

      System.out.print("\tMasukkan Pilihan: "); pilihMenu = inputData.next();
      switch (pilihMenu) {
        case "1":
          // CREATE
          System.out.println("-------------------------------------------");
          System.out.println("      t a m b a h   d a t a   i k a n      ");
          System.out.println("-------------------------------------------");
          System.out.print("\tNama Ikan   : "); namaIkan = inputData.next();
          System.out.print("\tWarna Ikan  : "); warnaIkan = inputData.next();
          System.out.print("\tJumlah Ikan : "); jumlahIkan = inputData.nextInt();
          while (true) {
            System.out.print("Apakah Anda yakin ingin menambahkan data ini? [y/n] : "); data = inputData.next();
            if (data.equalsIgnoreCase("y")) {
              arrIkanHias.add(new ikanHias(kodeDef, namaIkan, warnaIkan, jumlahIkan));
              System.out.println("data berhasil ditambah");
              kodeDef++;
              break;
            }
            else if (data.equalsIgnoreCase("n")) {
              System.out.println("data batal ditambah");
              break;
            }
            else {
              System.err.println("masukkan jawaban y/n!");
            }  
          }
          enterToBack();
          break;

        case "2":
          // READ
          System.out.println("-------------------------------------------");
          System.out.println("      t a m p i l   d a t a   i k a n      ");
          System.out.println("-------------------------------------------");
          readData();
          enterToBack();
          break;

        case "3":
          // UPDATE
          System.out.println("-------------------------------------------");
          System.out.println("        u b a h   d a t a   i k a n        ");
          System.out.println("-------------------------------------------");
          readData();
          System.out.print("Ubah data ikan nomor : "); ind = inputData.nextInt() - 1;
          System.out.println("-------------------------------------------");
          System.out.println("\tNama Ikan   : "+arrIkanHias.get(ind).getKode());
          System.out.println("\tNama Ikan   : "+arrIkanHias.get(ind).getNama());
          System.out.println("\tWarna Ikan  : "+arrIkanHias.get(ind).getWarna());
          System.out.println("\tJumlah Ikan : "+arrIkanHias.get(ind).getJumlah());
          System.out.println("-------------------------------------------");
          System.out.println("Ubah data menjadi : ");
          System.out.println("-------------------------------------------");
          System.out.print("\tNama Ikan   : "); namaIkan = inputData.next();
          System.out.print("\tJumlah Ikan : "); jumlahIkan = inputData.nextInt();
          System.out.print("\tWarna Ikan  : "); warnaIkan = inputData.next();
          while (true) {
            System.out.print("Apakah Anda yakin ingin mengubah data ini? [y/n] : "); data = inputData.next();
            if (data.equalsIgnoreCase("y")) {
              for (ikanHias mngIkanHias : arrIkanHias){
                  if (mngIkanHias.getKode() == arrIkanHias.get(ind).getKode()){
                      mngIkanHias.setNama(namaIkan);
                      mngIkanHias.setWarna(warnaIkan);
                      mngIkanHias.setJumlah(jumlahIkan);
                      break;
                  }
              }
              System.out.println("data berhasil diubah");
              break;
            }
            else if (data.equalsIgnoreCase("n")) {
              System.out.println("data batal diubah");
              break;
            }
            else {
              System.err.println("masukkan jawaban y/n!");
            }  
          }
          enterToBack();
          break;

        case "4":
          // DELETE
          System.out.println("-------------------------------------------");
          System.out.println("       h a p u s   d a t a   i k a n       ");
          System.out.println("-------------------------------------------");
          readData();
          System.out.print("Hapus data ikan nomor : "); ind = inputData.nextInt() - 1;
          System.out.println("-------------------------------------------");
          System.out.println("\tNama Ikan   : "+arrIkanHias.get(ind).getKode());
          System.out.println("\tNama Ikan   : "+arrIkanHias.get(ind).getNama());
          System.out.println("\tWarna Ikan  : "+arrIkanHias.get(ind).getWarna());
          System.out.println("\tJumlah Ikan : "+arrIkanHias.get(ind).getJumlah());
          while (true) {
            System.out.print("Apakah Anda yakin ingin menghapus data ini? [y/n] : "); data = inputData.next();
            if (data.equalsIgnoreCase("y")) {
              arrIkanHias.remove(ind);
              System.out.println("data berhasil dihapus");
              break;
            }
            else if (data.equalsIgnoreCase("n")) {
              System.out.println("data batal dihapus");
              break;
            }
            else {
              System.err.println("masukkan jawaban y/n!");
            }  
          }
          enterToBack();
          break;

        case "5":
          lanjutProgram = false;
          System.out.println("-------------------------------------------");
          System.out.println("      p r o g r a m   b e r h e n t i      ");
          System.out.println("-------------------------------------------");
          break;

        default:
          System.err.println("Pilih menu 1-5!");
          break;
      }
    }
  }
  static void clearScreen() {
    try {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            // clear screen untuk windows
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } else {
            // clear screen untuk Linux, Unix, Mac
            Runtime.getRuntime().exec("clear");
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (final Exception e) {
        System.out.println("Error karena: " + e.getMessage());
    }
}
  
  static void enterToBack(){
    System.out.println("");
    System.out.print("Tekan [Enter] untuk kembali.."); inputData.nextLine();
    clearScreen();
  }
}
