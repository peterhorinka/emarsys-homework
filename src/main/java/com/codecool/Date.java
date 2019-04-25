package com.codecool;

public class Date {
    Day day;
    int hour;
    int minute;

    Date(Day day, int hour, int minute) {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }


    @Override
    public String toString() {
        return "Due date is: " + day + " " + hour + ":" + minute;
    }
}
