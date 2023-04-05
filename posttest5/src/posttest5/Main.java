/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package posttest5;

/**
 *
 * @author Lenovo
 */
import java.util.Scanner;

public class Main {

    
    static String pilihMenu, username, pass, konfirPass;
    static Scanner inputData = new Scanner(System.in);
    static Scanner inputInt = new Scanner(System.in);

    static admin DataAdm = new admin("admin", "admin2023");
    static pembeli DataPembeli = new pembeli("p01","sahriah", "sahriah087");

    /**
     * @param args the command line arguments
     */
    static void login() {
        while (true) {
            System.out.print("Masukkan username : ");
            username = inputData.next();
            System.out.print("Masukkan password : ");
            pass = inputData.next();
            if (DataAdm.login(username, pass) == true) {
                System.out.println("menu admin");
                if (DataAdm.menu() == 5) {
                    break;
                }
            } else if (DataPembeli.login(username, pass) == true) {
                System.out.println("menu pembeli");
                if (DataPembeli.menu() == 5) {
                    break;
                }
            } else {
                System.out.println("username atau kata sandi slaj !!!");
            }
        }

    }

    static void buatAkun() {
        while (true) {
            System.out.println("Buat Akun : ");
            System.out.print("           username : ");
            username = inputData.next();
            System.out.print("           password : ");
            pass = inputData.next();
            System.out.print("Konfirmasi Password : ");
            konfirPass = inputData.next();
            if (pass.equals(konfirPass)) {
                if (DataPembeli.newAkun(username, new pembeli("p01", username, pass)) == true) {
                    System.out.println("Berhasil membuat akun");
                    break;
                } else {
                    System.out.println("username telah digunakan");
                }
            } else {
                System.out.println("Password tidak sesuai");
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {
            System.out.println("[1] login");
            System.out.println("[2] buat akun");
            System.out.println("[3] end progam");
            System.out.print("\tMasukkan Pilihan: ");
            pilihMenu = inputData.next();
            if (pilihMenu.equalsIgnoreCase("1")) {
                login();
            } else if (pilihMenu.equalsIgnoreCase("2")) {
                buatAkun();
            } else if (pilihMenu.equalsIgnoreCase("3")) {
                break;
            } else {
                System.err.println("Pilih menu 1-3!");
            }
        }
    }
}

