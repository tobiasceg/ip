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
     */

    public static void execute(String inputTask, ArrayList<Task> list) throws EmptyDeadline, EmptyEvent, EmptyToDo, UnknownCommand, DateTimeException {
        final int TODO_REMOVAL = 5;
        final int DEADLINE_REMOVAL = 9;
        final int EVENT_REMOVAL = 6;

        String taskName;
        String dueDate;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HHmm");

        Parser.emptyTaskChecker(inputTask.trim());

        if (inputTask.contains("todo")) {
            taskName = inputTask.substring(TODO_REMOVAL);
            Todo newTask = new Todo(taskName);
            TaskList.addedList(list, newTask, 1);

        } else if (inputTask.contains("deadline")) {
            Parser.missingFormatChecker(inputTask);
            taskName = inputTask.substring(DEADLINE_REMOVAL, inputTask.indexOf("/") - 1);
            dueDate = inputTask.substring(inputTask.indexOf("/by") + 4).stripLeading().stripTrailing();
            LocalDateTime deadlineDate = LocalDateTime.parse(dueDate, dateTimeFormatter);
            Deadline newTask = new Deadline(taskName, deadlineDate);
            TaskList.addedList(list, newTask, 1);

        } else if (inputTask.contains("event")) {
            Parser.missingFormatChecker(inputTask);
            taskName = inputTask.substring(EVENT_REMOVAL, inputTask.indexOf("/") - 1);
            dueDate = inputTask.substring(inputTask.indexOf("/at") + 4).stripLeading().stripTrailing();
            LocalDateTime eventDate = LocalDateTime.parse(dueDate, dateTimeFormatter);
            Event newTask = new Event(taskName, eventDate);
            TaskList.addedList(list, newTask, 1);
        } else {
            throw new UnknownCommand();
        }
    }
}