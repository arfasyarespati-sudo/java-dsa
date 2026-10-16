package CircularLL;

class Node {
    Node next;
    Node prev;
    Object data;

    Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class testof {
    Node head;
    Node tail;
    int size;

    boolean isEmpty(){
        return head == null;
    }

    void addFirst(Object data){
        Node n = new Node(data);
        if (isEmpty()) {
            head = tail = n;
            n.next = head;
            n.prev = tail;
            return;
        } else {
            n.next = head;
            head.prev = n;
            tail.next = head;
            head = n;
        }
        size++;
    }
    void addLast(Object data) {
        Node n = new Node(data);
        if (isEmpty()) {
            addFirst(data);
            return;
        } else {
            n.prev = tail;
            n.next = head;
            tail.next = n;
            head.prev = n;
            tail = n;
        }
        size++;
    }
    void delFirst() {
        if (isEmpty()) {
            System.out.println("Nothin to delete");
            return;
        } 
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }
    void delLast(){
        if (isEmpty()) {
            System.out.println("nothing to delete");
            return;
        } 
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }
}
