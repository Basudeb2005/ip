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
            } else {
                tasks[taskCount] = new Task(input);
                taskCount++;
                System.out.println(lineSeparator);
                System.out.println(" added: " + input);
                System.out.println(lineSeparator);
            }
        }
        scanner.close();
    }


}
