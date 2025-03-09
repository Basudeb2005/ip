/**
 * Parses user commands for VetBuddy.
 */
public class Parser {
    /**
     * Checks if the user typed "bye".
     *
     * @param input The entire command.
     * @return True if input is "bye", else false.
     */
    public static boolean isBye(String input) {
        return input.equalsIgnoreCase("bye");
    }

    /**
     * Checks if the user typed "list".
     *
     * @param input The entire command.
     * @return True if input is "list", else false.
     */
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

    /**
     * Checks if the user typed "deadline".
     *
     * @param input The entire command.
     * @return True if input starts with "deadline ", else false.
     */
    public static boolean isDeadline(String input) {
        return input.startsWith("deadline ");
    }

    public static boolean isEvent(String input) {
        return input.startsWith("event ");
    }

    /**
     * Checks if the user typed "find".
     *
     * @param input The entire command.
     * @return True if input starts with "find ", else false.
     */
    public static boolean isFind(String input) {
        return input.startsWith("find ");
    }

    /**
     * Extracts a zero-based index (e.g., from "mark 2").
     *
     * @param input The entire command.
     * @return The parsed index.
     */
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
        return new String[]{desc, timeParts[0], timeParts[1]};
    }

    /**
     * Splits user input into a command word and any trailing argument.
     *
     * @param input The entire command.
     * @return A two-element array [command, argument].
     */
    public static String[] parseInput(String input) {
        String[] split = input.trim().split(" ", 2);
        if (split.length == 1) {
            return new String[]{split[0], ""};
        } else {
            return new String[]{split[0], split[1].trim()};
        }
    }

    /**
     * Extracts the keyword after "find ".
     *
     * @param input The entire command, starting with "find ".
     * @return The substring representing the keyword.
     */
    public static String getFindKeyword(String input) {
        return input.substring(5).trim();
    }
}
