package com.account.config.kafka.serializer;

import com.account.domain.notification.EmailNotificationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class EmailSerializer implements Serializer<EmailNotificationEvent> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, EmailNotificationEvent emailNotificationEvent) {
        try {
            if (emailNotificationEvent == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(emailNotificationEvent);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing Email to byte[]");
        }
    }
}
