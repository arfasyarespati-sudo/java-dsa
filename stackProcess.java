class TextUndoStack {
    private String[] stack;
    private int top;
    private int maxSize;

    public TextUndoStack(int size) {
        this.maxSize = size;
        this.stack = new String[maxSize];
        this.top = -1;
    }

    // push
    public void type(String text) {
        if (top < maxSize - 1) {
            top++;
            stack[top] = text;
            System.out.println("Typing: " + text);
        } else {
            System.out.println("Undo history is full");
        }
    }

    // pop
    public void undo() {
        if (top >= 0) {
            System.out.println("Undo action: " + stack[top]);
            stack[top] = null;
            top--;
        } else {
            System.out.println("Nothing to undo. Text is empty.");
        }
    }
}

public class stackProcess {
    public static void main(String[] args) {
        TextUndoStack textEditor = new TextUndoStack(5);

        textEditor.type("Hello");
        textEditor.type("Hello World");
        textEditor.type("Hello World Java");

        textEditor.undo();
        textEditor.undo();
    }
}