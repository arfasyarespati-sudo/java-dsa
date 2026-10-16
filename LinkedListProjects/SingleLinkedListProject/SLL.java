package SingleLinkedListProject;

class Mahasiswa {
    String nim;
    String nama;
    double ipk;

    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }
    public String getNama() {
        return nama;
    }
    public double getIpk() {
        return ipk;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + " Nama: " + nama + " IPK: " + ipk;
    }
}

public class SLL {
    Node head, tail;
    int size = 0;

    void inisialisasi() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong");
        } else if (head == tail) {
            inisialisasi();
        } else {
            head = head.next;
            size--;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong");
        } else if (head == tail) {
            inisialisasi();
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }
    }

    void insertAfter(Object key, Node input) {
        Node temp = head;
        while (temp != null) {
            if (temp.data != null && temp.data.equals(key)) {
                input.next = temp.next;
                temp.next = input;
                if (input.next == null) {
                    tail = input;
                }
                size++;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Data referensinya unknown");
    }

    boolean search(Object key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data != null && temp.data.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

  void printList() {
        if (isEmpty()) {
            System.out.println("List kosong");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void urutIPK(Node input) {
        if (!(input.data instanceof Mahasiswa)) {
            System.out.println("Data bukan objek Mahasiswa");
            return;
        }

        Mahasiswa mhsBaru = (Mahasiswa) input.data;
        if (isEmpty() || mhsBaru.getIpk() < ((Mahasiswa) head.data).getIpk()) {
            addFirst(input);
            return;
        }

        Node temp = head;
        while (temp.next != null && ((Mahasiswa) temp.next.data).getIpk() <= mhsBaru.getIpk()) {
            temp = temp.next;
        }

        input.next = temp.next;
        temp.next = input;

        if (input.next == null) {
            tail = input;
        }
        size++;
    }

    public static void main(String[] args) {
        SLL list = new SLL();

        Node mhs1 = new Node();
        mhs1.data = new Mahasiswa("123", "Andi", 3.2);

        Node mhs2 = new Node();
        mhs2.data = new Mahasiswa("124", "Budi", 3.8);

        Node mhs3 = new Node();
        mhs3.data = new Mahasiswa("125", "Citra", 3.5);

        Node mhs4 = new Node();
        mhs4.data = new Mahasiswa("126", "Deni", 2.9);

        list.urutIPK(mhs1);
        list.urutIPK(mhs2);
        list.urutIPK(mhs3);
        list.urutIPK(mhs4);

        list.printList();
    }
}
