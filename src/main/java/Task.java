/**
 * Represents a task with a description and completion status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task with the given description, initially not done.
     *
     * @param description The task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /** Marks the task as done. */
    public void markAsDone() {
        isDone = true;
    }

    /** Marks the task as not done. */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns "X" if done, otherwise a space.
     *
     * @return "X" if task is done, " " otherwise.
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * Returns the task description.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the task, including its status and description.
     *
     * @return Formatted string of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /** Returns a file-friendly string for saving the task. */
    public String toFileString() {
        return (this instanceof Todo ? "T" :
                this instanceof Deadline ? "D" :
                        this instanceof Event ? "E" : "?")
                + " | " + (isDone ? "1" : "0") + " | " + description;
    }
}
