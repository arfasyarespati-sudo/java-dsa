import java.util.LinkedList;
public class myNode {
    public static void main(String[] args) {
       LinkedList<String> ll = new LinkedList<String>();
        
       ll.offer("A");
       ll.offer("B");
       ll.offer("C");
       ll.offer("D");
       ll.offer("E");
       ll.offer("F");

       ll.pop();
       System.out.println(ll);
    }
}


