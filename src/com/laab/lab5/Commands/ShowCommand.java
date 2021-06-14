package com.laab.lab5.Commands;
import com.laab.lab5.Engine;

public class ShowCommand extends Command{
    public ShowCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        ioManager.writeLine(collection.getPersonsA().toString());
    }

    @Override
    public String getDescription() {
        return ":вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
