package com.account.service;

import com.account.domain.NotificationType;

public interface NotificationService {

    void sendEmail(NotificationType type, String email);

    void sendSMS(NotificationType type, String phoneNumber);
}
