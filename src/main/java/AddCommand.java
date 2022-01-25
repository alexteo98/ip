public class AddCommand extends Command{
    public AddCommand(String userInput){
        super(userInput);
    }

    public boolean execute(Storage storage, Ui ui, TaskManager taskManager) throws DukeException {
        try {
            Task task = Parser.parseToTask(this.userInput);
            taskManager.addTask(task);
            ui.showAddedTask(task, taskManager.size());
            storage.saveTaskManager(taskManager);
            return true;
        } catch (FailedTaskParseException exception){
            throw new DukeException("Wrong Format!");
        }
    }
}
