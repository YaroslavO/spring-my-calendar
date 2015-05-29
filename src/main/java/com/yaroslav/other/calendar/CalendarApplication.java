package com.yaroslav.other.calendar;

import com.yaroslav.other.calendar.config.AppConfiguration;
import com.yaroslav.other.calendar.writer.year.CalendarRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by employee on 5/20/15.
 */
public class CalendarApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        CalendarRenderer calendarRenderer = (CalendarRenderer) context.getBean("HTMLYearCalendarRendererToFile");
        calendarRenderer.render();
    }
}
