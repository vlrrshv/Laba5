package com.laab.lab5.typess;



import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс, реализующий методы для управления объектами коллекции
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Manager {

    @XmlElement(name = "groupA")
    public static TreeMap<Long,Ticket> groupsA = new TreeMap<>();

    public long biggestId;

    private final LocalDate initializationDate;

    public Manager() {
        initializationDate = LocalDate.now();
    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        groupsA.clear();
    }

    public void removeLower(long id) throws NoSuchElementException{
        while (groupsA.firstKey() < id) {
            groupsA.remove(groupsA.firstKey());
        }
    };

    public TreeMap<Long,Ticket> getPersonsA(){
        return groupsA;
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    /**
     * Возвращает размер коллекции
     */
    public int getSize() {
        return groupsA.size();
    }

    Manager people;
    /**
     * Загружает коллекцию из файла
     */
    public void loadFromFile(String filename) throws JAXBException {
        try {
            File file = new File(filename);
            JAXBContext context = JAXBContext.newInstance(Manager.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            people = (Manager) unmarshaller.unmarshal(file);
        } catch (UnmarshalException e){
            System.out.println("Invalid file");
            System.exit(0);
        }finally {
            CorrectDataReader("Data.xml");
        }
    }

    public long GetMaxKey() throws NoSuchElementException{
        try {
            biggestId = groupsA.lastKey();
        } catch (NoSuchElementException e){
            biggestId =1;
        }
        return biggestId;
    }

    public void CorrectDataReader(String filename){
        for(Map.Entry<Long,Ticket> entry : groupsA.entrySet()){
            if((entry.getValue().getName() == null) || (entry.getValue().getName() == "")){
                System.out.println("Invalid values in file");
                System.exit(0);
            }
        }
        for(Map.Entry<Long,Ticket> entry : groupsA.entrySet()) {

        }
    }
    /**
     * Добавляет объект в коллекцию
     */
    public void add(Ticket element) {
        groupsA.put(element.getId(),element);
    }

    /**
     * Сохраняет коллекцию в xml файл
     */
    public void save(){
        StringWriter sw = new StringWriter();
        try {
            Manager people = new Manager();
            JAXBContext context = JAXBContext.newInstance(Manager.class);
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(people, new File("Data.xml"));

            jaxbMarshaller.marshal(people, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * удаляет объект из коллекции по его id
     */
    public void remove(long key) {
        groupsA.remove(key);
    }

    /**
     * получает группу по её id
     */
    public Ticket get(long id) {
        return groupsA.get(id);
    }

    /**
     * находит все группы, чьё название начинается с заданной подстроки
     */
    public String subStringSearcher(String subString){
        StringBuilder box = new StringBuilder();
        for(Map.Entry<Long,Ticket> entry : groupsA.entrySet()) {
            if (entry.getValue().getName().startsWith(subString)){
                box.append(entry.getValue().toString()).append("\n");
            }
        }
        return box.toString();
    }

    /**
     * выводит элементы значения поля ticketEnum которых равно заданному
     */
    public void FilterTicket(String s){
        for(Map.Entry<Long,Ticket> entry : groupsA.entrySet()) {
            if (entry.getValue().getEvent().toString().equals(s)){
                System.out.println(entry);
            }
        }
    }

}
