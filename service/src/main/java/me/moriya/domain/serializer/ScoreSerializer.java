package me.moriya.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import me.moriya.domain.Score;

import java.io.IOException;

public class ScoreSerializer extends JsonSerializer<Score> {

    @Override
    public void serialize(Score score, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (score != null) {
            if (score.getValue() > 100){
                jgen.writeString("100");
            }
            else if (score.getValue() < 0){
                jgen.writeString("0");
            }
            else{
                jgen.writeString(String.format("%s", score.getValue()));
            }
        }
    }

}
