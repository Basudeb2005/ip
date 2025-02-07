import java.util.Scanner;

public class VetBuddy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineSeparator = "____________________________________________________________";
        String greetingMessage = " Hello! I'm VetBuddy";
        String actionPrompt = " What can I do for you?";

        Task[] tasks = new Task[100];
        int taskCount = 0;

        System.out.println(lineSeparator);
        System.out.println(greetingMessage);
        System.out.println(actionPrompt);
        System.out.println(lineSeparator);

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(lineSeparator);
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println(lineSeparator);
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println(lineSeparator);
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". [" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
                }
                System.out.println(lineSeparator);
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsDone();
                    System.out.println(lineSeparator);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[X] " + tasks[index].getDescription());
                    System.out.println(lineSeparator);
                }
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markAsNotDone();
                    System.out.println(lineSeparator);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("[ ] " + tasks[index].getDescription());
                    System.out.println(lineSeparator);
                }
            }  else if (input.startsWith("todo ")) {
                String description = input.substring(5);
                tasks[taskCount] = new Todo(description);
                taskCount++;
                System.out.println(lineSeparator);
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].toString());
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println(lineSeparator);
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                String description = parts[0];
                String by = parts[1];
                tasks[taskCount] = new Deadline(description, by);
                taskCount++;
                System.out.println(lineSeparator);
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].toString());
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println(lineSeparator);
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from ");
                String description = parts[0];
                String[] timeParts = parts[1].split(" /to ");
                String from = timeParts[0];
                String to = timeParts[1];
                tasks[taskCount] = new Event(description, from, to);
                taskCount++;
                System.out.println(lineSeparator);
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].toString());
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println(lineSeparator);
            } else {
                tasks[taskCount] = new Todo(input);
                taskCount++;
                System.out.println(lineSeparator);
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1].toString());
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println(lineSeparator);
            }


        }
        scanner.close();
    }


}
