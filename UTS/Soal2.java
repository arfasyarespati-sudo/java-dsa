package UTS;

class NodeHalaman {
    String url;
    String judulWeb;
    NodeHalaman prev;
    NodeHalaman next;

    NodeHalaman(String url, String judulWeb) {
        this.url = url;
        this.judulWeb = judulWeb;
    }
}

class BrowserHistory {
    NodeHalaman head;
    NodeHalaman tail;
    NodeHalaman curr;

    void kunjungi(String url, String judulWeb) {
        NodeHalaman n = new NodeHalaman(url, judulWeb);
        if (head == null) {
            head = n;
            tail = n;
            curr = n;
            return;
        }
        curr.next = n;
        n.prev = curr;
        curr = n;
        tail = n;
    }

    void back() {
        if (curr != null && curr.prev != null) {
            curr = curr.prev;
            System.out.println("Back: " + curr.judulWeb);
        } else {
            System.out.println("Tidak ada halaman sebelumnya");
        }
    }

    void forward() {
        if (curr != null && curr.next != null) {
            curr = curr.next;
            System.out.println("Forward: " + curr.judulWeb);
        } else {
            System.out.println("Tidak ada halaman berikutnya");
        }
    }

    void cetakRiwayat() {
        NodeHalaman temp = head;
        while (temp != null) {
            if (temp == curr) {
                System.out.println(temp.judulWeb + " (" + temp.url + ") <= current");
            } else {
                System.out.println(temp.judulWeb + " (" + temp.url + ")");
            }
            temp = temp.next;
        }
    }
}

public class Soal2 {
    public static void main(String[] args) {
        BrowserHistory b = new BrowserHistory();
        b.kunjungi("eling.ub.ac.id", "Eling");
        b.kunjungi("youtube.com", "YouTube");
        b.kunjungi("github.com", "GitHub");
        b.kunjungi("docs.google.com", "Google Documents");

        System.out.println("Riwayat: ");
        b.cetakRiwayat();

        System.out.println("\nBack 2x:");
        b.back();
        b.back();
        b.cetakRiwayat();

        System.out.println("\nForward 1x:");
        b.forward();
        b.cetakRiwayat();

        System.out.println("\nBack lalu kunjungi web lain");
        b.back();
        b.kunjungi("brone.ub.ac.id", "Brone");
        b.cetakRiwayat();

        System.out.println("\nForward mentok:");
        b.forward();

        System.out.println("\nBack sampai awal:");
        b.back();
        b.back();
        b.back();
        b.cetakRiwayat();
    }
}
