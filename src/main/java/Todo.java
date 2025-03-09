/**
 * Represents a simple task without any time constraints.
 */
public class Todo extends Task {
    /**
     * Creates a Todo with the given description.
     *
     * @param description The description of the todo.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a file-friendly string representation for saving.
     */
    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
