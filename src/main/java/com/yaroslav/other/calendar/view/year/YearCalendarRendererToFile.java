package com.yaroslav.other.calendar.view.year;

import com.yaroslav.other.calendar.CustomerCalendar;
import com.yaroslav.other.calendar.FileManager;
import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.YearCalendar;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2015.
 */

@Component
public abstract class YearCalendarRendererToFile implements CalendarRenderer  {
    public final static String MAIN_DIRECTORY = "calendar";
    public static final String EXTENSION = ".html";

    @Autowired
    @Qualifier(value = "main")
    MonthCalendarRenderer monthCalendarRenderer;

    @Override
    public void renderer(CustomerCalendar customerCalendar) {
        FileManager fileManager = new FileManager();
        List<YearCalendar> listYear = customerCalendar.getListYear();
        String filePath = getFilePath();
        String link = "";
        String linkNext = "";
        String linkPrevious = "";
        String result;

        for (YearCalendar yearCalendar: listYear) {
            for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
                link = "";
                result = "";
                link += MAIN_DIRECTORY + File.separator +
                        yearCalendar.getName() + File.separator +
                        monthCalendar.getDate().get(Calendar.MONTH) + EXTENSION;
                result += getHeaderMonthToken(yearCalendar.getName(),
                        getMonthName(monthCalendar.getDate().get(Calendar.MONTH)));
                result += getPreviousMonthToken(filePath + File.separator + linkPrevious);
                result += monthCalendarRenderer.render(monthCalendar);
                result += getNextMonthToken(filePath + File.separator + linkNext);
                fileManager.saveToFile(link, result);
                linkPrevious = link;
            }

        }
    }

    private String getMonthName(int numberMonth) {
        switch (numberMonth) {
            case 0: return "january";
            case 1: return "february";
            case 2: return "march";
            case 3: return "april";
            case 4: return "may";
            case 5: return "june";
            case 6: return "july";
            case 7: return "august";
            case 8: return "september";
            case 9: return "october";
            case 10: return "november";
            case 11: return "december";
        }
        return "january";
    }

    private String getFilePath() {
        FileSystem fs = FileSystems.getDefault();
        Path path1 = fs.getPath("my-app.iml");
        String absolutePath = path1.toAbsolutePath().toString();
        return absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
    }

    public abstract String getHeaderMonthToken(String year, String month);
    public abstract String getPreviousMonthToken(String link);
    public abstract String getNextMonthToken(String link);

}
