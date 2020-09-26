package Command;

import task.Task;
import task.TaskList;

import java.util.ArrayList;

/**
 * DeleteCommand is responsible for the removal of the desired task
 */

public abstract class DeleteCommand extends Command{
    static int DELETE_REMOVAL = 7;

    /**
     * Scans the list and deletes the desired task
     *
     * @param inputTask command with input task to be deleted
     * @param list the arraylist where the task resides.
     */
    public static void execute(String inputTask, ArrayList<Task> list) {
        String deleteIndex = inputTask.substring(DELETE_REMOVAL);
        TaskList.printDelete(list.get((Integer.parseInt(deleteIndex)-1)), list.size()-1);
        list.remove((Integer.parseInt(deleteIndex)-1));
    }
}
