package Command;

import task.Task;
import task.TaskList;

import java.util.ArrayList;

public abstract class DeleteCommand extends Command{
    static int DELETE_REMOVAL = 7;

    public static void execute(String inputTask, ArrayList<Task> list) {
        String deleteIndex = inputTask.substring(DELETE_REMOVAL);
        TaskList.printDelete(list.get((Integer.parseInt(deleteIndex)-1)), list.size()-1);
        list.remove((Integer.parseInt(deleteIndex)-1));
    }
}
