package TreeProjects;

public class BinaryTreeArray {

    private final String[] tree;

    public BinaryTreeArray(String[] tree) {
        this.tree = tree;
    }

    // Node dianggap ada jika index masih dalam array dan isinya tidak null
    private boolean isValid(int i) {
        return i < tree.length && tree[i] != null;
    }

    // Preorder: root -> kiri -> kanan
    public void preorder(int i) {
        if (!isValid(i)) return;
        System.out.print(tree[i] + " ");
        preorder(2 * i + 1);
        preorder(2 * i + 2);
    }

    // Inorder: kiri -> root -> kanan
    public void inorder(int i) {
        if (!isValid(i)) return;
        inorder(2 * i + 1);
        System.out.print(tree[i] + " ");
        inorder(2 * i + 2);
    }

    // Postorder: kiri -> kanan -> root
    public void postorder(int i) {
        if (!isValid(i)) return;
        postorder(2 * i + 1);
        postorder(2 * i + 2);
        System.out.print(tree[i] + " ");
    }

    // Level-order: karena urutan index sudah per level (atas ke bawah, kiri ke kanan)
    public void levelOrder() {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                System.out.print(tree[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Representasi tree:
        //         A          index 0
        //        / \
        //       B   C        index 1, 2
        //      / \   \
        //     D   E   F      index 3, 4, 6
        // Index 5 (anak kiri C) kosong, diisi null
        String[] data = {"A", "B", "C", "D", "E", null, "F"};

        BinaryTreeArray t = new BinaryTreeArray(data);

        System.out.print("Preorder   : ");
        t.preorder(0);
        System.out.println();

        System.out.print("Inorder    : ");
        t.inorder(0);
        System.out.println();

        System.out.print("Postorder  : ");
        t.postorder(0);
        System.out.println();

        System.out.print("Level-order: ");
        t.levelOrder();
        System.out.println();
    }
}
