import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages reading and writing tasks to a file.
 */
public class Storage {
    private String filePath;

    /**
     * Creates a Storage object to handle tasks from the specified file path.
     *
     * @param filePath Path to the tasks file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file. Returns an empty list if no file exists or errors occur.
     *
     * @return A list of Task objects loaded from the file.
     */
    public List<Task> load() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return tasks;
        }
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" \\| ");
                Task task;
                switch (parts[0]) {
                    case "T":
                        task = new Todo(parts[2]);
                        break;
                    case "D":
                        task = new Deadline(parts[2], parts[3]);
                        break;
                    case "E":
                        task = new Event(parts[2], parts[3], parts[4]);
                        break;
                    default:
                        continue;
                }
                if (parts[1].equals("1")) {
                    task.markAsDone();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks. The file might be corrupted.");
        }
        return tasks;
    }

    public void save(List<Task> tasks) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }
}
