package duke.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import duke.Storage;
import duke.TaskManager;
import duke.Ui;
import duke.exceptions.DukeException;
import duke.tasks.Task;

/**
 * Represents a command to display the current tasks in TaskManager, sorted by name.
 */
public class SortByNameCommand extends Command {

    /**
     * Executes and displays the given TaskManager to the Ui, ordered by their names.
     *
     * @param storage Not used.
     * @param ui The Ui to display the task list to.
     * @param taskManager The Task Manager that contains the list of task.
     * @return true after the list is displayed.
     * @see TaskByNameComparator
     */
    public String execute(Storage storage, Ui ui, TaskManager taskManager) throws DukeException {
        ArrayList tasks = taskManager.getTaskList();
        Collections.sort(tasks, new TaskByNameComparator());
        save(storage, ui, taskManager);
        return new ListCommand().execute(storage, ui, taskManager);
    }
}
/**
 * Represents a comparator to compare two Tasks, to impose a total ordering on a collection of Tasks,
 * ordered by their names lexicographically.
 *
 * @see Task
 * @see Comparator
 */
class TaskByNameComparator implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return t1.getTaskName().compareTo(t2.getTaskName());
    }
}
