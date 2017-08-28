package me.moriya.domain;

import java.io.Serializable;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.moriya.domain.serializer.PasswordDeserializer;
import me.moriya.domain.serializer.PasswordSerializer;

@Getter
@ToString
@EqualsAndHashCode
@JsonSerialize(using = PasswordSerializer.class)
@JsonDeserialize(using = PasswordDeserializer.class)
public class Password implements Serializable{
	
	private static final long serialVersionUID = -2166091650960670249L;
	
	private String value;

	private Password(String value) {
		value = Optional.ofNullable(value).orElse("");
		this.value = value.replaceAll("\\s", "");
	}

	public static Password of(String value) {
		return new Password(value);
	}
	
	public int getLength() {
		return value.length();
	}

	public boolean isEmpty() {
		return value.length() == 0;
	}

}
