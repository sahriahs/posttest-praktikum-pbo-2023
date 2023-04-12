/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest6;


import java.util.ArrayList;

public abstract class user {
    private String username, password;
    
    static ArrayList <stationary> arrStationary = new ArrayList<>();
    static ArrayList<keranjang> arrKeranjang = new ArrayList<>();
    
    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    final void readData() {
        for (int i = 0; i < arrStationary.size(); i++) {
            System.out.println(i + 1);
            System.out.println("\tKode Barang   : " + arrStationary.get(i).kode);
            System.out.println("\tNama Barang   : " + arrStationary.get(i).nama);
            System.out.println("\tWarna Barang  : " + arrStationary.get(i).warna);
            System.out.println("\tHarga Barang  : " + arrStationary.get(i).harga);
            System.out.println("\tJumlah Barang : " + arrStationary.get(i).stok);
        }
    }
    
    //abstract static boolean login(String username, String pass);
    
    abstract void riwayatPembelian();
    
    int size(){
        return arrStationary.size();
    }
}
