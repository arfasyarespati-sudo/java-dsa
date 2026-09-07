import java.util.Scanner;
public class bangunDatar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("isi panjang: ");
        int panjang = sc.nextInt();
        System.out.print("isi lebar: ");
        int lebar = sc.nextInt();

        System.out.println("Luasnya adalah: ");
        int luas = panjang*lebar;
        System.out.println(luas);
        sc.close();
    }
}

