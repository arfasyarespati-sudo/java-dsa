package QueueProjects;

import java.util.Scanner;

class Node {
    char data;
    Node prev;
    Node next;

    Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class queue_dll {
    Scanner sc = new Scanner(System.in);
    Node head = null;
    Node tail = null;
    int size = 0;
    int keluar = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(char item) {
        Node n = new Node(item);
        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
        System.out.println("\n# Enqueue berhasil, item '" + item + "' ditambahkan pada head");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("\n## Queue kosong");
        } else {
            char item = tail.data;
            if (head == tail) { 
                head = null;
                tail = null;
            } else { 
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            System.out.println("\n## Dequeue berhasil, item '" + item + "' diambil dari tail");
        }
    }

    public void printAll() {
        System.out.println("\n## Queue Size: " + size);
        if (isEmpty()) {
            System.out.println("## Queue kosong");
        } else {
            Node temp = head;
            int index = 0;
            while (temp != null) {
                System.out.println("## No Urut/index: " + index + ", Value: " + temp.data);
                temp = temp.next;
                index++;
            }
        }
    }

    public void menu() {
        System.out.print("\nMasukkan operasi yang akan dilakukan (1:enqueue, 2:dequeue, 3:print): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("\nMasukkan huruf yang akan di-enqueue: ");
                char item = sc.next().charAt(0);
                enqueue(item);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                printAll();
                break;
            default:
                System.out.println("\n1:enqueue, 2:dequeue, 3:print");
                keluar = 1;
                break;
        }
    }

    public static void main(String[] args) {
        queue_dll q = new queue_dll();
        do {
            q.menu();
        } while (q.keluar == 0);
    }
}
