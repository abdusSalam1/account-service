package com.account.domain.notification;

public class NotificationEvent {

    private final NotificationType type;

    public NotificationEvent(NotificationType type) {
        this.type = type;
    }
}
