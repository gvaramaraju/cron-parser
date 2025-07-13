package org.gvaramaraju.cron;

public class DefaultCronParserFactory extends CronParserFactory {
    public CronFieldParser createMinutesParser(){
        return new CronIntegerFieldParser(0,59);
    }
    public CronFieldParser createHourParser(){
        return new CronIntegerFieldParser(0,23);
    }
    public CronFieldParser createDayOfMonthParser(){
        return new CronIntegerFieldParser(1,31);
    }
    public CronFieldParser createMonthParser(){
        return new CronIntegerFieldParser(1,12);
    }
    public CronFieldParser createDayOfWeekParser(){
        return new CronIntegerFieldParser(0,6);
    }

}
