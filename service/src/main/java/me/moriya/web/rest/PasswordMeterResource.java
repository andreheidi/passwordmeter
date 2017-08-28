package me.moriya.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.moriya.domain.Password;
import me.moriya.domain.PasswordMeter;
//import me.moriya.domain.checker.Password;

@RestController
public class PasswordMeterResource {

	@ResponseBody
	@RequestMapping(value = "/check/{password}", method = RequestMethod.GET)
	public ResponseEntity<PasswordMeter> check(@PathVariable Password password) {
		try {			
			ResponseEntity<PasswordMeter> response = new ResponseEntity<>(PasswordMeter.of(password), HttpStatus.OK);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
