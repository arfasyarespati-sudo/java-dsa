package SingleLinkedListProject;

public class exercise {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class singLink {
        Node head;
        int size;

        public void addFirst(int data) {
            Node n = new Node(data);
            n.next = head;
            head = n;
            size++;
        }
    }


    public static void main (String[]args) {
      singLink list = new singLink();

      list.addFirst(20);
      
    }
}