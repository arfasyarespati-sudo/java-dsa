class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class singlyLinked {
    Node head = null;

    public void addData(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        } 
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode;
    }
    public void cetakList() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " -> ");
            pointer = pointer.next; 
        }
        System.out.println("null");
    }
}




public class myNode {
    public static void main(String[] args) {
        singlyLinked mbut = new singlyLinked();
        mbut.addData(20);
        mbut.addData(30);

        mbut.cetakList();
    }
}


