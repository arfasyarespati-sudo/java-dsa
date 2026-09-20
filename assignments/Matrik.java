package assignments;

import java.util.Locale;

class Larik {
    private double[] data;

    public Larik(int size) {
        this.data = new double[size];
    }

    public Larik(double[] data) {
        this.data = data.clone();
    }

    public int getSize() {
        return this.data.length;
    }

    public double getItem(int id) {
        return this.data[id];
    }

    public void isiltem(int id, double value) {
        this.data[id] = value;
    }

    public static double LarikKaliLarik(Larik l1, Larik l2) {
        double hasil = 0;
        int n = Math.min(l1.getSize(), l2.getSize());
        for (int i = 0; i < n; i++) {
            hasil += l1.getItem(i) * l2.getItem(i);
        }
        return hasil;
    }

    public void cetak() {
        for (int i = 0; i < data.length; i++) {
            System.out.printf(Locale.US, "%.2f ", data[i]);
        }
        System.out.println();
    }
}

public class Matrik {
    private int nBaris, nKolom;
    private double [][]itemDt;
    /**
     * constructor untuk membuat suatu matrik
     * @param nBrs: banyaknya baris
     * @param nKlm: banyaknya kolom
     */
    public Matrik(int nBrs, int nKlm){
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }
    /**
     * constructor untuk membuat matrik dari array 2 dimensi
     * @param A: array dua dimensi
     */
    public Matrik(double [][]A){
        this(A.length,A[0].length); // panggil contructor
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        
        for (int i=0; i<nBaris; i++){
            for (int j=0; j<nKolom; j++){
                this.itemDt[i][j] = A[i][j];
            }
        }
    }
    /**
     * Fungsi untuk mendapatakan jumlah baris
     * @return jumlah baris
     */
    public int getNBaris(){ return nBaris;}
    public int getNKolom(){ return nKolom;}
    public double getItem(int idB, int idK){
        return this.itemDt[idB][idK];
    }
    public void setItem(int idB, int idK, double dt){
        this.itemDt[idB][idK] = dt;
    }
    /**
     * fungsi tambah antara dua matrik A dan B
     * @param A: Matrik
     * @param B: Matrik
     * @return Matrik hasil
     */
    public static Matrik tambah(Matrik A, Matrik B){
        Matrik C = new Matrik(A.getNBaris(), A.getNKolom());
        for (int i = 0; i < A.getNBaris(); i++) {
            for (int j = 0; j < A.getNKolom(); j++) {
                C.setItem(i, j, A.getItem(i, j) + B.getItem(i, j));
            }
        }
        return C;
    }
    /**
     * fungsi static perkalian antara vektor dengan matrik
     * Syarat: lebar L sama dengan jumlah baris M
     * @param L: Vector (Larik)
     * @param M: Matrik
     * @return Vector (Larik) berdimensi nKolom dari M
     */
    public static Larik VektorKaliMatrik(Larik L, Matrik M){
        Larik lHasil = null;
        Larik lKolom = null;
        if (L.getSize() == M.getNBaris()){
            lHasil = new Larik(M.getNKolom());
            for (int i=0; i<M.getNKolom(); i++){
                lKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiltem(i, hasil);
            }
        }
        return lHasil;
    }
    /**
     * fungsi static tranpos suatu matrik
     * @param A: Matrik
     * @return Matrik tranpos
     */
    public static Matrik tranpos(Matrik A){
        Matrik T = new Matrik(A.getNKolom(), A.getNBaris());
        for (int i = 0; i < A.getNBaris(); i++) {
            for (int j = 0; j < A.getNKolom(); j++) {
                T.setItem(j, i, A.getItem(i, j));
            }
        }
        return T;
    }
    /**
     * fungsi untuk mendapatkan vektor baris dari matrik
     * @param idBaris: indek baris yang akan diekstrak
     * @return Larik representasi baris
     */
    public Larik getBaris(int idBaris){
        Larik l = new Larik(this.nKolom);
        for (int j = 0; j < this.nKolom; j++) {
            l.isiltem(j, this.getItem(idBaris, j));
        }
        return l;
    }
    /**
     * fugsi untuk mendapatkan vektor kolom suatu matrik
     * @param idKolom: id kolom yang akan diekstrak
     * @return Larik representasi kolom
     */
    public Larik getKolom(int idKolom){
        Larik l = new Larik(this.nBaris);
        for (int i=0; i<this.nBaris; i++){
            double itemKolom = this.getItem(i, idKolom);
            l.isiltem(i, itemKolom);
        }
        return l;
    }

    public void cetak() {
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                System.out.printf(Locale.US, "%.2f ", itemDt[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] dataA = {
            {1.00, 2.00, 3.00},
            {3.00, 4.00, 7.00}
        };

        double[][] dataB = {
            {4.00, 5.00, 1.00},
            {6.00, 1.00, 9.00}
        };

        Matrik A = new Matrik(dataA);
        Matrik B = new Matrik(dataB);

        System.out.println("A");
        A.cetak();

        System.out.println("B");
        B.cetak();

        System.out.println("C");
        Matrik C = Matrik.tambah(A, B);
        C.cetak();

        System.out.println("Transpose");
        Matrik C_transpose = Matrik.tranpos(C);
        C_transpose.cetak();

        System.out.println("Baris ke 1 dari C");
        Larik baris1 = C.getBaris(1);
        baris1.cetak();

        Larik L1 = baris1;
        Larik hasilKali = Matrik.VektorKaliMatrik(L1, C_transpose);

        System.out.println("Hasil kali C.L1");
        hasilKali.cetak();
    }
}