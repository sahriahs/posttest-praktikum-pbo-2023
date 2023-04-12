package posttest6;
import static posttest6.Main.inputData;
import static posttest6.Main.inputInt;

public class admin extends user implements menuAdmin{

    private static final String username = "admin";
    private static final String pass = "admin2023";

    public admin(String username, String password) {
        super(username, password);
    }
    
    static boolean login(String usernameAdm, String passAdm) {
        return username.equals(usernameAdm) && pass.equals(passAdm);
    }

    int menu() {
        while (true) {
            // clearScreen();
            System.out.println("[1] Tambah data");
            System.out.println("[2] Tampil data");
            System.out.println("[3] Ubah data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Riwayat pembelian");
            System.out.println("[6] Keluar program");

            System.out.print("\tMasukkan Pilihan: ");
            String pilihMenu = inputData.next();
            switch (pilihMenu) {
                case "1" -> {
                    // CREATE
                    System.out.println("tambah data");
                    this.tambahBarang();
                }
                    
                case "2" -> {
                    // READ
                    if (super.size()>0){
                        System.out.println("tampil data");
                        super.readData();
                        break;
                    }
                    System.out.println("data barang kosong");
                }

                case "3" -> {
                    // UPDATE
                    if (super.size()>0){
                        System.out.println("update");
                        this.updateData();
                        break;
                    }
                    System.out.println("data barang kosong");
                }

                case "4" -> {
                    // DELETE
                    if (super.size()>0){
                        System.out.println("delete");
                        this.deleteData();
                        break;
                    }
                    System.out.println("data barang kosong");
                }
                
                case "5" -> {
                    System.out.println("riwayat pembelian");
                    this.riwayatPembelian();
                }

                case "6" -> {
                    System.out.println("keluar");
                    return 5;
                }

                default -> System.err.println("Pilih menu 1-5!");
            }
        }
    }
    
    @Override
    public void tambahBarang() {
        String kodeBarang, namaBarang, warnaBarang;
        int hargaBarang, jumlahBarang;
        System.out.println("tambah");
        System.out.println("-------------------------------------------");
        System.out.println("    t a m b a h   d a t a   b a r a n g    ");
        System.out.println("-------------------------------------------");
        System.out.print("\tKode Barang   : ");
        kodeBarang = inputData.next();
        System.out.print("\tNama Barang   : ");
        namaBarang = inputData.next();
        System.out.print("\tWarna Barang  : ");
        warnaBarang = inputData.next();
        System.out.print("\tHarga Barang  : ");
        hargaBarang = inputInt.nextInt();
        System.out.print("\tJumlah Barang : ");
        jumlahBarang = inputInt.nextInt();
        arrStationary.add(new stationary(kodeBarang, namaBarang, warnaBarang, hargaBarang, jumlahBarang));
    }
    
    @Override
    public void updateData() {
        // UPDATE
        String kodeBarang, namaBarang, warnaBarang, data;
        int hargaBarang, jumlahBarang;
        System.out.println("-------------------------------------------");
        System.out.println("      u b a h   d a t a   b a r a n g      ");
        System.out.println("-------------------------------------------");
        super.readData();
        System.out.print("Ubah data nomor : ");
        int ind = inputInt.nextInt() - 1;
        System.out.println("-------------------------------------------");
        System.out.println("\tKode Barang   : " + arrStationary.get(ind).kode);
        System.out.println("\tNama Barang   : " + arrStationary.get(ind).nama);
        System.out.println("\tWarna Barang  : " + arrStationary.get(ind).warna);
        System.out.println("\tHarga Barang : " + arrStationary.get(ind).harga);
        System.out.println("\tJumlah Barang : " + arrStationary.get(ind).stok);
        System.out.println("-------------------------------------------");
        System.out.println("Ubah data menjadi : ");
        System.out.println("-------------------------------------------");
        System.out.print("\tNama Barang  : ");
        namaBarang = inputData.next();
        System.out.print("\tWarna Barang : ");
        warnaBarang = inputData.next();
        System.out.print("\tHarga Barang : ");
        hargaBarang = inputInt.nextInt();
        System.out.print("\tJumlah Barang : ");
        jumlahBarang = inputInt.nextInt();
        while (true) {
            System.out.print("Apakah Anda yakin ingin mengubah data ini? [y/n] : ");
            data = inputData.next();
            if (data.equalsIgnoreCase("y")) {
                kodeBarang = arrStationary.get(ind).kode;
                arrStationary.set(ind, new stationary(kodeBarang, namaBarang, warnaBarang, hargaBarang, jumlahBarang));
                System.out.println("data berhasil diubah");
                break;
            } else if (data.equalsIgnoreCase("n")) {
                System.out.println("data batal diubah");
                break;
            } else {
                System.err.println("masukkan jawaban y/n!");
            }
        }
    }
    
    @Override
    public void deleteData(){
        int ind;
        String data;
                  // DELETE
          System.out.println("-------------------------------------------");
          System.out.println("     h a p u s   d a t a   b a r a n g     ");
          System.out.println("-------------------------------------------");
          super.readData();
          System.out.print("Hapus data Barang nomor : "); ind = inputData.nextInt() - 1;
          System.out.println("-------------------------------------------");
          System.out.println("\tKode Barang   : "+arrStationary.get(ind).kode);
          System.out.println("\tNama Barang   : "+arrStationary.get(ind).nama);
          System.out.println("\tWarna Barang  : "+arrStationary.get(ind).warna);
          System.out.println("\tHarga Barang : "+arrStationary.get(ind).harga);
          System.out.println("\tStok Barang : "+arrStationary.get(ind).stok);
          while (true) {
            System.out.print("Apakah Anda yakin ingin menghapus data ini? [y/n] : "); data = inputData.next();
            if (data.equalsIgnoreCase("y")) {
              arrStationary.remove(ind);
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
    }
    
    @Override
    public void riwayatPembelian(){
        String dataKode;
        int jumlahHarga, totalHarga = 0;
        
//      pembelian
        for (int j = 0; j < arrKeranjang.size(); j++) {
            System.out.printf("%-10s%-20s%-30s%-20s\n", "Nama",    "Harga","Banyak barang", "Jumlah");
            System.out.println("--------------------------------------------");
//            cek data barang
            for (int k = 0; k < arrKeranjang.get(j).kodeBarang.length; k++){
                dataKode = arrKeranjang.get(j).kodeBarang[k];
//                cek data kode barang pada data 
                for (int i = 0; i < arrStationary.size(); i++) {
                    if(arrStationary.get(i).kode.equals(dataKode)){
                        jumlahHarga = arrStationary.get(i).harga*arrKeranjang.get(j).banyak[k];
                        System.out.printf("%-10s%-20s%-30s%-20s\n",arrStationary.get(i).nama, arrStationary.get(i).harga, arrKeranjang.get(j).banyak[i], jumlahHarga);
                        totalHarga= totalHarga + jumlahHarga;
                        break;
                    }
                }
            }
            System.out.println("total      : Rp" + totalHarga);
            totalHarga = 0;
            System.out.println("");
        }
        
    }
}


