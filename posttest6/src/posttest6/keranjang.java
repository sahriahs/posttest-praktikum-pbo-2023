/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest6;

/**
 *
 * @author Lenovo
 */
final class keranjang {
    protected String kodeKeranjang;
    protected String kodePembeli;
    protected String kodeBarang[];
    protected int banyak[];

    public keranjang(String kodeKeranjang, String kodePembeli, String[] kodeBarang, int[] banyak) {
        this.kodeKeranjang = kodeKeranjang;
        this.kodePembeli = kodePembeli;
        this.kodeBarang = kodeBarang;
        this.banyak = banyak;
    }
}
