package QueueProjects;

import java.util.Scanner;

public class queue_array {
    static final int MAX_SIZE = 10;
    Scanner sc = new Scanner(System.in);

    char[] arr_queue = new char[MAX_SIZE];
    int head = 0;
    int tail = 0;
    int keluar = 0;

    public boolean isEmpty() {
        return tail == 0;
    }

    public boolean isFull() {
        return tail == MAX_SIZE;
    }

    public void enqueue(char item) {
        if (isFull()) {
            System.out.println("\n# Queue Penuh");
        } else {
            for (int i = tail; i > 0; i--) {
                arr_queue[i] = arr_queue[i - 1];
            }
            arr_queue[head] = item;
            tail++;
            System.out.println("\n# Queue No urut/index: " + head + ", Queue: " + item);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("\n## Queue kosong");
        } else {
            char item = arr_queue[tail - 1];
            tail--;
            System.out.println("\n## Dequeue item: " + item);
        }
    }

    public void printAll() {
        System.out.println("\n## Queue Size: " + tail);
        if (isEmpty()) {
            System.out.println("## Queue kosong");
        } else {
            for (int i = 0; i < tail; i++) {
                System.out.println("## No Urut/index: " + i + ", Value: " + arr_queue[i]);
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
        queue_array q = new queue_array();
        do {
            q.menu();
        } while (q.keluar == 0);
    }
}
