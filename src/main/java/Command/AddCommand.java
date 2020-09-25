package Command;

import exceptions.EmptyDeadline;
import exceptions.EmptyEvent;
import exceptions.EmptyToDo;
import exceptions.UnknownCommand;
import parser.Parser;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.Todo;

import java.util.ArrayList;

public abstract class AddCommand extends Command {

    public static int execute(String inputTask, ArrayList<Task> list) throws EmptyDeadline, EmptyEvent, EmptyToDo, UnknownCommand {
        int taskFlag;
        final int TODO_REMOVAL = 5;
        final int DEADLINE_REMOVAL = 9;
        final int EVENT_REMOVAL = 6;

        String taskName;
        String dueDate;

        if (inputTask.contains("todo")) {
            taskFlag = 1;
            taskName = inputTask.substring(TODO_REMOVAL);
            Parser.emptyChecker(taskName, taskFlag);
            Todo newTask = new Todo(taskName);
            TaskList.addedList(list, newTask, 1);

        } else if (inputTask.contains("deadline")) {
            taskFlag = 2;
            taskName = inputTask.substring(DEADLINE_REMOVAL, inputTask.indexOf("/") - 1);
            Parser.emptyChecker(taskName, taskFlag);
            dueDate = inputTask.substring(inputTask.indexOf("/by") + 4);
            Deadline newTask = new Deadline(taskName, dueDate);
            TaskList.addedList(list, newTask, 1);

        } else if (inputTask.contains("event")) {
            taskFlag = 3;
            taskName = inputTask.substring(EVENT_REMOVAL, inputTask.indexOf("/") - 1);
            Parser.emptyChecker(taskName, taskFlag);
            dueDate = inputTask.substring(inputTask.indexOf("/at") + 4);
            Event newTask = new Event(taskName, dueDate);
            TaskList.addedList(list, newTask, 1);
        } else {
            throw new UnknownCommand();
        }
        return taskFlag;
    }

}