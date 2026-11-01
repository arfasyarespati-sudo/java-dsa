package assignments;

public class treeArr {
    int[] tree;
    int element;

    treeArr(int cap) {
        tree = new int[cap];
        element = 0;
    }

    void insert(int input) {
        if (element < tree.length) {
            tree[element] = input;
            element++;
        } else {
            System.out.println("tree is full");
        }
    }

    void preorder() {
        pre(0);
        System.out.println();
    }

    void pre(int index) {
        if (index >= element) {
            return;
        }
        System.out.print(tree[index] + " ");
        pre(2 * index + 1);
        pre(2 * index + 2);
    }

    void inorder() {
        in(0);
        System.out.println();
    }

    void in(int index) {
        if (index >= element) {
            return;
        }

        in(2 * index + 1);
        System.out.print(tree[index] + " ");
        in(2 * index + 2);
    }

    void postorder() {
        post(0);
        System.out.println();
    }

    void post(int input) {
        if (input >= element) {
            return;
        }
        post(2 * input + 1);
        post(2 * input + 2);
        System.out.print(tree[input] + " ");
    }

    void display() {
        for (int i = 0; i < element; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        treeArr t = new treeArr(10);

        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(40);
        t.insert(50);

        System.out.println("Array Structure:");
        t.display();

        System.out.print("Preorder  : ");
        t.preorder();

        System.out.print("Inorder   : ");
        t.inorder();

        System.out.print("Postorder : ");
        t.postorder();
    }
}
