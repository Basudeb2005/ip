public class Ui {
    public void showLine() {
        System.out.println("=================================================");
    }

    public void showWelcome() {
        System.out.println();
        showLine();
        System.out.println("Hello! I'm VetBuddy.");
        System.out.println("How can I help you today?");
        showLine();
    }

    public String readCommand() {
        return new java.util.Scanner(System.in).nextLine().trim();
    }

    public void showBye() {
        showLine();
        System.out.println("Bye. Hope to see you again soon!");
        showLine();
    }

    public void showList(TaskList tasks) {
        showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        showLine();
    }

    public void showMarked(Task task) {
        showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
        showLine();
    }

    public void showUnmarked(Task task) {
        showLine();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task);
        showLine();
    }

    public void showDeleted(Task task, int size) {
        showLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + size + " tasks in the list.");
        showLine();
    }

    public void showAdded(Task task, int size) {
        showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + size + " tasks in the list.");
        showLine();
    }

    public void showUnknown() {
        showLine();
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        showLine();
    }

    public void showError(String msg) {
        showLine();
        System.out.println(msg);
        showLine();
    }
}