import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

import Command.AddCommand;
import Command.DeleteCommand;
import Command.DoneCommand;
import Command.FindCommand;
import exceptions.EmptyDeadline;
import exceptions.EmptyEvent;
import exceptions.EmptyToDo;
import exceptions.UnknownCommand;
import storage.Storage;
import task.Task;
import task.TaskList;

import ui.Ui;

    /**
     *  The main class Duke. Initialization of important variables
     *  And reading from the txt file to preload existing Tasks
     *  The main event loop happens inside here,
     *
     *  All catching of any exceptions that occur is done here
     */

public class Duke {
    public static void main(String[] args){
        Ui.introMessage();

        String reply;
        Scanner scan = new Scanner(System.in);

        String dukeHome = System.getProperty("user.dir");
        Path dukeLocation = Paths.get(dukeHome, "data", "duke.txt");
        File dukeFile = new File(String.valueOf(dukeLocation));

        ArrayList<Task> list = new ArrayList<>();

        Storage.loadStorage(dukeFile, dukeLocation, list);

        while (true) {
            reply = scan.nextLine();
            try {
                if (reply.equals("bye")) {
                    Ui.outroMessage();
                    break;
                } else if (reply.equals("list")) {
                    TaskList.printList(list);
                } else if (reply.contains("done")) {
                    DoneCommand.execute(reply, list);
                } else if (reply.contains("delete")) {
                    DeleteCommand.execute(reply, list);
                }else if (reply.contains("find")) {
                    FindCommand.execute(reply, list);
                } else {
                    AddCommand.execute(reply, list);
                }
                Storage.storageWriteToTextFile(dukeLocation,list);
            } catch ( UnknownCommand e) {
                Ui.unknownMessage();
            } catch ( EmptyToDo e) {
                Ui.emptyToDoMessage();
            } catch ( EmptyEvent e) {
                Ui.emptyEventMessage();
            } catch ( EmptyDeadline e) {
                Ui.emptyDeadlineMessage();
            } catch (IOException e) {
                Ui.printMissingFileMessage();
            } catch (DateTimeException e) {
                Ui.incorrectDateFormat();
            } catch (IndexOutOfBoundsException e) {
                Ui.outsideIndexMessage();
            }
        }
    }

}

