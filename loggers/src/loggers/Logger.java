package loggers;

import java.time.LocalDateTime;

public class Logger {
    public enum Level {
        ERROR(0),
        INFO(10),
        DEBUG(20);

        private final int number;

        Level(final int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public static Level getLevelByNumber(final int number) {
            for (Level level : Level.values()) {
                if (level.getNumber() == number) {
                    return level;
                }
            }
            throw new IllegalArgumentException("Level with this number does not exist");
        }

        @Override
        public String toString() {
            return "Level{" +
                    "number=" + number +
                    '}';
        }
    }

    private final Level level;
    private int messageNumber;

    public Logger(final int level) {
        this.level = Level.getLevelByNumber(level);
        messageNumber = 0;
    }

    public void log(final int level, final String message) {
        if (level <= this.level.getNumber()) {
            System.out.println(String.format("%d %s %d: %s", messageNumber++, LocalDateTime.now(), level, message));
        }
    }

    @Override
    public String toString() {
        return "loggers.Logger{" +
                "level=" + level +
                " messageNumber=" + messageNumber +
                '}';
    }

    public int getLevel() {
        return level.getNumber();
    }
}
