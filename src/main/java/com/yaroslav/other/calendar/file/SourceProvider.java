package com.yaroslav.other.calendar.file;

import java.io.IOException;

/**
 * Created by employee on 5/25/15.
 */
public interface SourceProvider {
    /**
     * Determines can current implementation load source by provided pathToSource
     *
     * @param pathToSource absolute path to the source
     * @return whether current implementation load the source for specified pathToSource
     */
    public boolean isAllowed(String pathToSource);

    /**
     * Loads text from specified path.
     *
     * @param pathToSource absolute path to the source
     * @return content of the source for specified pathToSource
     */
    public String load(String pathToSource) throws IOException;
}
