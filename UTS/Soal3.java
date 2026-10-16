package UTS;

class AksiText {
    String tipeAksi;
    String konten;

    AksiText(String tipeAksi, String konten) {
        this.tipeAksi = tipeAksi;
        this.konten = konten;
    }
}

class StackNode {
    AksiText data;
    StackNode next;

    StackNode(AksiText data) {
        this.data = data;
    }
}

class ActionStack {
    StackNode top;

    boolean isEmpty() {
        return top == null;
    }

    void clear() {
        top = null;
    }

    void push(AksiText aksi) {
        StackNode n = new StackNode(aksi);
        n.next = top;
        top = n;
    }

    AksiText pop() {
        if (top == null) {
            return null;
        }
        AksiText aksi = top.data;
        top = top.next;
        return aksi;
    }

    void tampil() {
        if (top == null) {
            System.out.println("(kosong)");
            return;
        }
        StackNode temp = top;
        while (temp != null) {
            System.out.println(temp.data.tipeAksi + " " + temp.data.konten);
            temp = temp.next;
        }
    }
}

class TextEditor {
    ActionStack undoStack = new ActionStack();
    ActionStack redoStack = new ActionStack();

    void go(String tipe, String konten) {
        undoStack.push(new AksiText(tipe, konten));
        redoStack.clear();
        System.out.println("Aksi: " + tipe + " " + konten);
    }

    void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("gada aksi untuk di-undo");
            return;
        }
        AksiText aksi = undoStack.pop();
        System.out.println("Undo: " + aksi.tipeAksi + " " + aksi.konten);
        redoStack.push(aksi);
    }

    void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("gada aksi untuk di-redo");
            return;
        }
        AksiText aksi = redoStack.pop();
        System.out.println("Redo: " + aksi.tipeAksi + " " + aksi.konten);
        undoStack.push(aksi);
    }
}

public class Soal3 {
    public static void main(String[] args) {
        TextEditor e = new TextEditor();
        e.go("KETIK", "Hey");
        e.go("KETIK", "Ho");
        e.go("HAPUS", "Ho");

        System.out.println("\nUndo 2 kali:");
        e.undo();
        e.undo();
        System.out.println("Isi undoStack:");
        e.undoStack.tampil();
        System.out.println("Isi redoStack:");
        e.redoStack.tampil();

        System.out.println("\nRedo 1 kali:");
        e.redo();

        System.out.println("\nAksi, redoStack kosong:");
        e.go("KETIK", " Java");
        System.out.println("Isi redoStack:");
        e.redoStack.tampil();

        System.out.println("\nRedo setelah aksi :");
        e.redo();

        System.out.println("\nUndo sampai habis:");
        e.undo();
        e.undo();
        e.undo();
        e.undo();
    }
}
