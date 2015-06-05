package com.yaroslav.other.calendar;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by employee on 6/3/15.
 */
@RunWith(JUnit4.class)
public class MonthCalendarTest {

    public static final int DAY_IN_MILLISECONDS = 1000 * 60 * 60 * 24;
    private Calendar calendar;
    private MonthCalendar thisMonth;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 2);
        thisMonth = new MonthCalendar(calendar);
    }

    @Test
    public void checkCountWeekOfMonth__returnsTrue__fromCurrentMonth() throws Exception {
        int countWeek = thisMonth.getCountWeeks(calendar);

        assertThat("count week of current month", countWeek, is(5));
    }

    @Test
    public void fillsMonthWithWeeks() throws Exception {
//        when
        List<Week> weeks = thisMonth.getWeeks();
        Week [] arrayWeeks = {
                givenWeekInCurrentMonth(1),
                givenWeekInCurrentMonth(8),
                givenWeekInCurrentMonth(15),
                givenWeekInCurrentMonth(22),
                givenWeekInCurrentMonth(29)};
        List<Week> testWeeks = Arrays.asList(arrayWeeks);

//        then
        assertThat(weeks, equalTo(testWeeks));
    }

    private Week givenWeekInCurrentMonth(int i) {
        Calendar firstDayInCurrentWeek = getDayForMonth(i);
        Week week = new Week();
        List<WeekDay> days = new ArrayList<>();
        long currentDay = firstDayInCurrentWeek.getTime().getTime();
        long numberDayInWeekForCurrentDate = firstDayInCurrentWeek.get(Calendar.DAY_OF_WEEK) - 1;
        long dateMondayOfWeek = currentDay - numberDayInWeekForCurrentDate * DAY_IN_MILLISECONDS;

        firstDayInCurrentWeek.setTime(new Date(dateMondayOfWeek));
        for (long numberDayOfWeek = 1; numberDayOfWeek <= Calendar.DAY_OF_WEEK; numberDayOfWeek++) {
            Calendar newDate = Calendar.getInstance();
            newDate.setTime(firstDayInCurrentWeek.getTime());
            WeekDay dayOfWeek = new WeekDay(newDate, week);
            firstDayInCurrentWeek.setTime(new Date(numberDayOfWeek * DAY_IN_MILLISECONDS + dateMondayOfWeek));
            days.add(dayOfWeek);
        }

        week.setDays(days);
        return week;
    }

    private Calendar getDayForMonth(int i) {
        Calendar forCreateWeek = Calendar.getInstance();
        forCreateWeek.setTime(calendar.getTime());
        forCreateWeek.set(Calendar.DAY_OF_MONTH, i);
        return forCreateWeek;
    }

    @Test
    public void checkListWeek__returnsNotNull__fromCurrentMonth() throws Exception {
        assertThat("list weeks of current month", thisMonth.getWeeks(), not(equalTo(null)));

    }

    @Test
    public void checkDateIsCurrent() throws Exception {
        MonthCalendar monthCalendar = new MonthCalendar(calendar);

        Calendar dateInMonthCalendar = monthCalendar.getDate();

        assertThat(calendar, is(dateInMonthCalendar));

    }
}