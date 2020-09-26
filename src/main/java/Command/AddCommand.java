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

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * AddCommand is responsible for any task that the user inputs to be
 * added to the arraylist list.
 *
 * If neither command is recognised, unknownCommand is thrown
 */
public abstract class AddCommand extends Command {

    /**
     * Extracts the task input in by the user and creates the relevant
     * respective task, adding it to the arraylist
     *
     * @param inputTask command input by the user
     * @param list arraylist to contain each task
     * @return flag indicating which task was created
     */

    public static int execute(String inputTask, ArrayList<Task> list) throws EmptyDeadline, EmptyEvent, EmptyToDo, UnknownCommand, DateTimeException {
        int taskFlag; // to differentiate between each task, thus different exception
        final int TODO_REMOVAL = 5;
        final int DEADLINE_REMOVAL = 9;
        final int EVENT_REMOVAL = 6;

        String taskName;
        String dueDate;

        DateTimeFormatter dateTimeEventFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        DateTimeFormatter dateTimeDeadlineFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HHmm");

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
            dueDate = inputTask.substring(inputTask.indexOf("/by") + 4).stripLeading().stripTrailing();
            LocalDateTime deadlineDate = LocalDateTime.parse(dueDate,dateTimeDeadlineFormatter);
            Deadline newTask = new Deadline(taskName, deadlineDate);
            TaskList.addedList(list, newTask, 1);

        } else if (inputTask.contains("event")) {
            taskFlag = 3;
            taskName = inputTask.substring(EVENT_REMOVAL, inputTask.indexOf("/") - 1);
            Parser.emptyChecker(taskName, taskFlag);
            dueDate = inputTask.substring(inputTask.indexOf("/at") + 4).stripLeading().stripTrailing();
            LocalDate eventDate = LocalDate.parse(dueDate,dateTimeEventFormatter);
            Event newTask = new Event(taskName, eventDate);
            TaskList.addedList(list, newTask, 1);
        } else {
            throw new UnknownCommand();
        }
        return taskFlag;
    }

}