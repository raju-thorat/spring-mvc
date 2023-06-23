package org.raj.mvcapp.controller;

import org.raj.mvcapp.dto.GreetingsDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class HelloControllerV1 {

	@RequestMapping(value = "/hello")
	public ResponseEntity<GreetingsDTO> sayHello() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(new GreetingsDTO("hello"), httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/hi")
	public ResponseEntity<GreetingsDTO> sayHi() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(new GreetingsDTO("hi"), httpHeaders, HttpStatus.OK);
	}

}