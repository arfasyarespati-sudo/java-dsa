package assignments.QuizASD;

public class arrayDSA {
    int [] data;
    int head;
    int tail;
    int size;
    int cap;

    public arrayDSA(int cap){
        this.cap = cap;
        this.data = new int[cap];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }

    void addFirst(int input){
        if (size == cap) {
            System.out.println("array full");
            return;
        }
        head = (head - 1 + cap) % cap;
        data[head] = input;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    void addLast(int input) {
        if (size == cap) {
            System.out.println("array full");
            return;
        }
        tail = (tail + 1) % cap;
        data[tail] = input;
        if (size == 0) {
            head = tail;
        }
        size++;
    }

    int removeFirst(){
        if (size == 0) {
            System.out.println("array kosong");
            return -1;
        }
        int input = data[head];
        head = (head + 1) % cap;
        size--;
        return input;
    }

    int removeLast() {
        if (size == 0) {
            System.out.println("array kosong");
            return -1;
        }
        int input = data[tail];
        tail = (tail - 1 + cap) % cap;
        size--;
        return input;
    }

    void show() {
        if (size == 0) {
            System.out.println("array kosong");
            return;
        }
        System.out.println("array contents: ");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % cap;
            System.out.print("[" + data[index] + "] ");
        }
        System.out.println()
        ;
    }
        
    public static void main(String[] args) {
        arrayDSA ar = new arrayDSA(5);
        ar.addFirst(10);
        ar.addFirst(12);
        ar.addFirst(15);
        ar.show();
        ar.removeFirst();
        ar.removeLast();
        ar.show();
    }
}
