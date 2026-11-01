package assignments;

import java.util.Random;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public void insertLR(int input) {
        if (input < data) {
            if (left == null)
                left = new Node(input);
            else
                left.insertLR(input);
        } else if (input > data) {
            if (right == null)
                right = new Node(input);
            else
                right.insertLR(input);
        }
    }
}

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insertRoot(int input) {
        if (root == null) {
            root = new Node(input);
        } else {
            root.insertLR(input);
        }
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.printf("%d ", node.data);
        inorder(node.right);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.printf("%d ", node.data);
    }

    public int hitungJumlahNode() {
        return hitungNode(root);
    }

    private int hitungNode(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + hitungNode(node.left) + hitungNode(node.right);
    }

    public int hitungJumlahDaun() {
        return hitungDaun(root);
    }

    private int hitungDaun(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }
        return hitungDaun(node.left) + hitungDaun(node.right);
    }

    public int hitungTinggiPohon() {
        return hitungTinggi(root);
    }

    private int hitungTinggi(Node node) {
        if (node == null) {
            return 0;
        }
        int tinggiKiri = hitungTinggi(node.left);
        int tinggiKanan = hitungTinggi(node.right);

        return Math.max(tinggiKiri, tinggiKanan) + 1;
    }

    public int hitungLevelPohon() {
        return hitungTinggi(root);
    }

    public static void main(String args[]) {
        Tree Tree = new Tree();
        int nilai;
        Random randomNumber = new Random();

        System.out.println("sisip nilai data berikut: ");

        // sisipDt 10 bilangan acak dari 0-99 ke dalam tree
        for (int i = 1; i <= 10; i++) {
            nilai = randomNumber.nextInt(100);
            System.out.print(nilai + " ");
            Tree.insertRoot(nilai);
        }

        System.out.println("\n\nPreorder traversal");
        Tree.preorderTraversal();

        System.out.println("\n\nInorder traversal");
        Tree.inorderTraversal();

        System.out.println("\n\nPostorder traversal");
        Tree.postorderTraversal();
        System.out.println();

        System.out.println();
        System.out.println("SOAL 1");
        System.out.println("1. Jumlah total node : " + Tree.hitungJumlahNode());
        System.out.println("2. Jumlah daun (leaf): " + Tree.hitungJumlahDaun());
        System.out.println("3. Tinggi pohon      : " + Tree.hitungTinggiPohon());
        System.out.println("4. Jumlah level pohon: " + Tree.hitungLevelPohon());
    }
}