package com.codecool;

public class Main {



    public static void main(String[] args) {
        Date oneDate = new Date(Day.MONDAY, 10, 10);
        Date twoDate = new Date(Day.FRIDAY, 10, 10);
        Date threeDate = new Date(Day.WEDNESDAY, 10, 10);
        System.out.println(IssueTracking.CalculateDueDate(oneDate, 16));
        System.out.println(IssueTracking.CalculateDueDate(twoDate, 16));
        System.out.println(IssueTracking.CalculateDueDate(threeDate, 16));
    }
}
