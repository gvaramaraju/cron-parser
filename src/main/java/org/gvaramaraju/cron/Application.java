package org.gvaramaraju.cron;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        if(args.length != 1){
            throw new RuntimeException("Please enter cron expression as arg");
        }
        String inputArg = args[0];
        System.out.println("Input Args = " + inputArg);
        // Splitting input cron expression
        SimpleCronTokenizer simpleCronTokenizer = new SimpleCronTokenizer();
        List<String> cronFields = simpleCronTokenizer.tokenize(inputArg);
        // Creating parser with default parsers
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        CronExpression cronExpression = new CronExpression.Builder().
                minutes(cronFields.get(0))
                .hours(cronFields.get(1))
                .dayOfMonth(cronFields.get(2))
                .month(cronFields.get(3))
                .dayOfWeek(cronFields.get(4))
                .command(cronFields.get(5))
                .build();
        CronSchedule cronSchedule = cronParser.parseCron(cronExpression);
        // Writing to console
        CronOutputWriter writer = new ConsoleTableOutputWriter();
        writer.writeCronParserOutput(cronSchedule);
    }
}
