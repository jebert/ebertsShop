package com.eberts.shop.models;

import java.util.UUID;

public class Client extends Person {

	private static final long serialVersionUID = 1L;
	
	public Client() {
	}

	public Client(UUID id, String name, String email) {
		super(id, name, email);
	}

}
