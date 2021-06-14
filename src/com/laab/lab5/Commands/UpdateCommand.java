package com.laab.lab5.Commands;

import com.laab.lab5.Engine;
import com.laab.lab5.typess.Ticket;

import java.io.IOException;

public class UpdateCommand extends Command {

    public UpdateCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException{
        long id = ioManager.LongReader("Enter id:");
        Ticket element = collection.get(id);
        if (element == null) {
            ioManager.writeLine("Элемент с данным ключём не найден.");
        }
    }

    @Override
    public String getDescription() {
        return ":обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}
