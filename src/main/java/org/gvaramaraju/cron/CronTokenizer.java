package org.gvaramaraju.cron;

import java.util.List;

public interface CronTokenizer {
    List<String> tokenize(String cronField);
}