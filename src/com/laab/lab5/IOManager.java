package com.laab.lab5;


import com.laab.lab5.typess.TicketType;
import com.laab.lab5.typess.EventType;

import java.io.*;

import static com.laab.lab5.IsDigit.*;


public class IOManager {
    private final BufferedOutputStream bufferedOutputStream;
    private final InputStreamReader inputStreamReader;

    public IOManager(){
        inputStreamReader = new InputStreamReader(System.in);
        bufferedOutputStream = new BufferedOutputStream(System.out);
    }

    public void write(String s) {
        try {
            bufferedOutputStream.write(s.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String s) {
        write(s + "\n");
    }

    public String readNext() {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                if (!inputStreamReader.ready()) break;
                char c = (char)inputStreamReader.read();
                if (c == '\n'){break;}
                if (stringBuilder.length() != 0 && Character.isWhitespace(c)) break;
                stringBuilder.append(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String read() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // создать экземпляр InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // экземпляр класса буферизации
        return bufferedReader.readLine();
    }

    public String StringReader(String question) throws IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty()) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return value;
    }

    /**
     * Метод для чтения вводимых чисел типа Integer
     */
    public Integer IntegerReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !IsDigit.isInteger(value) || !(Integer.parseInt(value) > 0)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Integer.valueOf(value);
    }

    /**
     * Метод для чтения вводимых чисел типа Float
     * @param maxValue максимальное значение, которое может ввести пользователь
     */
    public Double DoubleReader(String question, Double maxValue) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value) || (Float.parseFloat(value) > maxValue)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Double.valueOf(value);
    }

    /**
     * Метод для чтения вводимых чисел типа Float
     */
    public Float FloatReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Float.valueOf(value);
    }

    /**
     * Метод для чтения вводимых чисел типа Double
     */
    public Double DoubleReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isDouble(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Double.valueOf(value);
    }

    /**
     * Метод для чтения вводимых чисел типа Long
     */
    public Long LongReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isLong(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Long.valueOf(value);
    }



    public TicketType TicketTypeReader(String question) throws IllegalArgumentException,IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || (!value.equals("VIP") && !value.equals("USUAL") && !value.equals("BUDGETARY"))) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return TicketType.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых данных
     */

    public EventType EventTypeReader(String question) throws IllegalArgumentException,IOException{
        String value = "";
        while (value == "") {
            writeLine(question);
            value = read();
            try {
                EventType.valueOf(value);
            } catch (IllegalArgumentException e) {
                writeLine("Invalid value");
                value = "";
            }
        }
        return EventType.valueOf(value);
    }
}

