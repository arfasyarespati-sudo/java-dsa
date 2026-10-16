package UTS;

class Nasabah {
    String noAntre;
    String nama;
    String tipe;

    Nasabah(String noAntre, String nama, String tipe) {
        this.noAntre = noAntre;
        this.nama = nama;
        this.tipe = tipe;
    }
}

class NodeNasabah {
    Nasabah data;
    NodeNasabah next;

    NodeNasabah(Nasabah data) {
        this.data = data;
    }
}

class BankQueue {
    NodeNasabah head;
    NodeNasabah tail;

    void enqueue(Nasabah a) {
        NodeNasabah n = new NodeNasabah(a);
        if (head == null) {
            head = n;
            tail = n;
            return;
        }
        if (!a.tipe.equals("PRIORITAS")) {
            tail.next = n;
            tail = n;
            return;
        }
        if (!head.data.tipe.equals("PRIORITAS")) {
            n.next = head;
            head = n;
            return;
        }
        NodeNasabah temp = head;
        while (temp.next != null && temp.next.data.tipe.equals("PRIORITAS")) {
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
        if (n.next == null) {
            tail = n;
        }
    }

    void dequeue() {
        if (head == null) {
            System.out.println("Antrean kosong");
            return;
        }
        Nasabah a = head.data;
        System.out.println("Melayani: " + a.noAntre + " " + a.nama + " (" + a.tipe + ")");
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void tampilkanAntrean() {
        if (head == null) {
            System.out.println("Antrean kosong");
            return;
        }
        NodeNasabah temp = head;
        while (temp != null) {
            System.out.println(temp.data.noAntre + " " + temp.data.nama + " (" + temp.data.tipe + ")");
            temp = temp.next;
        }
    }
}

public class Soal4 {
    public static void main(String[] args) {
        BankQueue q = new BankQueue();
        q.enqueue(new Nasabah("R001", "Prabowo", "REGULER"));
        q.enqueue(new Nasabah("R002", "Jokowi", "REGULER"));
        q.enqueue(new Nasabah("P001", "Pak Harto", "PRIORITAS"));

        System.out.println("Antrean:");
        q.tampilkanAntrean();

        System.out.println("\nPrioritas dan reguler:");
        q.enqueue(new Nasabah("P002", "Jason", "PRIORITAS"));
        q.enqueue(new Nasabah("R003", "Habibie", "REGULER"));
        q.enqueue(new Nasabah("P003", "Qalbi", "PRIORITAS"));
        q.tampilkanAntrean();

        System.out.println("\n Layani 3 nasabah :");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.tampilkanAntrean();

        System.out.println("\nPrioritaskan Wowo");
        q.enqueue(new Nasabah("P004", "Wowo", "PRIORITA"));
        q.tampilkanAntrean();

        System.out.println("\nLayani semua");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}