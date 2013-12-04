/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.springjsfrest.controller.json;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author wouter
 */
public class CustomDateSerializer extends JsonSerializer<DateTime>
{

    private static DateTimeFormatter formatter =
            DateTimeFormat.forPattern("dd-MM-yyyy");

    @Override
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException
    {
        gen.writeString(String.valueOf(value.getMillis()));
    }

    @Override
    public Class<DateTime> handledType()
    {
        return DateTime.class;
    }    
}
