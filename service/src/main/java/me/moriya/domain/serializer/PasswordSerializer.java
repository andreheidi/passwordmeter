package me.moriya.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import me.moriya.domain.Password;

import java.io.IOException;

public class PasswordSerializer extends JsonSerializer<Password> {

    @Override
    public void serialize(Password password, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (password != null) {
            jgen.writeString(String.format("%s", password.getValue()));
        }
    }

}
