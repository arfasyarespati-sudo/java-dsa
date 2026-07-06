class Node {
    String url;
    Node next;

    public Node(String url) {
        this.url = url;
        this.next = null;
    }
}

class BrowserHistory {
    private Node head;
    private Node tail;

    public void kunjungi(String url) {
        Node nodeBaru = new Node(url);
        if (head == null) {
            head = nodeBaru;
            tail = nodeBaru;
        } else {
            tail.next = nodeBaru;
            tail = nodeBaru;
        }
        System.out.println("Membuka: " + url);
    }

    public void tampilkanRiwayat() {
        System.out.println("\n=== RIWAYAT BROWSING ===");
        Node current = head;
        while (current != null) {
            System.out.print(current.url + " -> ");
            current = current.next;
        }
        System.out.println("Selesai (null)");
    }
}

public class linkedList {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        history.kunjungi("google.com");
        history.kunjungi("github.com");
        history.kunjungi("leetcode.com");

        history.tampilkanRiwayat();
    }
}