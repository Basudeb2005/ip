import java.util.Scanner;

public class VetBuddy {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public VetBuddy(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.showWelcome();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = ui.readCommand();
                if (Parser.isBye(input)) {
                    ui.showBye();
                    break;
                } else if (Parser.isList(input)) {
                    ui.showList(tasks);
                } else if (Parser.isMark(input)) {
                    int index = Parser.getIndex(input);
                    tasks.markAsDone(index);
                    ui.showMarked(tasks.get(index));
                    storage.save(tasks.getAll());
                } else if (Parser.isUnmark(input)) {
                    int index = Parser.getIndex(input);
                    tasks.markAsNotDone(index);
                    ui.showUnmarked(tasks.get(index));
                    storage.save(tasks.getAll());
                } else if (Parser.isDelete(input)) {
                    int index = Parser.getIndex(input);
                    Task removed = tasks.delete(index);
                    ui.showDeleted(removed, tasks.size());
                    storage.save(tasks.getAll());
                } else if (Parser.isTodo(input)) {
                    String desc = Parser.getTodoDescription(input);
                    Task t = new Todo(desc);
                    tasks.add(t);
                    ui.showAdded(t, tasks.size());
                    storage.save(tasks.getAll());
                } else if (Parser.isDeadline(input)) {
                    String[] parts = Parser.getDeadlineParts(input);
                    Task t = new Deadline(parts[0], parts[1]);
                    tasks.add(t);
                    ui.showAdded(t, tasks.size());
                    storage.save(tasks.getAll());
                } else if (Parser.isEvent(input)) {
                    String[] parts = Parser.getEventParts(input);
                    Task t = new Event(parts[0], parts[1], parts[2]);
                    tasks.add(t);
                    ui.showAdded(t, tasks.size());
                    storage.save(tasks.getAll());
                } else if (Parser.isFind(input)) {
                    String keyword = Parser.getFindKeyword(input);
                    Task[] foundTasks = tasks.findTasks(keyword);
                    System.out.println(ui.showFindResults(foundTasks));
                } else {
                    ui.showUnknown();
                }
            } catch (Exception e) {
                ui.showError("Oops! Something went wrong.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new VetBuddy("data/duke.txt").run();
    }
}
