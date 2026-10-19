package UTS;

interface PlaylistADT {
    void tambahLagu(int id, String judul, String penyanyi, int durasi);

    void hapusLagu(int id);

    void putarSelanjutnya();

    void tampilkanPlaylist();
}

class LaguNode {
    int id;
    String judul;
    String penyanyi;
    int durasi;
    LaguNode next;

    LaguNode(int id, String judul, String penyanyi, int durasi) {
        this.id = id;
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.durasi = durasi;
    }
}

class SinglyLinkedListPlaylist implements PlaylistADT {
    LaguNode head;

    public void tambahLagu(int id, String judul, String penyanyi, int durasi) {
        LaguNode n = new LaguNode(id, judul, penyanyi, durasi);
        if (head == null) {
            head = n;
            return;
        }
        LaguNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
    }

    public void hapusLagu(int id) {
        if (head == null) {
            System.out.println("Playlist kosong");
            return;
        }
        if (head.id == id) {
            head = head.next;
            return;
        }
        LaguNode temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Lagu dengan id " + id + " tidak ditemukan");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void putarSelanjutnya() {
        if (head == null) {
            System.out.println("Playlist kosong");
            return;
        }
        System.out.println("Memutar: " + head.judul + " - " + head.penyanyi);
        head = head.next;
    }

    public void tampilkanPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong");
            return;
        }
        LaguNode temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.judul + " | " + temp.penyanyi + " | " + temp.durasi + " detik");
            temp = temp.next;
        }
    }
}

public class Soal1 {
    public static void main(String[] args) {
        PlaylistADT p = new SinglyLinkedListPlaylist();
        p.tambahLagu(1, "Bohemian Rhapsody", "Queen", 300);
        p.tambahLagu(2, "MMG", "Naykilla", 200);
        p.tambahLagu(3, "IQRO", "Raim Laode", 100);
        p.tambahLagu(4, "Professor67", "Costa", 6767);

        System.out.println("Playlist:");
        p.tampilkanPlaylist();

        System.out.println("\nHapus id 3 lagu");
        p.hapusLagu(3);
        p.tampilkanPlaylist();

        System.out.println("\nHapus id 5 lagu");
        p.hapusLagu(5);

        System.out.println("\nPutar selanjutnya:");
        p.putarSelanjutnya();
        p.tampilkanPlaylist();

        System.out.println("\nPutar sampai habis:");
        p.putarSelanjutnya();
        p.putarSelanjutnya();
        p.putarSelanjutnya();
    }
}