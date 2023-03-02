package com.eberts.shop.models;

import java.io.Serializable;
import java.util.UUID;

import com.eberts.shop.models.enums.PhoneType;

public class Phone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private String number;
	private Boolean isWhatsApp;
	private Integer phoneType;
	
	private Person owner;

	public Phone() {}

	public Phone(UUID id, String number, Boolean isWhatsApp, Integer phoneType, Person owner) {
		super();
		this.id = id;
		this.number = number;
		this.isWhatsApp = isWhatsApp;
		this.phoneType = phoneType;
		this.owner = owner;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getIsWhatsApp() {
		return isWhatsApp;
	}

	public void setIsWhatsApp(Boolean isWhatsApp) {
		this.isWhatsApp = isWhatsApp;
	}

	public PhoneType getPhoneType(Integer cod) {
		return PhoneType.fromCod(cod);
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType.getCod();
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	
	

}
