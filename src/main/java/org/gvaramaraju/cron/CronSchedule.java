package org.gvaramaraju.cron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CronSchedule {

    private final List<Integer> minutes;
    private final List<Integer> hours;
    private final List<Integer> dayOfMonth;
    private final List<Integer> month;
    private final List<Integer> dayOfWeek;
    private final String command;

    public CronSchedule(List<Integer> minutes, List<Integer> hours, List<Integer> dayOfMonth, List<Integer> month, List<Integer> dayOfWeek, String command) {
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.command = command;
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
