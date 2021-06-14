package com.laab.lab5.Commands;
import com.laab.lab5.Engine;
//import com.laab.lab5.types.Location;

import java.io.IOException;

public class FilterBySemesterEnumCommand extends Command{
    public FilterBySemesterEnumCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException {
        String semester = ioManager.StringReader("enum?");
        collection.FilterSemester(semester);
    }

    @Override
    public String getDescription() {
        return ":вывести количество элементов, значение поля location которых равно заданному";
    }

    @Override
    public String getName() {
        return "filter_by_semester_enum";
    }
}
