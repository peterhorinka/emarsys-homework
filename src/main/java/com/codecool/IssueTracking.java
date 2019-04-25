package com.codecool;

public class IssueTracking {


    public static String CalculateDueDate(Date submitDate, int turnAroundTime) {

        final int WORKHOURS = 8;
        final int WORKSTART = 9;
        final int WORKEND = 17;

        if (turnAroundTime % WORKHOURS == 0) {
            for (int i = 0; i < turnAroundTime / WORKHOURS; i++)
                submitDate.day = submitDate.day.next();
        } else {
            for (int i = 0; i < turnAroundTime / WORKHOURS; i++) {
                submitDate.day = submitDate.day.next();
                submitDate.hour += turnAroundTime % WORKHOURS;
                if (submitDate.hour >= WORKEND) {
                    submitDate.day = submitDate.day.next();
                    submitDate.hour = WORKSTART;
                }
            }
        }

        return submitDate.toString();
    }
}
