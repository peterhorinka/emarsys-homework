package com.codecool;

public enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;



    private static Day[] vals = values();

    public Day next(){
        return vals[(this.ordinal()+1) % vals.length];
    }
}
