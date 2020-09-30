package Command;

import task.Task;
import task.TaskList;

import java.util.ArrayList;

public abstract class FindCommand extends Command {

    static final int FIND_REMOVAL = 5;


    public static void execute(String inputTask,ArrayList<Task> list){
        ArrayList<Task> searchResults = new ArrayList<>();

        String searchWord = inputTask.substring(FIND_REMOVAL);
        for (Task i : list){
            if (i.toString().contains(searchWord)) {
                searchResults.add(i);
            }
        }
        TaskList.printSearchList(searchResults);
    }
}
