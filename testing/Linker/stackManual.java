package testing.Linker;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stackManual {
    Node top;
    int size;

    stackManual(){
        this.top = null;
        this.size = 0;
    }
}
