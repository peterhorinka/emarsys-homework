package com.codecool;

public class IssueTracking {

    final int WORKHOURS = 8;
    final int WORKSTART = 9;
    final int WORKEND = 17;

    public String calculateDueDate(Date submitDate, int turnAroundTime) {
        if (submitDate.hour > 23 || submitDate.minute > 59){
            throw new IllegalArgumentException("");
        }
        if (turnAroundTime % WORKHOURS == 0) {
            turnAroundTimeIsExactlyOneOrMoreWorkday(submitDate, turnAroundTime);
        } else {
            turnAroundTimeModuloWorkhoursIsNotZero(submitDate, turnAroundTime);
        }
        return submitDate.toString();
    }

    private void turnAroundTimeIsExactlyOneOrMoreWorkday(Date submitDate, int turnAroundTime){
        for (int i = 0; i < turnAroundTime / WORKHOURS; i++)
            submitDate.day = submitDate.day.next();
    }

    private void turnAroundTimeModuloWorkhoursIsNotZero(Date submitDate, int turnAroundTime){
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
}
