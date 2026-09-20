package assignments;

public class myADT {
    public static void main(String[] args) {
        int[] arr = {30, 87, 90, 3, 1, 50, 23, 4, 25, 23, 40, 35, 47, 2, 33};
        System.out.println("array awal: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("\nUrut data array: ");
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr [j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int ar : arr) {
            System.out.print(ar + " ");
        }
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        double mean = total / arr.length;
        System.out.println();
        System.out.println("\nRata2: ");
        System.out.println(mean);
        System.out.println();

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("MAX: " + max);
        System.out.println("MIN: " + min);
        System.out.println();

        System.out.print("ganjil : ");
        for (int nilai : arr) {
            if (nilai % 2 != 0) {
                System.out.print(nilai + " ");
            }
        }
        System.out.println();
        System.out.print("prima  : ");
        for (int nilai : arr) {
            if (nilai > 1) {
                boolean prima = true;
                for (int j = 2; j <= Math.sqrt(nilai); j++) {
                    if (nilai % j == 0) {
                        prima = false;
                        break;
                    }
                }
                if (prima) {
                    System.out.print(nilai + " ");
                }
            }
        }
        System.out.println("\n");

        // 4. ARRAY 2 DIMENSI (3x5)
        System.out.println("array 2 dimensi");
        int baris = 3;
        int kolom = 5;
        int[][] arr2D = new int[baris][kolom];
        int index = 0;

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                arr2D[i][j] = arr[index++];
                System.out.print(arr2D[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
