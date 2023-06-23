package org.raj.mvcapp.dto;

import java.io.Serializable;

public class GreetingsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String greeting;

	public GreetingsDTO(String greeting) {
		super();
		this.greeting = greeting;
	}

	public GreetingsDTO() {
		super();
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
