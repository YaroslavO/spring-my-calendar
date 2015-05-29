package com.yaroslav.other.calendar.reader;

import com.yaroslav.other.calendar.FileManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 5/29/15.
 */
public class FileReaderImpl implements Reader {
    private static final String FILE_NAME = "calendar.txt";

    @Override
    public List<String> read() {
        FileManager fileManager = new FileManager();
        List<String> listYearAndMonth = new ArrayList<>();
        try {
            listYearAndMonth = fileManager.loadSource(FILE_NAME);
        }  catch (FileNotFoundException e) {
            System.out.println("file not found: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listYearAndMonth;
    }
}
