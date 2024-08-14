import java.util.Stack;

class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        this.text = new StringBuilder();
    }

    public void type(String newText) {
        text.append(newText);
    }

    public String getText() {
        return text.toString();
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text.toString());
    }

    public void restore(TextEditorMemento memento) {
        text = new StringBuilder(memento.getState());
    }
}

class History {
    private Stack<TextEditorMemento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            TextEditorMemento memento = history.pop();
            editor.restore(memento);
        } else {
            System.out.println("No states to undo.");
        }
    }
}

public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.type("Hello, ");
        history.saveState(editor);

        editor.type("world!");
        history.saveState(editor);

        System.out.println("Current Text: " + editor.getText());

        history.undo(editor);
        System.out.println("After undo: " + editor.getText());

        history.undo(editor);
        System.out.println("After undo: " + editor.getText());

        history.undo(editor);
    }
}
