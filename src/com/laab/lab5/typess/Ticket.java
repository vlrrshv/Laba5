package com.laab.lab5.typess;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
    public class Ticket {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private transient LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer price; //Поле не может быть null, Значение поля должно быть больше 0
    private TicketType type; //Поле может быть null
    private EventType event; //Поле может быть null


    public Ticket(long id, String name, Coordinates coordinates, LocalDate creationDate,Integer price, TicketType type, EventType event) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.event = event;
    }
    public Ticket() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return LocalDate.now();
    }

    public Integer getPrice() {
        return price;
    }

    public TicketType getType() {return type;}

    public EventType getEvent() {return event;}

    public Coordinates getCoordinates() {
        return coordinates;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", coordinates=" + getCoordinates() +
                ", creationDate=" + getCreationDate() +
                ", price=" + getPrice() +
                ", ticket type=" + getType() +
                ", event type=" + getEvent() +
                '}' + '\n';
    }

}

