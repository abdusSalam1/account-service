package com.account.domain.notification;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationEvent {

    private NotificationType type;

    public NotificationEvent(NotificationType type) {
        this.type = type;
    }
}
