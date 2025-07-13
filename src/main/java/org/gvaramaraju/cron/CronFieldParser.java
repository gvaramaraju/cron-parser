package org.gvaramaraju.cron;

import java.util.ArrayList;
import java.util.List;

public abstract class CronFieldParser {
    abstract List<Integer> parseField(String cronField);

    protected List<Integer> elements(int start, int end, int step){
        List<Integer> elements = new ArrayList<>();
        int i = start;
        while(i <= end){
            elements.add(i);
            i+=step;
        }
        return elements;
    }
}
