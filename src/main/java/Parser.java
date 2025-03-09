public class Parser {
    public static boolean isBye(String input) {
        return input.equalsIgnoreCase("bye");
    }

    public static boolean isList(String input) {
        return input.equalsIgnoreCase("list");
    }

    public static boolean isMark(String input) {
        return input.startsWith("mark ");
    }

    public static boolean isUnmark(String input) {
        return input.startsWith("unmark ");
    }

    public static boolean isDelete(String input) {
        return input.startsWith("delete ");
    }

    public static boolean isTodo(String input) {
        return input.startsWith("todo ");
    }

    public static boolean isDeadline(String input) {
        return input.startsWith("deadline ");
    }

    public static boolean isEvent(String input) {
        return input.startsWith("event ");
    }

    public static int getIndex(String input) {
        return Integer.parseInt(input.split(" ")[1]) - 1;
    }

    public static String getTodoDescription(String input) {
        return input.substring(5).trim();
    }

    public static String[] getDeadlineParts(String input) {
        String content = input.substring(9).trim();
        return content.split(" /by ", 2);
    }

    public static String[] getEventParts(String input) {
        String content = input.substring(6).trim();
        String[] parts = content.split(" /from ", 2);
        String desc = parts[0];
        String[] timeParts = parts[1].split(" /to ", 2);
        return new String[] { desc, timeParts[0], timeParts[1] };
    }
}
