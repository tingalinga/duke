package duke.commands;

import duke.commands.Command;
import duke.TaskList;
import duke.Ui;
import duke.Storage;
import duke.exception.DukeException;

import java.io.IOException;

/**
 * DeleteCommand class handles user's request to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    int index;

    /**
     * Creates a new DeleteCommand.
     *
     * @param index index position of task that user wants to delete
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the delete command. Deletes specified task from the task list.
     *
     * @param tasks list of tasks
     * @param ui user interface
     * @param storage makeshift database for tasks
     * @throws DukeException if user input does not follow input format
     * @throws IOException named file exists but is a directory rather than a regular file,
     * does not exist but cannot be created, or cannot be open for any other reason.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {
        tasks.delete(this.index, storage);
        tasks.printSize();
    }

    /**
     * Returns a boolean that determines if command exits the program.
     *
     * @return boolean.
     */
    public boolean isExit() {
        return false;
    }

}