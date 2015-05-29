package com.yaroslav.other.calendar.view.year;

import com.yaroslav.other.calendar.CustomCalendar;
import com.yaroslav.other.calendar.FileManager;
import com.yaroslav.other.calendar.MonthCalendar;
import com.yaroslav.other.calendar.YearCalendar;
import com.yaroslav.other.calendar.view.month.HTMLMonthCalendarRenderer;
import com.yaroslav.other.calendar.view.month.MonthCalendarRenderer;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yaroslav on 25.05.2015.
 */
public abstract class AbstractYearCalendarRendererToFile implements CalendarRenderer  {

    public static final String TWO_DIR_BACK_PATH = ".." + File.separator + ".." + File.separator;
    private List<String> links;
    FileManager fileManager = new FileManager();
    int numberLink = 0;

    @Override
    public void render(CustomCalendar customCalendar) {
        fileManager.deleteDirectories();
        List<YearCalendar> listYear = customCalendar.getListYear();
        links = getListLink(listYear);
        this.numberLink = 0;

        for (YearCalendar yearCalendar: listYear) {
            saveMonthesToFiles(yearCalendar);
        }
    }

    private void saveMonthesToFiles(YearCalendar yearCalendar) {
        for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
            saveMonthToFile(monthCalendar);
        }
    }

    private void saveMonthToFile(MonthCalendar monthCalendar) {
        NavigatorLink navigator = new NavigatorLink(links, ++numberLink);

        String fileContent = composeMonthContent(navigator, monthCalendar);

        fileManager.saveToFile(navigator.getCurrentFilePath(), fileContent);
    }

    private String composeMonthContent(NavigatorLink navigator, MonthCalendar monthCalendar) {
        MonthCalendarRenderer monthCalendarRenderer = new HTMLMonthCalendarRenderer();

        String fileContent = "";
        fileContent += getHeaderMonthToken(monthCalendar.getDate());
        fileContent += getPreviousMonthToken(TWO_DIR_BACK_PATH + navigator.getPrevious());
        fileContent += monthCalendarRenderer.render(monthCalendar);
        fileContent += getNextMonthToken(TWO_DIR_BACK_PATH + navigator.getNext());

        return fileContent;
    }


    private List<String> getListLink(List<YearCalendar> listYear) {
        List<String> linkList = new ArrayList<>();
        for (YearCalendar yearCalendar: listYear) {
            for (MonthCalendar monthCalendar: yearCalendar.getMonths()) {
                linkList.add(fileManager.getPathFileByDate(monthCalendar.getDate()));
            }
        }

        return linkList;
    }

    public abstract String getHeaderMonthToken(Calendar date);
    public abstract String getPreviousMonthToken(String link);
    public abstract String getNextMonthToken(String link);

}
