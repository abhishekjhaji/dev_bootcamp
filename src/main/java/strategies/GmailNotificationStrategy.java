package strategies;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class GmailNotificationStrategy extends EmailNotificationStrategy {
    private final String serviceProvider = "gmail";


    @Override
    public String getServiceProvider() {
        return serviceProvider;
    }
}
