package com.yaroslav.other.calendar.view.year;

import java.util.List;

/**
 * Created by employee on 5/26/15.
 */
public class NavigatorLink {
    private String current = "";
    private String next = "";
    private String previous = "";


    public NavigatorLink(List<String> links, int numberLink) {
        if (isFirstMonth(numberLink)) {
            next = links.get(numberLink + 1);
            current = links.get(numberLink);
            previous = links.get(links.size() - 1);
        }

        if (isLinkInMidYear(links, numberLink)) {
            previous = links.get(numberLink - 1);
            current = links.get(numberLink);
            next = links.get(numberLink + 1);
        }

        if (isLastMonth(links, numberLink)) {
            previous = links.get(numberLink - 1);
            current = links.get(numberLink);
            next = links.get(0);
        }

    }

    public String getCurrentFilePath() {
        return current;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    private boolean isLinkInMidYear(List<String> links, int numberLink) {
        return (numberLink < links.size() - 1) && (numberLink != 0);
    }

    private boolean isLastMonth(List<String> links, int numberLink) {
        return numberLink == links.size() - 1;
    }

    private boolean isFirstMonth(int numberLink) {
        return numberLink == 0;
    }
}
