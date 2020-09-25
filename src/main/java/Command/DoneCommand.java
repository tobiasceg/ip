package Command;

import task.Task;

import java.util.ArrayList;

public abstract class DoneCommand extends Command{
    static int DONE_REMOVAL = 5;

    public static void execute(String inputTask, ArrayList<Task> list) {
        String doneIndex = inputTask.substring(DONE_REMOVAL);
        list.get(Integer.parseInt(doneIndex)-1).markAsDone(1);
    }
}
