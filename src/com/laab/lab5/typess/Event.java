package com.laab.lab5.typess;

public class Event {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer capacity; //Поле может быть null, Значение поля должно быть больше 0
    private EventType event; //Поле может быть null



    public Event(String name, Integer capacity,EventType type) {
        this.name = name;
        this.capacity = capacity;
        this.event = event;
    }
    public String getName() {
        return name;
    }
    public Integer getCapacity() {return capacity;}
    public EventType getType() {return event;}
}