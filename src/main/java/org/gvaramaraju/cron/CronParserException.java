package org.gvaramaraju.cron;

public class CronParserException extends RuntimeException{
    public CronParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CronParserException(String message) {
        super(message);
    }
}
