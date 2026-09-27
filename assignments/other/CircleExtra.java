package assignments.other;

class Node {
    Object data;
    Node next;
    Node prev;

    Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class CircleExtra {
    Node head;
    Node tail;
    int size;

    boolean isEmpty(){
        return head == null;
    }

    void addFirst(Object data){
        Node n = new Node(data);
        if (isEmpty()){
            head = n;
            tail = n;
            n.next = n;
            n.prev = n;
        } else {
            n.next = head;
            head.prev = n;
            n.prev = tail;
            tail.next = n;
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
            tail.next = n;
            head.prev = n;
            n.next = head;
            tail = n;
        }
        size++;
    }
    void deleteFirst(){
        if (isEmpty()) {
            System.out.println("nothing to delete sir");
            return;
        } 
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }
    void deleteLast(){
        if (isEmpty()) {
            System.out.println("nothing to delete here sir");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }
    void insert(int index, Object data) {
        if (index < 0 || index > size) {
            System.out.println("index out of bounds!");
            return;
        }
        if (isEmpty()) {
            addFirst(data);
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

    }
    void remove(Object data) {
        if (isEmpty()) {
            System.out.println("nothing to remove here sir");
            return;
        }
        Node current = head;
        do {
            if (current.data.equals(data)) {
                if (current == head) {
                    deleteFirst();
                } else if (current == tail){
                    deleteLast();
                } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }
    public static void main(String[] args) {
        
    }
}
