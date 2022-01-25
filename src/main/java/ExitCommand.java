public class ExitCommand extends Command{
    public ExitCommand(String userInput){
        super(userInput);
    }

    @Override
    public boolean isExit(){
        return true;
    }

    public boolean execute(Storage storage, Ui ui, TaskManager taskManager){
        ui.showBye();
        return true;
    }
}
