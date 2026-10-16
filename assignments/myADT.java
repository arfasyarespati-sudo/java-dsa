package assignments;
public class myADT {
    public int[] data;
    public int front;
    public int rear;
    public int size;
    public int capacity;

    // Constructor
    public myADT(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Tambah Depan
    public void tambahDepan(int nilai) {
        if (size == capacity) {
            System.out.println("Array penuh!");
            return;
        }
        front = (front - 1 + capacity) % capacity;
        data[front] = nilai;
        if (size == 0) {
            rear = front;
        }
        size++;
    }

    // Tambah Belakang
    public void tambahBelakang(int nilai) {
        if (size == capacity) {
            System.out.println("Array penuh!");
            return;
        }
        rear = (rear + 1) % capacity;
        data[rear] = nilai;
        if (size == 0) {
            front = rear;
        }
        size++;
    }

    // Hapus Depan
    public int hapusDepan() {
        if (size == 0) {
            System.out.println("Array kosong!");
            return -1;
        }
        int nilai = data[front];
        front = (front + 1) % capacity;
        size--;
        return nilai;
    }

    // Hapus Belakang
    public int hapusBelakang() {
        if (size == 0) {
            System.out.println("Array kosong!");
            return -1;
        }
        int nilai = data[rear];
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return nilai;
    }

    // Tampilkan isi array
    public void tampilkan() {
        if (size == 0) {
            System.out.println("Array kosong!");
            return;
        }
        System.out.print("Isi array: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }

    // Main untuk testing
    public static void main(String[] args) {
        myADT list = new myADT(5);

        // Test Tambah Belakang
        list.tambahBelakang(10);
        list.tambahBelakang(20);
        list.tambahBelakang(30);
        list.tampilkan(); // Output: Isi array: 10 20 30

        // Test Tambah Depan
        list.tambahDepan(5);
        list.tampilkan(); // Output: Isi array: 5 10 20 30

        // Test Hapus Depan
        list.hapusDepan();
        list.tampilkan(); // Output: Isi array: 10 20 30

        // Test Hapus Belakang
        list.hapusBelakang();
        list.tampilkan(); // Output: Isi array: 10 20
    }
}