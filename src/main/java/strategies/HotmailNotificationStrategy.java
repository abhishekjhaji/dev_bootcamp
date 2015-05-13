package strategies;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class HotmailNotificationStrategy extends EmailNotificationStrategy {
    private final String serviceProvider = "hotmail";
    @Override
    public String getServiceProvider() {
        return serviceProvider;
    }
}
