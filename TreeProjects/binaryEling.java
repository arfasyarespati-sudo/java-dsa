package TreeProjects;

import java.util.Random;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    void insertData(int input) {
        if (input < data) {
            if (left == null) {
                left = new Node(input);
            } else {
                left.insertData(input);
            }
        } else if (input > data) {
            if (right == null) {
                right = new Node(input);
            } else {
                right.insertData(input);
            }
        }
    }
}

public class binaryEling {
    Node root;

    binaryEling() {
        root = null;
    }

    void insertDataNode(int input) {
        if (root == null) {
            root = new Node(input);
        } else {
            root.insertData(input);
        }
    }

    void preorderTraversal() {
        preorder(root);
    }

    void preorder(Node node) {
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        preorder(node.left);
        preorder(node.right);
    }

    void inorderTraversal() {
        inorder(root);
    }

    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
    }

    void postorderTraversal() {
        postorder(root);
    }

    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.printf("%d ", node.data);
    }

    public static void main(String args[]) {
        binaryEling tree = new binaryEling();
        int nilai;
        Random randomNumber = new Random();

        System.out.println("sisip nilai data berikut: ");

        // Menyisipkan 10 bilangan acak dari 0-99 ke dalam tree
        for (int i = 1; i <= 10; i++) {
            nilai = randomNumber.nextInt(100);
            System.out.print(nilai + " ");
            tree.insertDataNode(nilai);
        }

        System.out.println("\n\nPreorder traversal");
        tree.preorderTraversal();

        System.out.println("\n\nInorder traversal");
        tree.inorderTraversal();

        System.out.println("\n\nPostorder traversal");
        tree.postorderTraversal();
        System.out.println();
    }
}