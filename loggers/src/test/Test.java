package test;

import loggers.Logger;
import loggers.NameableLogger;
import loggers.RepeatableLogger;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        for (Logger.Level loggerLevel : Logger.Level.values()) {
            List<Logger> loggers = new ArrayList<>();
            loggers.add(new Logger(loggerLevel.getNumber()));
            loggers.add(new NameableLogger(loggerLevel.getNumber(), "Name"));
            loggers.add(new RepeatableLogger(loggerLevel.getNumber(), 3));
            for (Logger logger : loggers) {
                for (Logger.Level messageLevel : Logger.Level.values()) {
                    logger.log(messageLevel.getNumber(),
                            String.format("%s message for %s logger", messageLevel.name(), loggerLevel.name()));
                }
            }
        }
    }
}
