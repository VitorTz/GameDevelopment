package ougi.commands;

public interface Command<T> {

    public abstract void execute();
    public abstract void undo();

}
