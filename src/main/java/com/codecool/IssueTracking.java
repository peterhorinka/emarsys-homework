package com.codecool;

public class IssueTracking {


    public String calculateDueDate(Date submitDate, int turnAroundTime) {
        if (submitDate.hour > 23 || submitDate.minute > 59){
            throw new IllegalArgumentException();
        }

        final int WORKHOURS = 8;
        final int WORKSTART = 9;
        final int WORKEND = 17;

        if (turnAroundTime % WORKHOURS == 0) {
            for (int i = 0; i < turnAroundTime / WORKHOURS; i++)
                submitDate.day = submitDate.day.next();
        } else {
            for (int i = 0; i < turnAroundTime / WORKHOURS; i++) {
                submitDate.day = submitDate.day.next();
            }


            submitDate.hour += turnAroundTime % WORKHOURS;
            if (submitDate.hour >= WORKEND) {
                int remainingTime = submitDate.hour - WORKEND;
                submitDate.day = submitDate.day.next();
                submitDate.hour = WORKSTART + remainingTime;
            }
        }

        return submitDate.toString();
    }
}
