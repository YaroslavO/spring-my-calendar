package com.yaroslav.other.calendar.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 5/25/15.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<SourceProvider>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
    }

    public String loadSource(String pathToSource) throws IOException {
        for (SourceProvider provider : sourceProviders) {
            if (provider.isAllowed(pathToSource)) {
                return provider.load(pathToSource);
            }
        }

        throw new IOException("Bad path to file " + pathToSource);
    }
}
