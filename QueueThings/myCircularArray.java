package QueueThings;

public class myCircularArray {
    int front, rear, itemCount, size;
    Object [] arai;
    
    myCircularArray(int size) {
        this.front = 0;
        this.rear = -1;
        this.itemCount = 0;
        this.size = size;
        this.arai = new Object [size];
    }

    void enqueue(Object input){
        if (itemCount == size) {
            System.out.println("dah full");
            return;
        } 
        rear = (rear + 1) % size;
        arai[rear] = input;
        itemCount++;
        System.out.println("Masuk: " + input + " front: " + front + " rear: " + rear );
    }

    Object dequeue() {
        if (itemCount == 0) {
            System.out.println("ksong");
            return null;
        }
        Object out = arai[front];
        
        arai[front] = null; 
        front = (front + 1) % size;
        itemCount--;

        System.out.println("Keluar: " + out + " front: " + front + " rear: " + rear);
        return out;
    }


    public static void main(String[] args) {
        myCircularArray kiw = new myCircularArray(5);

        kiw.enqueue("jason");
        kiw.enqueue("arfa");
        kiw.enqueue("qalbi");
        kiw.enqueue("hanif");
        kiw.enqueue("rei");
        kiw.dequeue();
        kiw.dequeue();
        kiw.enqueue("brian");   
        kiw.enqueue("sahroni");
    }
}
