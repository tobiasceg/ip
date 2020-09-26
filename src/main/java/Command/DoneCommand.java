package Command;

import task.Task;

import java.util.ArrayList;

/**
 * DoneCommand is responsible for changing the status of the task
 */
public abstract class DoneCommand extends Command{
    static int DONE_REMOVAL = 5;

    /**
     * Scans the arraylist and changes the status of the task, boolean
     * isDone from false to true.
     *
     * @param inputTask Command with the task index to be marked done
     * @param list arraylist to be scanned
     */
    public static void execute(String inputTask, ArrayList<Task> list) {
        String doneIndex = inputTask.substring(DONE_REMOVAL);
        list.get(Integer.parseInt(doneIndex)-1).markAsDone(1);
    }
}
