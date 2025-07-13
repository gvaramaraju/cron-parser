package org.gvaramaraju.cron;

import java.util.List;

public class CronParser {
    private final CronFieldParser minuteFieldParser;
    private final CronFieldParser hourFieldParser;
    private final CronFieldParser dayOfMonthFieldParser;
    private final CronFieldParser monthFieldParser;
    private final CronFieldParser dayOfWeekFieldParser;

    public CronParser(CronParserFactory cronParserFactory) {
        this.minuteFieldParser = cronParserFactory.createMinutesParser();
        this.hourFieldParser = cronParserFactory.createHourParser();
        this.dayOfMonthFieldParser = cronParserFactory.createDayOfMonthParser();
        this.monthFieldParser = cronParserFactory.createMonthParser();
        this.dayOfWeekFieldParser = cronParserFactory.createDayOfWeekParser();
    }

    public ParsedCron parseCron(CronExpression cronExpression){
        List<Integer> minutes = minuteFieldParser.parseField(cronExpression.getMinutes());
        List<Integer> hours = hourFieldParser.parseField(cronExpression.getHours());
        List<Integer> daysOfMonth = dayOfMonthFieldParser.parseField(cronExpression.getDayOfMonth());
        List<Integer> months = monthFieldParser.parseField(cronExpression.getMonth());
        List<Integer> daysOfWeek = dayOfWeekFieldParser.parseField(cronExpression.getDayOfWeek());
        String command = cronExpression.getCommand();
        if(command == null || command.isBlank()) throw new CronParserException("Invalid command in cron");
        return new ParsedCron(minutes, hours, daysOfMonth, months, daysOfWeek, command);
    }
}
