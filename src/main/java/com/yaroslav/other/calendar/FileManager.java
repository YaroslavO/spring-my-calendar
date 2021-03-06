package com.yaroslav.other.calendar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yaroslav on 21.05.2015.
 */
public class FileManager {


    public final static String MAIN_DIRECTORY = "calendar";
    public static final String EXTENSION = ".html";

    public void saveToFile(String fileName, String content) {
        if (fileName.contains(File.separator)) {
            String[] partPath = fileName.split(File.separator);
            createDirIfNotExist(partPath[0]);
            createDirIfNotExist(partPath[0] + File.separator + partPath[1]);
        }

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

    public void createDirIfNotExist(String pathToDir) {
        File dir = new File(pathToDir);
        if (!dir.exists()) {
            try {
                Files.createDirectories(dir.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAllowedDirectory(String name) {
        File dir = new File(name);
        return dir.exists();
    }

    public boolean isAllowedFile(String pathToSource) {
        File readFile = new File(pathToSource);
        return readFile.isFile() && readFile.canRead() && readFile.exists();
    }

    public List<String> load(String pathToSource) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(pathToSource),
                StandardCharsets.UTF_8);
        return reader
                .lines()
                .map(line -> {
                    return line;
                })
                .collect(Collectors.toList());
    }

    public List<String> loadSource(String pathToSource) throws IOException {
        if (isAllowedFile(pathToSource)) {
            return load(pathToSource);
        }

        throw new IOException("Bad path to file " + pathToSource);
    }

    public Path getPathToFileOrDirectory(String nameFile) {
        FileSystem fs = FileSystems.getDefault();
        Path path1 = fs.getPath(nameFile);
        String absolutePath = path1.toAbsolutePath().toString();
        return Paths.get(absolutePath);
    }

    public void deleteDirectories() {
        Path directoryToDelete = getPathToFileOrDirectory(MAIN_DIRECTORY);
        File dir = new File(directoryToDelete.toString());
        if (dir.exists()) {
            try {
                deleteAllDirectoryAndFile(directoryToDelete);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteDirectories(String nameDirectory) {
        Path directoryToDelete = getPathToFileOrDirectory(nameDirectory);
        File dir = new File(directoryToDelete.toString());
        if (dir.exists()) {
            try {
                deleteAllDirectoryAndFile(directoryToDelete);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteAllDirectoryAndFile(Path directoryToDelete) throws IOException {
        Files.walkFileTree(directoryToDelete, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

        });
    }


    public String getPathFileByDate(Calendar date) {
        return MAIN_DIRECTORY + File.separator +
                date.get(Calendar.YEAR) + File.separator +
                (date.get(Calendar.MONTH) + 1) + EXTENSION;
    }
}
