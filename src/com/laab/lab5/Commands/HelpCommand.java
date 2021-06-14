package com.laab.lab5.Commands;
import com.laab.lab5.Engine;

public class HelpCommand extends Command{
    public HelpCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute(){
        for (Command command : engine.getAllCommands()) {
            ioManager.write(command.getName() + " ");
            ioManager.writeLine(command.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return ":вывести справку по доступным командам";
    }

    @Override
    public String getName() {
        return "help";
    }
}
