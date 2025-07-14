package org.gvaramaraju.cron;

import java.util.stream.Collectors;

public class ConsoleTableOutputWriter implements CronOutputWriter {
    public static final String MINUTE = "minute";
    public static final String HOUR = "hour";
    public static final String DAY_OF_MONTH = "day of month";
    public static final String MONTH = "month";
    public static final String DAY_OF_WEEK = "day of week";
    @Override
    public void writeCronParserOutput(CronSchedule cronSchedule) {
        String minutes = cronSchedule.getMinutes().stream().map(String::valueOf).collect(Collectors.joining(" "));
        writeTableFormattedLine(MINUTE, minutes);
        String hours = cronSchedule.getHours().stream().map(String::valueOf).collect(Collectors.joining(" "));
        writeTableFormattedLine(HOUR, hours);
        String dayOfMonth = cronSchedule.getDayOfMonth().stream().map(String::valueOf).collect(Collectors.joining(" "));
        writeTableFormattedLine(DAY_OF_MONTH, dayOfMonth);
        String month = cronSchedule.getMonth().stream().map(String::valueOf).collect(Collectors.joining(" "));
        writeTableFormattedLine(MONTH, month);
        String dayOfWeek = cronSchedule.getDayOfWeek().stream().map(String::valueOf).collect(Collectors.joining(" "));
        writeTableFormattedLine(DAY_OF_WEEK, dayOfWeek);
        System.out.printf("%-14s %s%n", "command",
                cronSchedule.getCommand());
    }

    private void writeTableFormattedLine(String key, String value){
        System.out.printf("%-14s %s%n", key, value);
    }
}
