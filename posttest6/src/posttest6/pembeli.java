package posttest6;

import java.util.ArrayList;
import static posttest6.Main.inputData;
import static posttest6.Main.inputInt;

public class pembeli extends user {
    private String kodePembeli;

    public pembeli(String kodePembeli, String username, String password) {
        super(username, password);
        this.kodePembeli = kodePembeli;
    }
    

    static ArrayList<pembeli> arrPembeli = new ArrayList<>();
    

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

    static boolean login(String usernamePembeli, String passPembeli) {

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
            System.out.println("[2] Riwayat Pembelian");
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

                case "2" -> {// READ
                    System.out.println("riwayat pemesanan");
                    this.riwayatPembelian();
                }
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
        int ind, jumlahHarga, totalHarga = 0, i=0;
        String data, dataKode;
        boolean ulang = true;
        System.out.println("-------------------------------------------");
        System.out.println("      p e m e s a n a n   b a r a n g      ");
        System.out.println("-------------------------------------------");
        super.readData();
        String[] kodeBarang = new String[20];
        int banyak[] = new int[20];
        int pesan = 0;
        while (ulang) {
            System.out.print("pilih barang  : ");
            ind = inputData.nextInt() - 1;
            kodeBarang[pesan] = arrStationary.get(ind).kode;
            System.out.print("banyak barang : ");
            banyak[pesan] = inputInt.nextInt();
            
            while (true) {
                System.out.println("Tambah pesanan? [y/n]");
                data = inputData.next();
                if (data.equalsIgnoreCase("y")) {
                    pesan++;
                    break;
                } else if (data.equalsIgnoreCase("n")) {
                    ulang = false;
                    break;
                } else {
                    System.err.println("masukkan jawaban y/n!");
                }
            }
        }
        keranjang baru = new keranjang("k01", this.kodePembeli, kodeBarang, banyak);
        pembeli.arrKeranjang.add(baru);
        
        System.out.printf("%-10s%-20s%-30s%-20s\n", "Nama",    "Harga","Banyak barang", "Jumlah");
        System.out.println("--------------------------------------------");
//      pembelian
        for (int j = 0; j < arrKeranjang.size(); j++) {
            if (arrKeranjang.get(j).kodeKeranjang.equals("k01")){
                for (int k = 0; k < arrKeranjang.get(j).kodeBarang.length; k++) {
                    dataKode = arrKeranjang.get(j).kodeBarang[k];
//                cek data kode barang pada data 
                    for (i = 0; i < arrStationary.size(); i++) {
                        if (arrStationary.get(i).kode.equals(dataKode)) {
                            jumlahHarga = arrStationary.get(i).harga * arrKeranjang.get(j).banyak[k];
                            System.out.printf("%-10s%-20s%-30s%-20s\n", arrStationary.get(i).nama, arrStationary.get(i).harga, arrKeranjang.get(j).banyak[i], jumlahHarga);
                            totalHarga = totalHarga + jumlahHarga;
                            break;
                        }
                    }
                }
                break;
            }
        }
        System.out.println("total      : Rp" + totalHarga);
    }
    
    @Override
    void riwayatPembelian(){
        String dataKode;
        int jumlahHarga, totalHarga = 0;
        System.out.printf("%-10s%-20s%-30s%-20s\n", "Nama",    "Harga","Banyak barang", "Jumlah");
        System.out.println("--------------------------------------------");
//      pembelian
        for (int j = 0; j < arrKeranjang.size(); j++) {
            if (arrKeranjang.get(j).kodePembeli.equals(this.kodePembeli)){
//            cek data barang
                for (int k = 0; k < arrKeranjang.get(j).kodeBarang.length; k++) {
                    dataKode = arrKeranjang.get(j).kodeBarang[k];
//                cek data kode barang pada data 
                    for (int i = 0; i < arrStationary.size(); i++) {
                        if (arrStationary.get(i).kode.equals(dataKode)) {
                            jumlahHarga = arrStationary.get(i).harga * arrKeranjang.get(j).banyak[k];
                            System.out.printf("%-10s%-20s%-30s%-20s\n", arrStationary.get(i).nama, arrStationary.get(i).harga, arrKeranjang.get(j).banyak[i], jumlahHarga);
                            totalHarga = totalHarga + jumlahHarga;
                            break;
                        }
                    }
                }
                System.out.println("total      : Rp" + totalHarga);
                totalHarga = 0;
            }
        }
    }
}
