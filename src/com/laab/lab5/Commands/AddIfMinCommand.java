package com.laab.lab5.Commands;
import com.laab.lab5.Engine;


import java.io.IOException;

public class AddIfMinCommand extends Command{
    public AddIfMinCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException {
        String ticketType= ioManager.StringReader("enum?");
        collection.FilterTicket(ticketType);
    }

    @Override
    public String getDescription() {
        return ": добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
