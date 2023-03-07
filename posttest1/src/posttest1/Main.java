package posttest1;

import java.util.ArrayList;
import java.io.IOException;

import java.util.Scanner;

class ikanHias {
  String nama;
  int jumlah;
  String warna;

  public ikanHias(String nama, int jumlah, String warna){
    this.nama = nama;
    this.jumlah = jumlah;
    this.warna = warna;
  }
}

public class Main {
  static ArrayList <ikanHias> arrIkanHias = new ArrayList<ikanHias>();
  
  static void readData(){
    for (int i = 0; i < arrIkanHias.size(); i++) {
      System.out.println(i+1);
      System.out.println("\tNama Ikan   : "+arrIkanHias.get(i).nama);
      System.out.println("\tWarna Ikan  : "+arrIkanHias.get(i).warna);
      System.out.println("\tJumlah Ikan : "+arrIkanHias.get(i).jumlah);
    }
  }

  public static void main(String[] args) throws IOException {

    String namaIkan, warnaIkan;
    int jumlahIkan, ind;
    boolean lanjutProgram = true;

    Scanner inputData = new Scanner(System.in);
    String pilihMenu;
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
          System.out.println("      t a m b a h   d a t a   i k a n");
          System.out.println("-------------------------------------------");
          System.out.print("\tNama Ikan   : "); namaIkan = inputData.next();
          System.out.print("\tJumlah Ikan : "); jumlahIkan = inputData.nextInt();
          System.out.print("\tWarna Ikan  : "); warnaIkan = inputData.next();
          arrIkanHias.add(new ikanHias(namaIkan, jumlahIkan, warnaIkan));
          break;

        case "2":
          // READ
          System.out.println("-------------------------------------------");
          System.out.println("      t a m p i l   d a t a   i k a n");
          System.out.println("-------------------------------------------");
          readData();
          break;

        case "3":
          // UPDATE
          System.out.println("-------------------------------------------");
          System.out.println("        u b a h   d a t a   i k a n        ");
          System.out.println("-------------------------------------------");
          readData();
          System.out.print("Ubah data ikan nomor : "); ind = inputData.nextInt() - 1;
          System.out.println("-------------------------------------------");
          System.out.println("\tNama Ikan   : "+arrIkanHias.get(ind).nama);
          System.out.println("\tWarna Ikan  : "+arrIkanHias.get(ind).warna);
          System.out.println("\tJumlah Ikan : "+arrIkanHias.get(ind).jumlah);
          System.out.println("-------------------------------------------");
          System.out.println("Ubah data menjadi : ");
          System.out.println("-------------------------------------------");
          System.out.print("\tNama Ikan   : "); namaIkan = inputData.next();
          System.out.print("\tJumlah Ikan : "); jumlahIkan = inputData.nextInt();
          System.out.print("\tWarna Ikan  : "); warnaIkan = inputData.next();
          arrIkanHias.set(ind, new ikanHias(namaIkan, jumlahIkan, warnaIkan));
          break;

        case "4":
          // DELETE
          System.out.println("-------------------------------------------");
          System.out.println("       h a p u s   d a t a   i k a n       ");
          System.out.println("-------------------------------------------");
          readData();
          System.out.print("Delete indeks berapa: ");
          ind = inputData.nextInt() - 1;
          arrIkanHias.remove(ind);
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
}