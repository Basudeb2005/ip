public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + description;
    }
    public String toFileString() {
        return (this instanceof Todo ? "T" :
                this instanceof Deadline ? "D" :
                        this instanceof Event ? "E" : "?")
                + " | " + (isDone ? "1" : "0") + " | " + description;
    }

}