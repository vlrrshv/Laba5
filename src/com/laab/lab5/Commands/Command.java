package com.laab.lab5.Commands;

import com.laab.lab5.Engine;
import com.laab.lab5.IOManager;
import com.laab.lab5.typess.Manager;

import javax.xml.bind.JAXBException;
import java.io.IOException;
/**
 * Класс - заготовка для команд, определяет их поведение
 */
public abstract class Command {
    protected final Engine engine;
    protected final IOManager ioManager;
    protected final Manager collection;

    public Command(Engine engine) {
        this.engine = engine;
        this.ioManager = engine.getIOManager();
        this.collection = engine.getCollection();
    }
    /**
     * метод, который непорседственно выполняет команду
     */
    public abstract void execute() throws IOException, JAXBException;
    /**
     * метод, возвращающий описание команды
     */
    public abstract String getDescription();
    /**
     * метод, возвращающий имя команды
     */
    public abstract String getName();
}
