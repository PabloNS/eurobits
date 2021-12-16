package es.care.sf.scenariosystem.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.care.sf.scenariosystem.domain.MoneyEurobits;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class MoneyEurobitsConverter implements AttributeConverter<MoneyEurobits, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(MoneyEurobits meta) {
        try {
            return objectMapper.writeValueAsString(meta);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public MoneyEurobits convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, MoneyEurobits.class);
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }

}