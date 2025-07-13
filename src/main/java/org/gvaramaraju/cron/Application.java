package org.gvaramaraju.cron;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        if(args.length != 1){
            throw new RuntimeException("Input proper args");
        }
        String inputArg = args[0];
        System.out.println("Input Args = " + inputArg);
        String[] cronParts = inputArg.split(" ");
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        CronExpression cronExpression = new CronExpression.Builder().
                minutes(cronParts[0])
                .hours(cronParts[1])
                .dayOfMonth(cronParts[2])
                .month(cronParts[3])
                .dayOfWeek(cronParts[4])
                .command(cronParts[5])
                .build();
        ParsedCron parsedCron = cronParser.parseCron(cronExpression);
        CronOutputWriter writer = new ConsoleCronOutputWriter();
        writer.writeCronParserOutput(parsedCron);
    }
}
