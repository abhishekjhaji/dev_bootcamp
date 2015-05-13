package factories;

import strategies.EmailNotificationStrategy;
import strategies.GmailNotificationStrategy;
import strategies.HotmailNotificationStrategy;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class EmailNotificationStrategyFactory {

   private static final String activeServiceProviderSetting = "gmail"; //TODO: should come from config

    public static EmailNotificationStrategy getStrategy() {
        switch ( activeServiceProviderSetting) {
            case "gmail":
                return new GmailNotificationStrategy();
            case "hotmail":
                return new HotmailNotificationStrategy();
            default:
                return new GmailNotificationStrategy();
        }
    }
}
