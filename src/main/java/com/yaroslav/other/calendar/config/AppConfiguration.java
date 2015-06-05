package com.yaroslav.other.calendar.config;

import com.yaroslav.other.calendar.CustomCalendar;
import com.yaroslav.other.calendar.reader.ConsoleReaderImpl;
import com.yaroslav.other.calendar.reader.CustomReaderImpl;
import com.yaroslav.other.calendar.reader.FileReaderImpl;
import com.yaroslav.other.calendar.reader.Reader;
import com.yaroslav.other.calendar.writer.month.ConsoleMonthCalendarRenderer;
import com.yaroslav.other.calendar.writer.month.HTMLMonthCalendarRenderer;
import com.yaroslav.other.calendar.writer.month.MonthCalendarRenderer;
import com.yaroslav.other.calendar.writer.year.CalendarRenderer;
import com.yaroslav.other.calendar.writer.year.HTMLYearCalendarRendererToFile;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yaroslav on 28.05.2015.
 */

@Configuration
public class AppConfiguration {

    @Bean(name = "monthCalendarRenderer")
    @Qualifier(value = "html")
    public MonthCalendarRenderer getMonthCalendar() {
        return new HTMLMonthCalendarRenderer();
    }

    @Bean(name = "monthCalendarRenderer")
    @Qualifier(value = "text")
    public MonthCalendarRenderer getOtherMonthCalendar() {
        return new ConsoleMonthCalendarRenderer();
    }

    @Bean(name = "HTMLYearCalendarRendererToFile")
    public CalendarRenderer getCalendarRenderer() {
        return new HTMLYearCalendarRendererToFile();
    }

    @Bean(name = "customReader")
    @Qualifier(value = "customRead")
    public Reader getCustomReader() {
        return new CustomReaderImpl();
    }

    @Bean(name = "consoleReader")
    @Qualifier(value = "consoleRead")
    public Reader getConsoleReader() {
        return new ConsoleReaderImpl();
    }

    @Bean(name = "fileReader")
    @Qualifier(value = "fileRead")
    public Reader getFileReader() {
        return new FileReaderImpl();
    }

    @Bean(name = "customCalendar")
    public CustomCalendar getCustomCalendar(@Qualifier(value = "customRead") Reader reader) {
        return new CustomCalendar(reader);
    }
}
