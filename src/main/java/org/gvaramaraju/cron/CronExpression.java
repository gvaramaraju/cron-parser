package org.gvaramaraju.cron;

import static org.gvaramaraju.cron.Constants.ALL;

public class CronExpression {
    private final String minutes;
    private final String hours;
    private final String dayOfMonth;
    private final String month;
    private final String dayOfWeek;
    private final String command;

    private CronExpression(String minutes, String hours, String dayOfMonth, String month, String dayOfWeek, String command) {
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.command = command;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getHours() {
        return hours;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public String getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getCommand() {
        return command;
    }

    public static class Builder {
        private String minutes;
        private String hours;
        private String dayOfMonth;
        private String month;
        private String dayOfWeek;
        private String command;

        public Builder() {
        }

        public Builder minutes(String minutes) {
            this.minutes = minutes;
            return this;
        }

        public Builder hours(String hours) {
            this.hours = hours;
            return this;
        }

        public Builder dayOfMonth(String dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder dayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public Builder command(String command) {
            this.command = command;
            return this;
        }

        public CronExpression build() {
            if (this.minutes == null) this.minutes = ALL;
            if (this.hours == null) this.minutes = ALL;
            if (this.dayOfMonth == null) this.minutes = ALL;
            if (this.month == null) this.minutes = ALL;
            if (this.dayOfWeek == null) this.minutes = ALL;
            return new CronExpression(this.minutes, this.hours, this.dayOfMonth, this.month, this.dayOfWeek, this.command);
        }
    }
}
