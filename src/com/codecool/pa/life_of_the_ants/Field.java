package com.codecool.pa.life_of_the_ants;


import java.util.ArrayList;

public abstract class Field {
    private Type cast;
    int[] place;
    int stunCounter;

    Field(Type cast, int[] place) {
        this.cast = cast;
        this.place = place;
    }

    public void say(String text) {
        System.out.println(text);
    }

    public Type getType() {
        return cast;
    }

    public int[] getPlace() {
        return place;
    }

    public void setStunCounter(int stunCounter) {
        this.stunCounter = stunCounter;
    }

    public int checkStunCounter() {
        if (stunCounter > 0) {
            stunCounter--;
        }
        return stunCounter;
    }

    public void move(int[] place) {
        this.place = place;
    }

    public int distanceFromQueen() {
        return place[0] + place[1];
    }

    enum Type {
        Worker,
        Soldier,
        Drone,
        Queen,
    }



    abstract int[] stepOne();

  }
