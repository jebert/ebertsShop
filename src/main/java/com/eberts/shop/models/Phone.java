package com.eberts.shop.models;

import java.io.Serializable;
import java.util.UUID;

import com.eberts.shop.models.enums.PhoneType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity	
public class Phone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Integer ddd;
	private String number;
	private Boolean isWhatsApp;
	private Integer phoneType;

	public Phone() {}

	public Phone(UUID id, Integer ddd, String number, Boolean isWhatsApp, Integer phoneType) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.isWhatsApp = isWhatsApp;
		this.phoneType = phoneType;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
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

}
