package hello.factories;

import hello.strategies.EmailNotificationStrategy;
import hello.strategies.GmailNotificationStrategy;
import hello.strategies.HotmailNotificationStrategy;

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
