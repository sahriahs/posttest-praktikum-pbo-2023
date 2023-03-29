/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest4;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class user {
    private String username, password;
    
    static ArrayList <stationary> arrStationary = new ArrayList<>();

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
    
    void readData() {
        for (int i = 0; i < arrStationary.size(); i++) {
            System.out.println(i + 1);
            System.out.println("\tNama Barang   : " + arrStationary.get(i).kode);
            System.out.println("\tNama Barang   : " + arrStationary.get(i).nama);
            System.out.println("\tWarna Barang  : " + arrStationary.get(i).warna);
            System.out.println("\tHarga Barang : " + arrStationary.get(i).harga);
            System.out.println("\tJumlah Barang : " + arrStationary.get(i).stok);
        }
    }
    
    boolean login(String username, String pass){
        return username==this.username && pass==this.password;
    }
    
    int size(){
        return arrStationary.size();
    }
}
