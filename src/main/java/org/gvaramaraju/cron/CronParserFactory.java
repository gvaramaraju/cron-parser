package org.gvaramaraju.cron;

public abstract class CronParserFactory {
    abstract CronFieldParser createMinutesParser();
    abstract CronFieldParser createHourParser();
    abstract CronFieldParser createDayOfMonthParser();
    abstract CronFieldParser createMonthParser();
    abstract CronFieldParser createDayOfWeekParser();

}
