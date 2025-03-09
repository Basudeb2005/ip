/**
 * Represents an event task with a start and end time.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Creates an Event with a description, start time, and end time.
     *
     * @param description The event details.
     * @param from        The start time.
     * @param to          The end time.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a file-friendly string representation for saving.
     */
    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }

    /**
     * Returns a string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
