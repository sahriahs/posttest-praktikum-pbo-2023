/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest4;

/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import static posttest4.Main.inputData;
import static posttest4.Main.inputInt;

public class pembeli extends user {

    public pembeli(String username, String password) {
        super(username, password);
    }

    static ArrayList<pembeli> arrPembeli = new ArrayList<>();
    static ArrayList<keranjang> arrKeranjang = new ArrayList<>();

    boolean newAkun(String newUsername, pembeli newData) {
        for (int i = 0; i < pembeli.arrPembeli.size(); i++) {
            if (pembeli.arrPembeli.get(i).getUsername().equals(newUsername)) {
                return false;
            }
        }
        newAkun(newData);
        return true;
    }
    
    void newAkun(pembeli data){
        pembeli.arrPembeli.add(data);
    }

    @Override
    boolean login(String usernamePembeli, String passPembeli) {

        for (int i = 0; pembeli.arrPembeli.size() > i; i++) {
            if (pembeli.arrPembeli.get(i).getUsername().equals(usernamePembeli) && pembeli.arrPembeli.get(i).getPassword().equals(passPembeli)) {
                return true;
            }
        }
        return false;
    }

    int menu() {
        while (true) {
            // clearScreen();
            System.out.println("[1] Pemesanan Barang");
//            System.out.println("[2] Tampil data ikan");
//            System.out.println("[3] Ubah data ikan");
//            System.out.println("[4] Hapus data ikan");
            System.out.println("[5] Keluar program");

            System.out.print("\tMasukkan Pilihan: ");
            String pilihMenu = inputData.next();
            switch (pilihMenu) {
                case "1" -> {
                    System.out.println("pemesanan");
                    this.pemesananBarang();
                }
//
//                case "2" -> {// READ
//                    System.out.println("tampil data");
//                }
//
//                case "3" -> {// UPDATE
//                    System.out.println("update");
//                }
//
//                case "4" -> // DELETE
//                    System.out.println("delete");

                case "5" -> {
                    System.out.println("keluar");
                    return 5;
                }

                default ->
                    System.err.println("Pilih menu 1-5!");
            }
        }
    }

    void pemesananBarang() {
        int ind, banyakBarang = 0, jumlahHarga, totalHarga = 0, i=0;
        String data;
        boolean ulang = true;
        System.out.println("-------------------------------------------");
        System.out.println("      p e m e s a n a n   b a r a n g      ");
        System.out.println("-------------------------------------------");
        super.readData();
        while (ulang) {
            System.out.print("pilih barang  : ");
            ind = inputData.nextInt() - 1;
            System.out.print("banyak barang : ");
            banyakBarang = inputInt.nextInt();
            keranjang baru = new keranjang(arrStationary.get(ind).kode, banyakBarang);
            pembeli.arrKeranjang.add(baru);
            while (true) {
                System.out.println("Tambah pesanan? [y/n]");
                data = inputData.next();
                if (data.equalsIgnoreCase("y")) {
                    break;
                } else if (data.equalsIgnoreCase("n")) {
                    ulang = false;
                    break;
                } else {
                    System.err.println("masukkan jawaban y/n!");
                }
            }
        }
        System.out.println("Nama    Harga    Banyak barang    Jumlah");
        for (int j = 0; j < arrKeranjang.size(); j++) {
            for (i = 0; i < arrStationary.size(); i++) {
                if(arrStationary.get(i).kode.equals(arrKeranjang.get(j).kode)){
                    break;
                }
            }
            jumlahHarga = arrStationary.get(i).harga*arrKeranjang.get(j).banyak;
            System.out.println(arrStationary.get(i).nama + arrStationary.get(i).harga + arrKeranjang.get(j).banyak + jumlahHarga);
            totalHarga= totalHarga + jumlahHarga;
            
        }
        System.out.println("total      : Rp" + totalHarga);
        

    }
}
