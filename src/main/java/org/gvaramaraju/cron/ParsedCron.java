package org.gvaramaraju.cron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsedCron {
    public static final String MINUTE = "minute";
    public static final String HOUR = "hour";
    public static final String DAY_OF_MONTH = "day of month";
    public static final String MONTH = "month";
    public static final String DAY_OF_WEEK = "day of week";
    private final List<Integer> minutes;
    private final List<Integer> hours;
    private final List<Integer> dayOfMonth;
    private final List<Integer> month;
    private final List<Integer> dayOfWeek;
    private final String command;
    private Map<String, List<Integer>> mpp;

    public ParsedCron(List<Integer> minutes, List<Integer> hours, List<Integer> dayOfMonth, List<Integer> month, List<Integer> dayOfWeek, String command) {
        this.mpp = new HashMap<>();
        this.minutes = minutes;
        mpp.put(MINUTE, minutes);
        this.hours = hours;
        mpp.put(HOUR, hours);
        this.dayOfMonth = dayOfMonth;
        mpp.put(DAY_OF_MONTH, dayOfMonth);
        this.month = month;
        mpp.put(MONTH, month);
        this.dayOfWeek = dayOfWeek;
        mpp.put(DAY_OF_WEEK, dayOfWeek);
        this.command = command;
    }

    public Map<String, List<Integer>> getMpp() {
        return mpp;
    }

    public String getCommand() {
        return command;
    }


    public List<Integer> getMinutes() {
        return minutes;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public List<Integer> getDayOfMonth() {
        return dayOfMonth;
    }

    public List<Integer> getMonth() {
        return month;
    }

    public List<Integer> getDayOfWeek() {
        return dayOfWeek;
    }


}
