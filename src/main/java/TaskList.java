import java.util.List;
import java.util.ArrayList;

/**
 * Holds and manages a list of Task objects.
 */
public class TaskList {
    private List<Task> tasks;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Retrieves the Task at a given index.
     *
     * @param index Zero-based position in the list.
     * @return The Task at that position.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the total number of tasks.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Adds a Task to the list.
     *
     * @param task The Task to add.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    public Task delete(int index) {
        return tasks.remove(index);
    }

    public void markAsDone(int index) {
        tasks.get(index).markAsDone();
    }

    public void markAsNotDone(int index) {
        tasks.get(index).markAsNotDone();
    }

    public List<Task> getAll() {
        return tasks;
    }

    /**
     * Finds tasks containing a given keyword.
     *
     * @param keyword The search term.
     * @return An array of matching tasks.
     */
    public Task[] findTasks(String keyword) {
        List<Task> matched = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().contains(keyword)) {
                matched.add(t);
            }
        }
        Task[] results = new Task[matched.size()];
        return matched.toArray(results);
    }
}
