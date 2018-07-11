package loggers;

public class RepeatableLogger extends Logger {
    private final int repeats;

    public RepeatableLogger(final int level, final int repeats) {
        super(level);
        this.repeats = repeats > 1 ? repeats : 1;
    }

    @Override
    public void log(final int level, final String message) {
        if (level <= this.getLevel()) {
            for (int i = 0; i < repeats; i++) {
                System.out.print(String.format("(%d) ", i));
                super.log(level, message);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " RepeatableLogger{" +
                "repeats=" + repeats +
                '}';
    }
}
