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

    Date(Day day, int hour) {
        this.day = day;
        this.hour = hour;
        this.minute = 0;
    }

    @Override
    public String toString() {
        if (minute <= 9) {
            return "Due date is: " + day + " " + hour + ":0" + minute;
        } else {
            return "Due date is: " + day + " " + hour + ":" + minute;
        }
    }
}
