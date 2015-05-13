package strategies;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public abstract class EmailNotificationStrategy implements NotificationStrategy {


    @Override
    public boolean sendNotification() {
        return true;
    }


    public abstract String getServiceProvider() ;

}
