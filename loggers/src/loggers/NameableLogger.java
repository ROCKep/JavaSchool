package loggers;

public class NameableLogger extends Logger {
    private final String name;

    public NameableLogger(final int level, final String name) {
        super(level);
        this.name = name;
    }

    @Override
    public void log(final int level, final String message) {
        if (level <= this.getLevel()) {
            System.out.print(String.format("%s: ", name));
            super.log(level, message);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " NameableLogger{" +
                "name='" + name + '\'' +
                '}';
    }
}
