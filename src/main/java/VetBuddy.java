import java.util.Scanner;

public class VetBuddy {
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
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(lineSeparator);
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println(lineSeparator);
                break;
            }


            System.out.println(lineSeparator);
            System.out.println(" " + input);
            System.out.println(lineSeparator);
        }

        scanner.close();
    }
}
