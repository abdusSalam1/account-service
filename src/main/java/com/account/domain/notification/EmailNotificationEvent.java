package com.account.domain.notification;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailNotificationEvent extends NotificationEvent {

    private String toEmail;

    @Builder
    public EmailNotificationEvent(NotificationType type, String toEmail) {
        super(type);
        this.toEmail = toEmail;
    }

}
