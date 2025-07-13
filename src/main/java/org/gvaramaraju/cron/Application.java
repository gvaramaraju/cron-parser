package org.gvaramaraju.cron;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        if(args.length != 1){
            throw new RuntimeException("Input proper args");
        }
        String inputArg = args[0];
        System.out.println("Input Args = " + inputArg);
        SimpleCronTokenizer simpleCronTokenizer = new SimpleCronTokenizer();
        List<String> cronFields = simpleCronTokenizer.tokenize(inputArg);
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
        CronOutputWriter writer = new ConsoleCronOutputWriter();
        writer.writeCronParserOutput(cronSchedule);
    }
}
