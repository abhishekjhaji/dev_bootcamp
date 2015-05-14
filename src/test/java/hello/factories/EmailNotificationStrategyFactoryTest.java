package hello.factories;

import org.junit.Assert;
import org.junit.Test;
import hello.strategies.EmailNotificationStrategy;


public class EmailNotificationStrategyFactoryTest {

    @Test
    public void testIfActiveEmailNotificationStrategyIsReturned(){
        String activeServiceProvider = "gmail";
        EmailNotificationStrategy strategy = EmailNotificationStrategyFactory.getStrategy();
        Assert.assertEquals(activeServiceProvider,strategy.getServiceProvider());
    }
}
