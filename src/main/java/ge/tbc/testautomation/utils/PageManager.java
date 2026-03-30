package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Page;

public class PageManager {
    private static final ThreadLocal<Page> PAGE = new ThreadLocal<>();

    public static void setPage(Page page) {
        PAGE.set(page);
    }

    public static Page getPage() {
        return PAGE.get();
    }

    public static void clear() {
        PAGE.remove();
    }
}