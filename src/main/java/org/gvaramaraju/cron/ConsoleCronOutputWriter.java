package org.gvaramaraju.cron;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleCronOutputWriter implements CronOutputWriter {
    @Override
    public void writeCronParserOutput(CronSchedule cronSchedule) {
        Map<String, List<Integer>> mpp = cronSchedule.getMpp();
        for (Map.Entry<String, List<Integer>> entry : mpp.entrySet()) {
            System.out.printf("%-14s %s%n", entry.getKey(),
                    entry.getValue().stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        System.out.printf("%-14s %s%n", "command",
                cronSchedule.getCommand());
    }
}
