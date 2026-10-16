package QueueThings;


public class myQueue {
    Object[] queue;
    int front, rear;
    int item;

    myQueue(int size) {
        queue = new Object[size];
        item = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty(){
        return (item == 0);
    }

    private boolean isFull(){
        return (item == queue.length);
    }

    public void makeEmpty(){
        queue = new Object[10];
        front = 0;
        rear = -1;
        item = 0;
    }


    public static void main(String[] args) {
        
    }
}