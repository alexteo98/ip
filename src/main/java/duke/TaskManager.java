package duke;

import duke.exceptions.DukeException;
import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskManager(){}
    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean addTask(String s) throws DukeException {
        try {
            Task t = Parser.parseToTask(s);
            tasks.add(t);

            return true;
        } catch (DukeException e){
            String message = e.getMessage();
            throw new DukeException(message + "/nUnable to add Task!");
        }
    }
    public void addTask(Task t){
        this.tasks.add(t);
    }

    public boolean deleteTask(int index){
        if (tasks.size() == 0){
            return false;
        } else {
            if (index < 0 || index >= tasks.size()){
                return false;
            } else {
                Task t = tasks.get(index);
                tasks.remove(index);
                return true;
            }
        }
    }

    public boolean deleteTask(Task t){
        return tasks.remove(t);
    }

    public boolean markTaskDone(int index){
        if (tasks.size() <= 0){
            return false;
        } else {
            if (index < 0 || index >= tasks.size()){
                return false;
            } else {
                Task t = tasks.get(index);
                if (t.getDone() == ' ') {
                    t.markDone();
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    public boolean markTaskDone(Task t) {
        if (t.getDone() == ' ') {
            tasks.get(tasks.indexOf(t)).markDone();
            return true;
        }
        return false;
    }

    public boolean markTaskUndone(int index){
        if (tasks.size() <= 0){
            return false;
        } else {
            if (index < 0 || index >= tasks.size()) {
                return false;
            } else {
                Task t = tasks.get(index);
                if (t.getDone() == 'X') {
                    t.markUndone();
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    public boolean markTaskUndone(Task t) {
        if (t.getDone() == 'X') {
            tasks.get(tasks.indexOf(t)).markUndone();
            return true;
        }
        return false;
    }

    public ArrayList<Task> getTaskList(){
        return this.tasks;
    }
    public Task getTask(int index) {
        if (size() == 0){
            return null;
        }

        if (index < 0 || index >= size()){
            return null;
        }

        return tasks.get(index);
    }

    public int size(){
        return tasks.size();
    }
}