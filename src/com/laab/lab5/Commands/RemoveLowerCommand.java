package com.laab.lab5.Commands;
import com.laab.lab5.Engine;
import java.io.IOException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class RemoveLowerCommand extends Command{
    public RemoveLowerCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException {
        long id = ioManager.LongReader("Enter id");
        if (collection.get(id) == null) {
            ioManager.writeLine("Элемент с заданным ключём отстутствует.");
        } else {
            collection.removeLower(id);
            ioManager.writeLine("Коллекция очищена.");
        }
    }

    @Override
    public String getDescription() {
        return ":удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_lower";
    }
}
