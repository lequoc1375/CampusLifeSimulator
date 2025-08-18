package com.example.app.util;

import org.jasypt.encryption.StringEncryptor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SecretAttributesConverter implements AttributeConverter<String, String> {

    private StringEncryptor getEncryptor() {
        return SpringContext.getBean(StringEncryptor.class);
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return attribute;
        }
        return getEncryptor().encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return dbData;
        }
        return getEncryptor().decrypt(dbData);
    }
}
