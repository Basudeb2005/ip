import java.util.Scanner;

public class VetBuddy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineSeparator = "____________________________________________________________";
        String greetingMessage = " Hello! I'm VetBuddy";
        String actionPrompt = " What can I do for you?";

        String[] tasks = new String[100];
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
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println(lineSeparator);
            } else {
                tasks[taskCount] = input;
                taskCount++;
                System.out.println(lineSeparator);
                System.out.println(" added: " + input);
                System.out.println(lineSeparator);
            }


            System.out.println(lineSeparator);
            System.out.println(" " + input);
            System.out.println(lineSeparator);
        }

        scanner.close();
    }
}
