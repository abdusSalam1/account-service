package com.account.domain.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmailNotificationEvent extends NotificationEvent {

    private String toEmail;

    @Builder
    public EmailNotificationEvent(NotificationType type, String toEmail) {
        super(type);
        this.toEmail = toEmail;
    }
}
