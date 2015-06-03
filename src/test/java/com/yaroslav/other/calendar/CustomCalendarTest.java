package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.reader.Reader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by employee on 6/3/15.
 */
@RunWith(JUnit4.class)
public class CustomCalendarTest {
    private CustomCalendar currentCalendar;

    private Reader reader = new Reader() {
        @Override
        public List<String> read() {
            List<String> result = new ArrayList<>();
            result.add("2014");
            result.add("2015");
            result.add("2016");
            return result;
        }
    };

    @Before
    public void setUp() throws Exception {
        currentCalendar = new CustomCalendar(reader);

    }

    @Test
    public void checkListYear__returnsNotNull__forCustomCalendar() throws Exception {
        List<YearCalendar> years = currentCalendar.getListYear();

        assertThat("list year of current calendar", years, not(equalTo(null)));
    }

    @Test
    public void checkCountYear__returnsTrue__forCustomCalendar() throws Exception {
        List<YearCalendar> years = currentCalendar.getListYear();
        int countYear = years.size();

        assertThat("list year of current calendar", countYear, is(3));
    }
}