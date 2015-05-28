package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.config.AppConfiguration;
import com.yaroslav.other.calendar.file.SourceLoader;
import com.yaroslav.other.calendar.view.month.ConsoleAbstractCalendarMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.HTMLMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;
import com.yaroslav.other.calendar.view.year.CalendarRenderer;
import com.yaroslav.other.calendar.view.year.HTMLYearCalendarRendererToFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {
    private static final String FILE_NAME = "calendar.txt";

    public static void main(String[] args) {

        SourceLoader sourceLoader = new SourceLoader();
        String source = "2015 jul";

        try {
            source = sourceLoader.loadSource(FILE_NAME);
        }  catch (FileNotFoundException e) {
            System.out.println("file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        CustomerCalendar calendar = new CustomerCalendar(source);
        calendar.init();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        CalendarRenderer calendarRenderer = (CalendarRenderer) context.getBean("calendarRenderer");
        calendarRenderer.renderer(calendar);
    }
}
