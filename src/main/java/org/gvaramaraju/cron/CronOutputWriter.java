package org.gvaramaraju.cron;

public interface CronOutputWriter {
    void writeCronParserOutput(ParsedCron parsedCron);
}
