public class stackManual {
    private int[] data;
    private int top;
    private int capacity;

    stackManual(int size) {
        capacity = size;
        data = new int[capacity];
        top = -1; 
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full..");
            return;
        }
        data[++top] = value;
        System.out.println("Push: " + value);
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is null..");
            return -1;
        }
        return data[top--];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is null..");
            return -1;
        }
        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is null..");    
            return;
        }
        System.out.print("myStack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stackManual stack = new stackManual(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        stack.display();
    }
}