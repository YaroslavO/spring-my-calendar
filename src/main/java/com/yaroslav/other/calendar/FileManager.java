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
    public static final String NAME_FILE = "my-app.iml";

    public void saveToFile(String fileName, String content) {
        String[] partPath = fileName.split(File.separator);
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

    public boolean isAllowed(String pathToSource) {
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
        if (isAllowed(pathToSource)) {
            return load(pathToSource);
        }

        throw new IOException("Bad path to file " + pathToSource);
    }

    public Path getPathToFile(String nameFile) {
        FileSystem fs = FileSystems.getDefault();
        Path path1 = fs.getPath(nameFile);
        String absolutePath = path1.toAbsolutePath().toString();
        return Paths.get(absolutePath);
    }

    public void deleteDirectories() {
        Path directoryToDelete = getPathToFile(MAIN_DIRECTORY);
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String getPathFileByDate(Calendar date) {
        return MAIN_DIRECTORY + File.separator +
                date.get(Calendar.YEAR) + File.separator +
                (date.get(Calendar.MONTH) + 1) + EXTENSION;
    }

    public String getPathToCreateDirectory() {
        FileManager fileManager = new FileManager();

        String filePath = fileManager.getPathToFile(NAME_FILE).toString();
        filePath = filePath.substring(0, filePath.lastIndexOf(File.separator));

        return filePath + File.separator;
    }
}
