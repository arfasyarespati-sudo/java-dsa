package testing.Linker;

public class myDoubly {
    Node head;
    Node tail;
    int size;

    void inisialisasi(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    boolean isEmpty(){
        return head == null;
    }

    int size(){
        return size;
    }

    void addFirst(Node input){
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            head.prev = input;
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            tail = input;
            head = input;
        } else {
            tail.next = input;
            input.prev = tail;
            tail = input;
        }
        size++;
    }

    void removeFirst(){
        if (isEmpty()) {
            System.out.println("nothing to remove here!");
            return;
        } 
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    void removeLast(){
        if (isEmpty()) {
            System.out.println("nothing to remove here!");
            return;
        }
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    void insertAt(int index, Node input){ 
        if (isEmpty()) {
            head = input;
            tail = input;
        }
        if (index < 0 || index > size) {
            System.out.println("invalid indexes");
        }
        if (index == 0) {
            addFirst(input);
        }
        if (index == size) {
            addLast(input);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) { 
                current = current.next;
            }
            input.next = current.next;
            input.prev = current;
            current.next.prev = input;
            current.next = input;
            size++;
        }
        
    }
}
