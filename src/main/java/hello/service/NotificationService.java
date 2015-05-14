package hello.service;

import hello.strategies.NotificationStrategy;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class NotificationService implements Observer {
    private NotificationStrategy notificationStrategy;
    private boolean notificationSent;

    public NotificationService(NotificationStrategy strategy) {
        this.notificationStrategy = strategy;

    }

    public boolean isNotificationSent() {
        return notificationSent;
    }


    public void update(Observable o, Object arg) {
        this.notificationSent = notificationStrategy.sendNotification();
    }
}
