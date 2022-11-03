package hw3.part3.core.logger;

public class JdbcLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("Logged jdbc: " + message);
    }

}
