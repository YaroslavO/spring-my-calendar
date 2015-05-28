package com.yaroslav.other.calendar;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by Yaroslav on 21.05.2015.
 */
public class FileManager {

    public void saveToFile(String fileName, String content) {
        String[] partPath = fileName.split(File.separator + File.separator);
        createDirIfNotExist(partPath[0]);
        createDirIfNotExist(partPath[0] + File.separator + partPath[1]);

        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"))) {
                writer.write(content);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirIfNotExist(String pathToDir) {
        File dir = new File(pathToDir);
        if (!dir.exists()) {
            try {
                Files.createDirectories(dir.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
