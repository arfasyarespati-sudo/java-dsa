package assignments.QuizASD;

public class dsaArray {
    int[] data;
    int size;
    int cap;

    public dsaArray(int cap) {
        this.cap = cap;
        this.data = new int[cap];
        this.size = 0;
    }

    void addFirst(int input) {
        if (size == cap) {
            System.out.println("Array full");
            return;
        }

        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }

        data[0] = input;
        size++;
    }

    void addLast(int input) {
        if (size == cap) {
            System.out.println("Array full");
            return;
        }

        data[size] = input;
        size++;
    }

    int removeFirst() {
        if (size == 0) {
            System.out.println("Array kosong");
            return -1;
        }

        int input = data[0];

        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return input;
    }

    int removeLast() {
        if (size == 0) {
            System.out.println("Array kosong");
            return -1;
        }

        int input = data[size - 1];
        size--;

        return input;
    }

    void show() {
        if (size == 0) {
            System.out.println("Array kosong");
            return;
        }

        System.out.println("Array contents:");

        for (int i = 0; i < size; i++) {
            System.out.print("[" + data[i] + "] ");
        }

        System.out.println();
    }
}
