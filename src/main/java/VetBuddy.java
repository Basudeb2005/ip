import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VetBuddy {
    private static List<Task> tasks = new ArrayList<>();

    private static void printLineSeparator() {
        System.out.println("____________________________________________________________");
    }

    private static void printTaskAdded(Task task, int taskCount) {
        printLineSeparator();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        printLineSeparator();
    }

    private static boolean isValidIndex(int index, int taskCount) {
        return index >= 0 && index < taskCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineSeparator = "____________________________________________________________";
        String greetingMessage = " Hello! I'm VetBuddy";
        String actionPrompt = " What can I do for you?";

        System.out.println(lineSeparator);
        System.out.println(greetingMessage);
        System.out.println(actionPrompt);
        System.out.println(lineSeparator);

        while (true) {
            try {
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println(lineSeparator);
                    System.out.println(" Bye. Hope to see you again soon!");
                    System.out.println(lineSeparator);
                    break;
                } else if (input.equalsIgnoreCase("list")) {
                    System.out.println(lineSeparator);
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println(lineSeparator);
                } else if (input.startsWith("mark ")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (isValidIndex(index, tasks.size())) {
                        tasks.get(index).markAsDone();
                        printLineSeparator();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(tasks.get(index));
                        printLineSeparator();
                    } else {
                        printLineSeparator();
                        throw new DukeException("Oops!!! That mark number is invalid.");
                    }
                } else if (input.startsWith("unmark ")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (isValidIndex(index, tasks.size())) {
                        tasks.get(index).markAsNotDone();
                        printLineSeparator();
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println(tasks.get(index));
                        printLineSeparator();
                    } else {
                        printLineSeparator();
                        throw new DukeException("Oops!!! That unmark number is invalid.");
                    }
                } else if (input.startsWith("delete ")) {
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        if (isValidIndex(index, tasks.size())) {
                            Task removedTask = tasks.remove(index);
                            printLineSeparator();
                            System.out.println("Noted. I've removed this task:");
                            System.out.println(removedTask);
                            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                            printLineSeparator();
                        } else {
                            printLineSeparator();
                            throw new DukeException("Oops!!! That delete number is invalid.");
                        }
                    } catch (NumberFormatException e) {
                        printLineSeparator();
                        System.out.println("Oops!!! Please specify a valid task number to delete.");
                        printLineSeparator();
                    }
                } else if (input.startsWith("todo ")) {
                    String description = input.substring(5).trim();
                    if (description.isEmpty()) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    tasks.add(new Todo(description));
                    printTaskAdded(tasks.get(tasks.size() - 1), tasks.size());
                } else if (input.startsWith("deadline ")) {
                    if (!input.contains(" /by ")) {
                        printLineSeparator();
                        System.out.println("Invalid format. Use: deadline <description> /by <date>");
                        printLineSeparator();
                        continue;
                    }
                    String[] parts = input.substring(9).split(" /by ");
                    String description = parts[0];
                    String by = parts[1];
                    tasks.add(new Deadline(description, by));
                    printTaskAdded(tasks.get(tasks.size() - 1), tasks.size());
                } else if (input.startsWith("event ")) {
                    if (!input.contains(" /from ") || !input.contains(" /to ")) {
                        printLineSeparator();
                        System.out.println("Invalid format. Use: event <description> /from <start> /to <end>");
                        printLineSeparator();
                        continue;
                    }
                    String[] parts = input.substring(6).split(" /from ");
                    String description = parts[0];
                    String[] timeParts = parts[1].split(" /to ");
                    String from = timeParts[0];
                    String to = timeParts[1];
                    tasks.add(new Event(description, from, to));
                    printTaskAdded(tasks.get(tasks.size() - 1), tasks.size());
                } else {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                printLineSeparator();
                System.out.println(e.getMessage());
                printLineSeparator();
            }
        }
        scanner.close();
    }
}