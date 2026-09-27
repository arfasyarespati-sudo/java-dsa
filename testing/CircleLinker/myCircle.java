package testing.CircleLinker;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class myCircle {
    Node head;
    Node tail;
    int size;

    myCircle(int size) {
        this.head = null;
        this.tail = null;
        this.size = size;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    void addFirst(int data){
        Node n = new Node(data);

        if (isEmpty()) {
            head = tail = n;
            head.next = n;
            head.prev = head;
        } else {
            n.next = head;
            n.prev = tail;
            tail.next = n;
            head = n;
        }
        size++;
    }

    void addLast(int data) {
        Node n = new Node(data);
        if (isEmpty()) {
            tail = head = n;
            head.next = n;
            head.prev = head;
        } else {
            n.prev = tail;
            n.next = head;
            tail.next = n;
            head.prev = n;
            tail = n;
        }
        size++;
    }

        void removeFirst(){
            if (isEmpty()) {
                System.out.println("nothing to be removed");
                return;
            } 
            if (head == tail) {
                head = null;
                tail = null;
            }
            else {
                head = head.next;
                tail.next = head;
                head.prev = tail;
            }
            size--;
        }
        void removeLast(){
            if (isEmpty()) {
                System.out.println("nothing to be removed");
                return;
            }
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
            size--;
        }
        void add(int index, int data){
            if (index < 0 || index > size) {
                System.out.println("index out of bounds!");
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
            Node n = new Node(data);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            n.next = curr.next;
            n.prev = curr;
            curr.next.prev = n;
            curr.next = n;
        }

        void remove(int index, int data) {
             if (index < 0 || index > size) {
                System.out.println("index out of bounds!");
                return;
            }
            if (isEmpty()) {
                System.out.println("nothing to be removed");
                return;
            }
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size) {
                removeLast();
                return;
            }
            Node n = new Node(data);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
        }
    public static void main(String[] args) {
        
        
    }
}
