package me.moriya.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import me.moriya.domain.Complexity;

import java.io.IOException;

public class ComplexitySerializer extends JsonSerializer<Complexity> {

	@Override
	public void serialize(Complexity complexity, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		if (complexity != null) {
			jgen.writeString(String.format("%s", complexity));
		}
	}

}
