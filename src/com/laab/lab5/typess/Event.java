package com.laab.lab5.typess;


public class Event {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer minAge; //Поле может быть null, Значение поля должно быть больше 0
    private EventType event; //Поле может быть null



    public Event(String name, Integer minAge,EventType type) {
        this.name = name;
        this.minAge = minAge;
        this.event = event;
    }
    public String getName() {
        return name;
    }
    public Integer getMinAge() {return minAge;}
    public EventType getType() {return event;}
}