package com.yaroslav.other.calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by employee on 6/3/15.
 */
@RunWith(JUnit4.class)
public class WeekTest {

    private Calendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 2);
    }

    @Test
    public void isCreatenextWeek__returnsTrue__forCurrentMonth() throws Exception {
        Week currentWeek = new Week(calendar);

        Week nextWeek = currentWeek.createNextWeek();

        assertThat("has next week", currentWeek, not(equalTo(nextWeek)));
    }
}