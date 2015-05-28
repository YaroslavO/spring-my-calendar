package com.yaroslav.other.calendar.config;

import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.view.month.ConsoleMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.HTMLMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;
import com.yaroslav.other.calendar.view.year.CalendarRenderer;
import com.yaroslav.other.calendar.view.year.HTMLYearCalendarRendererToFile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yaroslav on 28.05.2015.
 */

@Configuration
public class AppConfiguration {

    @Bean(name = "monthCalendarRenderer")
    @Qualifier(value = "main")
    public MonthCalendarRenderer getMonthCalendar() {
        return new HTMLMonthCalendarRenderer();
    }

    @Bean(name = "monthCalendarRenderer")
    @Qualifier(value = "other")
    public MonthCalendarRenderer getOtherMonthCalendar() {
        return new ConsoleMonthCalendarRenderer();
    }

    @Bean(name = "calendarRenderer")
    public CalendarRenderer getCalendarRenderer() {
        return new HTMLYearCalendarRendererToFile();
    }

}
