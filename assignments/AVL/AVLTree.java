package assignments.AVL;
import java.lang.Math;

class Node {
    int data;
    int tinggi;
    Node pKiri;
    Node pKanan;
    Node pInduk;

    Node(int data, Node pKiri, Node pKanan, Node pInduk) {
        this.data = data;
        this.tinggi = 1;
        this.pKiri = pKiri;
        this.pKanan = pKanan;
        this.pInduk = pInduk;
    }
}

public class AVLTree {
    private Node root;

    public AVLTree() {
        root = null;
    }

    public boolean cariDt(int dt) {
        Node temp = root;
        while (temp != null) {
            if (dt == temp.data) return true;
            else if (dt < temp.data) temp = temp.pKiri;
            else temp = temp.pKanan;
        }
        return false;
    }

    private int tinggi(Node node) {
        if (node == null) return 0;
        else return node.tinggi;
    }

    private void updateTinggi(Node node) {
        if (node != null) {
            node.tinggi = 1 + Math.max(tinggi(node.pKiri), tinggi(node.pKanan));
        }
    }

    private Node putarKiri(Node x) {
        Node y = x.pKanan;
        Node T2 = y.pKiri;

        y.pKiri = x;
        x.pKanan = T2;

        y.pInduk = x.pInduk;
        x.pInduk = y;
        if (T2 != null) T2.pInduk = x;

        if (y.pInduk != null) {
            if (y.pInduk.pKiri == x) y.pInduk.pKiri = y;
            else y.pInduk.pKanan = y;
        } else {
            root = y;
        }

        updateTinggi(x);
        updateTinggi(y);

        return y;
    }

    private Node putarKanan(Node y) {
        Node x = y.pKiri;
        Node T2 = x.pKanan;

        x.pKanan = y;
        y.pKiri = T2;

        x.pInduk = y.pInduk;
        y.pInduk = x;
        if (T2 != null) T2.pInduk = y;

        if (x.pInduk != null) {
            if (x.pInduk.pKiri == y) x.pInduk.pKiri = x;
            else x.pInduk.pKanan = x;
        } else {
            root = x;
        }

        updateTinggi(y);
        updateTinggi(x);

        return x;
    }

    private Node putarKiriKanan(Node node) {
        node.pKiri = putarKiri(node.pKiri);
        return putarKanan(node);
    }

    private Node putarKananKiri(Node node) {
        node.pKanan = putarKanan(node.pKanan);
        return putarKiri(node);
    }

    public boolean sisipDt(int dt) {
        if (root == null) {
            root = new Node(dt, null, null, null);
            return true;
        }

        Node temp = root;
        Node prev = null;

        while (temp != null) {
            if (dt == temp.data) return false;
            else if (dt < temp.data) {
                prev = temp;
                temp = temp.pKiri;
            } else {
                prev = temp;
                temp = temp.pKanan;
            }
        }

        Node newNode = new Node(dt, null, null, prev);
        if (dt < prev.data) prev.pKiri = newNode;
        else prev.pKanan = newNode;

        temp = prev;
        rebalance(temp);

        return true;
    }

    public boolean hapusDt(int dt) {
        Node nodeToDel = cariNode(root, dt);
        if (nodeToDel == null) return false;

        Node rebalanceStartNode;

        if (nodeToDel.pKiri != null && nodeToDel.pKanan != null) {
            Node successor = cariMin(nodeToDel.pKanan);
            nodeToDel.data = successor.data;
            nodeToDel = successor;
        }

        Node child = (nodeToDel.pKiri != null) ? nodeToDel.pKiri : nodeToDel.pKanan;

        if (child != null) {
            child.pInduk = nodeToDel.pInduk;
        }

        if (nodeToDel.pInduk == null) {
            root = child;
            rebalanceStartNode = root;
        } else {
            if (nodeToDel == nodeToDel.pInduk.pKiri) {
                nodeToDel.pInduk.pKiri = child;
            } else {
                nodeToDel.pInduk.pKanan = child;
            }
            rebalanceStartNode = nodeToDel.pInduk;
        }

        if (rebalanceStartNode != null) {
            rebalance(rebalanceStartNode);
        }

        return true;
    }

    private Node cariNode(Node node, int dt) {
        while (node != null) {
            if (dt == node.data) return node;
            else if (dt < node.data) node = node.pKiri;
            else node = node.pKanan;
        }
        return null;
    }

    private Node cariMin(Node node) {
        while (node.pKiri != null) {
            node = node.pKiri;
        }
        return node;
    }

    private void rebalance(Node startNode) {
        Node temp = startNode;
        while (temp != null) {
            updateTinggi(temp);
            int balance = tinggi(temp.pKiri) - tinggi(temp.pKanan);

            if (balance >= 2) {
                if (tinggi(temp.pKiri.pKiri) >= tinggi(temp.pKiri.pKanan)) {
                    temp = putarKanan(temp);
                } else {
                    temp = putarKiriKanan(temp);
                }
            } else if (balance <= -2) {
                if (tinggi(temp.pKanan.pKanan) >= tinggi(temp.pKanan.pKiri)) {
                    temp = putarKiri(temp);
                } else {
                    temp = putarKananKiri(temp);
                }
            }

            temp = temp.pInduk;
        }
    }

    public int tinggi() {
        return tinggi(root);
    }

    public int jumlahNode() {
        return jumlahNode(root);
    }

    private int jumlahNode(Node node) {
        if (node == null) return 0;
        else return 1 + jumlahNode(node.pKiri) + jumlahNode(node.pKanan);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node r) {
        if (r == null) return;
        inorder(r.pKiri);
        System.out.printf("%-4d", r.data);
        inorder(r.pKanan);
    }

    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        int[] data = {5, 4, 6, 3, 10, 15, 20, 17, 25};

        System.out.println("penyisipan data");
        for (int val : data) {
            t.sisipDt(val);
            t.inorderTraversal();
            System.out.println();
        }
        System.out.println();
        System.out.println("penghapusan data");
        
        System.out.print("hapus 3 daun ");
        t.hapusDt(3);
        t.inorderTraversal();
        System.out.println();

        System.out.print("hapus 4 daun (1 Anak) ");
        t.hapusDt(4);
        t.inorderTraversal();
        System.out.println();

        System.out.print("hapus 15 (2 Anak) ");
        t.hapusDt(15);
        t.inorderTraversal();
        System.out.println();
    }
}