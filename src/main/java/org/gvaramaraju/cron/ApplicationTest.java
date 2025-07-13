package org.gvaramaraju.cron;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ApplicationTest {
    public static void main(String[] args) {
        ApplicationTest test = new ApplicationTest();
        test.test1();
        test.test2();
        test.test3();
        test.test4();
        test.test5();
        test.test6();
        test.test7();
        test.test8();
        test.test9();

        test.negativeTest1();
        test.negativeTest2();
        test.negativeTest3();
        test.negativeTest4();
        test.negativeTest5();
        test.negativeTest6();
        test.negativeTest7();
        test.negativeTest8();
        test.negativeTest9();
        test.negativeTest10();

    }


    void test1(){
        // Case 1: All wildcards
        CronExpression cronExpression = new CronExpression.Builder()
                .minutes("*")
                .hours("*")
                .dayOfMonth("*")
                .month("*")
                .dayOfWeek("*")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cronExpression);
        List<Integer> minutes = IntStream.rangeClosed(0, 59).boxed().toList();
        List<Integer> hours = IntStream.rangeClosed(0, 23).boxed().toList();
        List<Integer> dayOfMonth = IntStream.rangeClosed(1, 31).boxed().toList();
        List<Integer> month = IntStream.rangeClosed(1, 12).boxed().toList();
        List<Integer> dayOfWeek = IntStream.rangeClosed(0, 6).boxed().toList();
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 1 FAILED");
        }else {
            System.out.println("Test 1 PASSED");
        }

    }

    void test2(){
        // Case 2: Every 15 mins, hour 0, on 1st and 15th day, any month, Monday–Friday
        CronExpression cron2 = new CronExpression.Builder()
                .minutes("*/15")
                .hours("0")
                .dayOfMonth("1,15")
                .month("*")
                .dayOfWeek("1-5")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron2);
        List<Integer> minutes = List.of(0,15, 30, 45);
        List<Integer> hours = List.of(0);
        List<Integer> dayOfMonth =  List.of(1, 15);
        List<Integer> month = IntStream.rangeClosed(1, 12).boxed().toList();
        List<Integer> dayOfWeek = IntStream.rangeClosed(1, 5).boxed().toList();
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 2 FAILED");
        }else {
            System.out.println("Test 2 PASSED");
        }
    }

    void test3(){
        // Case 3: Full numeric ranges
        CronExpression cron3 = new CronExpression.Builder()
                .minutes("0-59")
                .hours("0-23")
                .dayOfMonth("1-31")
                .month("1-12")
                .dayOfWeek("0-6")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron3);
        List<Integer> minutes = IntStream.rangeClosed(0, 59).boxed().toList();
        List<Integer> hours = IntStream.rangeClosed(0, 23).boxed().toList();
        List<Integer> dayOfMonth = IntStream.rangeClosed(1, 31).boxed().toList();
        List<Integer> month = IntStream.rangeClosed(1, 12).boxed().toList();
        List<Integer> dayOfWeek = IntStream.rangeClosed(0, 6).boxed().toList();
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 3 FAILED");
        }else {
            System.out.println("Test 3 PASSED");
        }
    }

    void test4(){
        // Case 4: Specific values (comma-separated)
        CronExpression cron4 = new CronExpression.Builder()
                .minutes("0,15,30,45")
                .hours("12")
                .dayOfMonth("10")
                .month("6")
                .dayOfWeek("3")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron4);
        List<Integer> minutes = List.of(0, 15, 30, 45);
        List<Integer> hours = List.of(12);
        List<Integer> dayOfMonth = List.of(10);
        List<Integer> month = List.of(6);
        List<Integer> dayOfWeek = List.of(3);
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 4 FAILED");
        }else {
            System.out.println("Test 4 PASSED");
        }
    }

    void test5(){
        // Case 5: Mixed ranges and lists with steps
        CronExpression cron5 = new CronExpression.Builder()
                .minutes("5")
                .hours("8-18/2")
                .dayOfMonth("1")
                .month("1,6,12")
                .dayOfWeek("0,2,4")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron5);
        List<Integer> minutes = List.of(5);
        List<Integer> hours = List.of(8, 10, 12, 14, 16, 18);
        List<Integer> dayOfMonth = List.of(1);
        List<Integer> month = List.of(1, 6, 12);
        List<Integer> dayOfWeek = List.of(0, 2, 4);
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 5 FAILED");
        }else {
            System.out.println("Test 5 PASSED");
        }
    }

    void test6(){
        // Case 6: Step value with range
        CronExpression cron6 = new CronExpression.Builder()
                .minutes("0/10")
                .hours("*")
                .dayOfMonth("5-25")
                .month("3-8")
                .dayOfWeek("1")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron6);
        List<Integer> minutes = List.of(0, 10, 20, 30, 40, 50);
        List<Integer> hours = IntStream.rangeClosed(0, 23).boxed().toList();
        List<Integer> dayOfMonth = IntStream.rangeClosed(5, 25).boxed().toList();
        List<Integer> month = IntStream.rangeClosed(3, 8).boxed().toList();
        List<Integer> dayOfWeek = List.of(1);
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 6 FAILED");
        }else {
            System.out.println("Test 6 PASSED");
        }
    }

    void test7(){
        // Case 7: Single values
        CronExpression cron7 = new CronExpression.Builder()
                .minutes("15")
                .hours("14")
                .dayOfMonth("28")
                .month("2")
                .dayOfWeek("0")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron7);
        List<Integer> minutes = List.of(15);
        List<Integer> hours = List.of(14);
        List<Integer> dayOfMonth = List.of(28);
        List<Integer> month = List.of(2);
        List<Integer> dayOfWeek = List.of(0);
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 7 FAILED");
        }else {
            System.out.println("Test 7 PASSED");
        }
    }

    void test8(){
        // Case 8: Step values on all fields
        CronExpression cron8 = new CronExpression.Builder()
                .minutes("*/5")
                .hours("*/3")
                .dayOfMonth("*/2")
                .month("*/2")
                .dayOfWeek("*/1")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron8);
        List<Integer> minutes = List.of(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);
        List<Integer> hours = List.of(0, 3, 6, 9, 12, 15, 18, 21);
        List<Integer> dayOfMonth = List.of(1, 3, 5, 7, 9 , 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31);
        List<Integer> month = List.of(1, 3, 5, 7, 9, 11);
        List<Integer> dayOfWeek = IntStream.rangeClosed(0, 6).boxed().toList();
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 8 FAILED");
        }else {
            System.out.println("Test 8 PASSED");
        }

    }

    void test9(){
        // Case 9: Fixed values
        CronExpression cron9 = new CronExpression.Builder()
                .minutes("30")
                .hours("4")
                .dayOfMonth("10")
                .month("12")
                .dayOfWeek("2")
                .command("ABC")
                .build();
        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        ParsedCron parsedCron = cronParser.parseCron(cron9);
        List<Integer> minutes = List.of(30);
        List<Integer> hours = List.of(4);
        List<Integer> dayOfMonth = List.of(10);
        List<Integer> month = List.of(12);
        List<Integer> dayOfWeek = List.of(2);
        String parsedCommand = parsedCron.getCommand();

        boolean isMinutesSame = minutes.equals(parsedCron.getMinutes());
        boolean isHoursSame = hours.equals(parsedCron.getHours());
        boolean isDayOfMonthSame = dayOfMonth.equals(parsedCron.getDayOfMonth());
        boolean isMonthSame = month.equals(parsedCron.getMonth());
        boolean isDayofWeekSame = dayOfWeek.equals(parsedCron.getDayOfWeek());
        boolean isCommandSame = parsedCommand.equals("ABC");

        if(!isMinutesSame || !isHoursSame || !isDayOfMonthSame|| !isMonthSame || !isDayofWeekSame || !isCommandSame){
            System.out.println("Test 9 FAILED");
        }else {
            System.out.println("Test 9 PASSED");
        }
    }

    void negativeTest1(){
        // Case 1: Minute out of range (>59)
        CronExpression cron1 = new CronExpression.Builder()
                .minutes("60")
                .hours("0")
                .dayOfMonth("1")
                .month("1")
                .dayOfWeek("1")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron1);
            System.out.println("Negative Test 1 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 1 PASSED");

        }
    }

    void negativeTest2(){
        // Case 2: Hour out of range (>23)
        CronExpression cron2 = new CronExpression.Builder()
                .minutes("30")
                .hours("24")
                .dayOfMonth("1")
                .month("1")
                .dayOfWeek("1")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron2);
            System.out.println("Negative Test 2 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 2 PASSED");

        }
    }

    void negativeTest3(){
        // Case 3: Day of month 0 (invalid)
        CronExpression cron3 = new CronExpression.Builder()
                .minutes("30")
                .hours("12")
                .dayOfMonth("0")
                .month("1")
                .dayOfWeek("1")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron3);
            System.out.println("Negative Test 3 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 3 PASSED");

        }
    }

    void negativeTest4(){
        // Case 4: Month out of range (>12)
        CronExpression cron4 = new CronExpression.Builder()
                .minutes("30")
                .hours("12")
                .dayOfMonth("15")
                .month("13")
                .dayOfWeek("1")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron4);
            System.out.println("Negative Test 4 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 4 PASSED");

        }
    }

    void negativeTest5(){
        // Case 5: Day of week out of range (>6)
        CronExpression cron5 = new CronExpression.Builder()
                .minutes("30")
                .hours("12")
                .dayOfMonth("15")
                .month("10")
                .dayOfWeek("7")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron5);
            System.out.println("Negative Test 5 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 5 PASSED");

        }
    }

    void negativeTest6(){
        // Case 6: Invalid character
        CronExpression cron6 = new CronExpression.Builder()
                .minutes("abc")
                .hours("12")
                .dayOfMonth("15")
                .month("10")
                .dayOfWeek("3")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron6);
            System.out.println("Negative Test 6 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 6 PASSED");
        }
    }

    void negativeTest7(){
        // Case 7: Reversed range (start > end)
        CronExpression cron7 = new CronExpression.Builder()
                .minutes("10-5")
                .hours("12")
                .dayOfMonth("15")
                .month("10")
                .dayOfWeek("3")
                .command("ABC")
                .build();


        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron7);
            System.out.println("Negative Test 7 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 7 PASSED");

        }
    }

    void negativeTest8(){
        // Case 8: Empty segment in list
        CronExpression cron8 = new CronExpression.Builder()
                .minutes("10,,15")
                .hours("12")
                .dayOfMonth("15")
                .month("10")
                .dayOfWeek("3")
                .command("ABC")
                .build();


        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron8);
            System.out.println("Negative Test 8 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 8 PASSED");

        }
    }

    void negativeTest9(){
        // Case 9: Invalid step syntax
        CronExpression cron9 = new CronExpression.Builder()
                .minutes("*/")
                .hours("12")
                .dayOfMonth("15")
                .month("10")
                .dayOfWeek("3")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron9);
            System.out.println("Negative Test 9 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 9 PASSED");
        }
    }

    void negativeTest10(){
        // Case 10: Negative number
        CronExpression cron10 = new CronExpression.Builder()
                .minutes("-5")
                .hours("12")
                .dayOfMonth("15")
                .month("10")
                .dayOfWeek("3")
                .command("ABC")
                .build();

        CronParser cronParser = new CronParser(new DefaultCronParserFactory());
        try {
            ParsedCron parsedCron = cronParser.parseCron(cron10);
            System.out.println("Negative Test 10 FAILED");
        }catch (CronParserException e){
            System.out.println("Negative Test 10 PASSED");
        }
    }




}
