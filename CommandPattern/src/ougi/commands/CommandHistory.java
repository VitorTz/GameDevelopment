package ougi.commands;

import ougi.util.Constants;

import java.util.LinkedList;

public class CommandHistory {

    private static final LinkedList<Command<?>> commandsHistory = new LinkedList<>();
    private static boolean undoActive = false;

    public static void addCommand(Command<?> command) {
        if (!CommandHistory.undoActive) {
            command.execute();
            if (CommandHistory.commandsHistory.size() >= Constants.COMMAND_HISTORY_MAX_SIZE) {
                for (int i = 0; i < 100; i++)
                    CommandHistory.commandsHistory.removeFirst();
                System.out.println("Command History max size reached!!");
            }
            CommandHistory.commandsHistory.addLast(command);
        }
    }

    public static void run() {
        if (CommandHistory.undoActive && !CommandHistory.commandsHistory.isEmpty())
            CommandHistory.commandsHistory.removeLast().undo();
    }

    public static void setUndoActive(boolean undoActive) {
        CommandHistory.undoActive = undoActive;
    }
}
