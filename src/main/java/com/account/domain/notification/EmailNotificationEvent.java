package com.account.domain.notification;

import lombok.Builder;

public class EmailNotificationEvent extends NotificationEvent {

    private final String toEmail;

    @Builder
    public EmailNotificationEvent(NotificationType type, String toEmail) {
        super(type);
        this.toEmail = toEmail;
    }

}
