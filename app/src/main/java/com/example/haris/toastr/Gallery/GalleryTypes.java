package com.example.haris.toastr.Gallery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Haris on 4/12/2016.
 */
public class GalleryTypes implements Serializable{
    public static class Section {
        public static final String HOT = "hot";
        public static final String TOP = "top";
        public static final String USER = "user";

        public static List<String> getSections() {
            return new ArrayList<>(Arrays.asList(HOT, TOP, USER));
        }
    }

    public static class Sort {
         public static final String TOP = "top";
        public static final String TIME = "time";
        public static final String RISING = "rising";

        public static List<String> getSorts() {
            return new ArrayList<>(Arrays.asList(TOP, TIME, RISING));
        }
    }

    public static class Window {
        public static final String DAY = "day";
        public static final String WEEK = "week";
        public static final String MONTH = "month";
        public static final String YEAR = "year";
        public static final String ALL = "all";

        public static List<String> getWindows() {
            return new ArrayList<>(Arrays.asList(DAY, WEEK, MONTH, YEAR, ALL));
        }
    }

    private String section;
    private String sort;
    private String window;
    private int page;
    private boolean showViral;

    public GalleryTypes() {
        section = Section.HOT;
        sort = Sort.RISING;
        window = Window.DAY;
        page = 0;
        showViral = true;
    }

     public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean showViral() {
        return showViral;
    }

    public void setShowViral(boolean showViral) {
        this.showViral = showViral;
    }
}