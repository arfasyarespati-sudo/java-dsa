import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        
        Queue<String> myQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        myQueue.add("Jason");
        myQueue.add("Habibi");
        myQueue.add("Qalbi");

        String nextLine = myQueue.peek();
        System.out.println("Next Ticket: " + nextLine);
        String deleteLine = myQueue.remove();
        System.out.println("Delete Ticket: " + deleteLine);

        System.out.println("Next Ticket: " + nextLine);
        sc.close();
    }
}


