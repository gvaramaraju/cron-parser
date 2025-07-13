
package org.gvaramaraju.cron;

import java.util.Arrays;
import java.util.List;

public class SimpleCronTokenizer implements CronTokenizer {
    public List<String> tokenize(String field) {
        return Arrays.asList(field.split(","));
    }
}