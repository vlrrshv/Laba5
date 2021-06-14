package com.laab.lab5.Commands;

import com.laab.lab5.Engine;
import com.laab.lab5.typess.*;
import java.io.IOException;
import java.time.LocalDate;

public class InsertCommand extends Command{
    public InsertCommand(Engine engine) {
        super(engine);
    }

    @Override
    public void execute() throws IOException, NumberFormatException {
        //long id = System.currentTimeMillis() % Integer.MAX_VALUE;
        //long id = collection.GetMaxKey()+1;
        Long id = ioManager.LongReader("Enter id:");
        String name = ioManager.StringReader("Enter name:");

        Integer price = ioManager.IntegerReader("Enter price:");
        Double x = ioManager.DoubleReader("Enter x:", 585d);
        Long y = ioManager.LongReader("Enter y");

        LocalDate creationDate = LocalDate.now();

        TicketType type = ioManager.TicketTypeReader("Enter ticket: {VIP, " + "USUAL, " + "BUDGETARY, " + "CHEAP;}");


        EventType event = ioManager.EventTypeReader("Enter event: {CONCERT," + "FOOTBALL," + "BASKETBALL" + "OPERA" + "THEATRE_PERFORMANCE;}");


        Coordinates coordinates = new Coordinates(x,y);


        
        Ticket p = new Ticket(id,name,coordinates,creationDate,price, price,type ,event);
        collection.add(p);
        ioManager.writeLine("Object was added: " + p.toString());
    }

    @Override
    public String getDescription() {
        return ":добавить новый элемент в коллекцию";
    }

    @Override
    public String getName() {
        return "insert";
    }
}