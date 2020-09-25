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
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Storage {

    private static final int STATUS_REMOVAL = 7;

    public static void loadStorage(File dukeFile, Path dukeLocation, ArrayList<Task> list) {
        try {
            Scanner myReader = new Scanner(dukeFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String dueDate;
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
                        dueDate = DUE_DATE;
                        Event newTask = new Event(taskName, dueDate);
                        TaskList.addedList(list,  newTask, 0);
                        if (data.contains("\u2713")) {
                            newTask.markAsDone(0);
                        }
                    } else if (data.contains("[D]")) {
                        taskName = data.substring(STATUS_REMOVAL, data.indexOf("(") - 1);
                        dueDate = DUE_DATE;
                        Deadline newTask = new Deadline(taskName, dueDate);
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
