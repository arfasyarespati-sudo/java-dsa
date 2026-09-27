package assignments.other;

class Node {
    Object data;
    Node prev;
    Node next;

    public Node(Object data) {
        this.data = data;
    }
}

public class CircleDLL {
    private Node head;
    private Node tail;

    CircleDLL() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Add node at the beginning
    public void addFirst(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Add node at the end
    public void addLast(Object data) {
        if (isEmpty()) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
    }

    // Remove the first node
    public void removeFirst() {
        if (isEmpty()) return;

        if (head == tail) { // Only 1 node
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    // Remove the last node
    public void removeLast() {
        if (isEmpty()) return;

        if (head == tail) { // Only 1 node
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
    }

    // Remove specific node by data
    public void remove(Object data) {
        if (isEmpty()) return;

        Node current = head;
        do {
            if (current.data.equals(data)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Print the list
    public void printList(String message) {
        System.out.println(message);
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(Head: " + head.data + ")");
    }

    public static void main(String[] args) {
        CircleDLL cdll = new CircleDLL();

        cdll.addFirst(50);
        cdll.addFirst(60);
        cdll.addFirst(70);
        cdll.addFirst(8);
        cdll.addFirst(9);
        cdll.addFirst(90);
        cdll.addFirst(19);

        cdll.printList("Initial Data:");
        cdll.addLast(100);
        cdll.printList("\nAfter adding 100 at the end:");
        cdll.remove(70);
        cdll.printList("\nAfter removing 70:");
        cdll.removeFirst();
        cdll.printList("\nAfter removing first node:");
        cdll.removeLast();
        cdll.printList("\nAfter removing last node:");
    }
}