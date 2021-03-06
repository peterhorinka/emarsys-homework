package com.codecool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TestCalculateDueDate {

    private IssueTracking issue = new IssueTracking();

    /**
     * In the tests I refer to CalculateDueDate method as CDD
     **/

    @Test
    void givenTurnAroundTimeIs16CDDShouldReturn2WorkdaysLater() {
        Date submitDate = new Date(Day.MONDAY, 10, 10);
        int turnAroundTime = 16;
        String actualResult = issue.calculateDueDate(submitDate, turnAroundTime);
        String expectedResult = "Due date is: WEDNESDAY 10:10";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void GivenTurnAroundTimeIs30CDDShouldCycle3DaysAndAddRemainingHoursToDueDate() {
        Date submitDate = new Date(Day.TUESDAY, 9);
        int turnAroundTime = 30;
        String actualResult = issue.calculateDueDate(submitDate, turnAroundTime);
        String expectedResult = "Due date is: FRIDAY 15:00";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void GivenItsFridayPMDueDateShouldBeNextWeek() {
        Date submitDate = new Date(Day.FRIDAY, 16, 33);
        int turnAroundTime = 9;
        String actualResult = issue.calculateDueDate(submitDate, turnAroundTime);
        String expectedResult = "Due date is: TUESDAY 9:33";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void CDDShouldReturnIllegalArguementMessageWhenArguementsAreInvalid(){
        Date submitDate = new Date(Day.MONDAY, 25, 61);
        int turnAroundTime = 8;
        assertThrows(IllegalArgumentException.class, () -> {
            issue.calculateDueDate(submitDate,turnAroundTime);
        });
    }
}
