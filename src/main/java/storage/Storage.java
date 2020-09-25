package storage;

import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Storage {

    private static final int STATUS_REMOVAL = 7;
    private static DateTimeFormatter dateTimeEventFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private static DateTimeFormatter dateTimeDeadlineFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    public static void loadStorage(File dukeFile, Path dukeLocation, ArrayList<Task> list) {
        try {
            Scanner myReader = new Scanner(dukeFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                LocalDate dueDateEvent;
                LocalDateTime dueDateDeadline;
                String taskName;


                if (data.startsWith("[T]")) {
                    taskName = data.substring(STATUS_REMOVAL);
                    Todo newTask = new Todo(taskName);
                    TaskList.addedList(list,  newTask, 0);
                    if (data.contains("\u2713")) {
                        newTask.markAsDone(0);
                    }
                } else {
                    final String DUE_DATE = data.substring(data.indexOf(":") + 2, data.indexOf(")"));
                    if (data.contains("[E]")) {
                        taskName = data.substring(STATUS_REMOVAL, data.indexOf("(") - 1);
                        dueDateEvent = LocalDate.parse(DUE_DATE,dateTimeEventFormatter);
                        Event newTask = new Event(taskName, dueDateEvent);
                        TaskList.addedList(list,  newTask, 0);
                        if (data.contains("\u2713")) {
                            newTask.markAsDone(0);
                        }
                    } else if (data.contains("[D]")) {
                        taskName = data.substring(STATUS_REMOVAL, data.indexOf("(") - 1);
                        dueDateDeadline = LocalDateTime.parse(DUE_DATE,dateTimeDeadlineFormatter);
                        Deadline newTask = new Deadline(taskName, dueDateDeadline);
                        TaskList.addedList(list,  newTask, 0);
                        if (data.contains("\u2713")) {
                            newTask.markAsDone(0);
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            try {
                Path path = Paths.get(String.valueOf(dukeLocation)); //if file is missing create a new file
                Files.createDirectory(path.getParent());
            } catch (IOException i) {
                System.out.println("Error creating file");
            }
        }
    }

    public static void storageWriteToTextFile(Path dukeLocation,ArrayList<Task> list) throws IOException {
        FileWriter fw = new FileWriter(dukeLocation.toString());
        for (Task i : list) {
            fw.write(i.toString() + "\n");
        }
        fw.close();
    }
}
