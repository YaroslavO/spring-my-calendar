package com.yaroslav.other.calendar;

import com.yaroslav.helper.CalendarHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by employee on 6/4/15.
 */
@RunWith(JUnit4.class)
public class InputReaderTest {
    private Calendar calendar;
    private InputReader reader;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 2);
        calendar = CalendarHelper.setMinuteSecondsMilisecondsINZero(calendar);

        reader = new InputReader();
    }

    @Test
    public void checkNumberMonth__returnsNumberMonth__forCalendar() throws Exception {
        String nameMonth = "jun";
        int numberMonthWithMethod = reader.getMonth(nameMonth);
        int numberMonth = Calendar.JUNE;

        assertThat("check return number month", numberMonth, is(numberMonthWithMethod));
    }

    @Test
    public void checkDate__returnsCalendar__forInputReader() throws Exception {
        String stringDate = "2015 06 02";
        Calendar calendarWithString = reader.getDateWithString(stringDate);
        calendarWithString = CalendarHelper.setMinuteSecondsMilisecondsINZero(calendarWithString);

        assertThat("check date with convert string to calendar", calendar, is(calendarWithString));
    }
}