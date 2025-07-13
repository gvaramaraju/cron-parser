package org.gvaramaraju.cron;

import java.util.ArrayList;
import java.util.List;

import static org.gvaramaraju.cron.Constants.*;

public class CronIntegerFieldParser extends CronFieldParser{
    private final int min;
    private final int max;

    public CronIntegerFieldParser(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Integer> parseField(String cronField) {
        if(cronField.equals(ALL)){
            return elements(min, max, 1);
        } else if (cronField.contains(Constants.COMMA)) {
            List<Integer> minutes = new ArrayList<>();
            String[] split = cronField.split(COMMA);
            for(String minute: split){
                minutes.add(validateAndGetMinute(minute));
            }
            return minutes;
        }else if(cronField.contains(SLASH)){
            String[] split = cronField.split(SLASH);
            if(split.length != 2) throw new CronParserException("Invalid cron");
            String prefix = split[0];
            String suffix = split[1];
            if(prefix.equals(ALL)){
                return elements(min, max, validateAndGetStep(suffix));
            }else if(prefix.contains(HYPHEN)){
                String[] split1 = prefix.split(HYPHEN);
                int start = validateAndGetMinute(split1[0]);
                int end = validateAndGetMinute(split1[1]);
                return elements(start, end, validateAndGetStep(suffix));
            }else{
                int start = validateAndGetMinute(prefix);
                return elements(start, max, validateAndGetStep(suffix));
            }
        }else if(cronField.contains(HYPHEN)){
            String[] split1 = cronField.split(HYPHEN);
            int start = validateAndGetMinute(split1[0]);
            int end = validateAndGetMinute(split1[1]);
            if(start > end) throw new CronParserException("Invalid cron expression");
            return elements(start, end, 1);
        }else {
                int minute = validateAndGetMinute(cronField);
                return List.of(minute);
        }
    }

    private Integer validateAndGetMinute(String minute) {
        try{
            int parsedMinute = Integer.parseInt(minute);
            if(parsedMinute >= min && parsedMinute <= max){
                return parsedMinute;
            }else{
                throw new CronParserException("Cron is not valid");
            }
        }catch (NumberFormatException e){
            System.out.println("e = " + e);
            throw new CronParserException("Cron is not valid", e);
        }
    }

    private Integer validateAndGetStep(String step) {
        try{
            return Integer.parseInt(step);
        }catch (NumberFormatException e){
            System.out.println("e = " + e);
            throw new CronParserException("Cron is not valid", e);
        }
    }
}
