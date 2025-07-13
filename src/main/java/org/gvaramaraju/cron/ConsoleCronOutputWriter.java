package org.gvaramaraju.cron;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleCronOutputWriter implements CronOutputWriter {
    @Override
    public void writeCronParserOutput(ParsedCron parsedCron) {
        Map<String, List<Integer>> mpp = parsedCron.getMpp();
        for (Map.Entry<String, List<Integer>> entry : mpp.entrySet()) {
            System.out.printf("%-14s %s%n", entry.getKey(),
                    entry.getValue().stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        System.out.printf("%-14s %s%n", "command",
                parsedCron.getCommand());
    }
}
