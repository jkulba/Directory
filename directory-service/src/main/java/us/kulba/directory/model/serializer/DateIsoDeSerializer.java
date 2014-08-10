package us.kulba.directory.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.util.Date;

/**
 * Custom Json date serializer.
 */
public class DateIsoDeSerializer extends JsonDeserializer<Date> {

    private static final DateTimeFormatter dateFormatter = ISODateTimeFormat.dateTimeParser();

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        String dateInStr = parser.getText();
        return dateFormatter.parseDateTime(dateInStr).toDate();
    }
}