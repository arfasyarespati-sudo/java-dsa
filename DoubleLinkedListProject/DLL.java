package DoubleLinkedListProject;

public class DLL {
    Node head;
    Node tail;
    int size = 0;

    void inisialisasi() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
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
            head.prev = input;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
    }

    void removeLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
    }

    void insert(int index, Node input) {
        if (index == 0) {
            addFirst(input);
        } else if (index >= size) {
            addLast(input);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            input.next = temp.next;
            input.prev = temp;
            temp.next.prev = input;
            temp.next = input;
            size++;
        }
    }

    boolean search(Object data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertUrut(Node input) {
        if (isEmpty()) {
            addFirst(input);
            return;
        }

        Mahasiswa mhsBaru = (Mahasiswa) input.data;

        if (mhsBaru.getIpk() <= ((Mahasiswa) head.data).getIpk()) {
            addFirst(input);
        } else if (mhsBaru.getIpk() >= ((Mahasiswa) tail.data).getIpk()) {
            addLast(input);
        } else {
            Node current = head;
            while (current != null && ((Mahasiswa) current.data).getIpk() < mhsBaru.getIpk()) {
                current = current.next;
            }
            input.prev = current.prev;
            input.next = current;
            current.prev.next = input;
            current.prev = input;
            size++;
        }
    }

    public void tampilAscending() {
        if (isEmpty()) {
            System.out.println("kosong");
            return;
        }
        Node current = head;
        while (current != null) {
            Mahasiswa m = (Mahasiswa) current.data;
            System.out.println(m.getNim() + " - " + m.getNama() + " - IPK: " + m.getIpk());
            current = current.next;
        }
    }

    public void tampilDescending() {
        if (isEmpty()) {
            System.out.println("kosong");
            return;
        }
        Node current = tail;
        while (current != null) {
            Mahasiswa m = (Mahasiswa) current.data;
            System.out.println(m.getNim() + " - " + m.getNama() + " - IPK: " + m.getIpk());
            current = current.prev;
        }
    }
    public static void main(String[] args) {
      DLL list = new DLL();

        Node n1 = new Node();
        n1.data = new Mahasiswa("101", "Budi", 3.20);

        Node n2 = new Node();
        n2.data = new Mahasiswa("102", "Siti", 3.90);

        Node n3 = new Node();
        n3.data = new Mahasiswa("103", "Andi", 2.75);

        Node n4 = new Node();
        n4.data = new Mahasiswa("104", "Dewi", 3.50);

        list.insertUrut(n1);
        list.insertUrut(n2);
        list.insertUrut(n3);
        list.insertUrut(n4);

        System.out.println("Data Ascending (IPK Rendah ke Tinggi):");
        list.tampilAscending();

        System.out.println("\nData Descending (IPK Tinggi ke Rendah):");
        list.tampilDescending();
    }
}