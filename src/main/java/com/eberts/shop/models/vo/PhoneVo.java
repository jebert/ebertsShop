package com.eberts.shop.models.vo;

import java.io.Serializable;
import java.util.UUID;

public class PhoneVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private Integer ddd;
	private String number;
	private Boolean isWhatsApp;
	private Integer phoneType;

	public PhoneVo() {
	}

	public PhoneVo(UUID id, Integer ddd, String number, Boolean isWhatsApp, Integer phoneType) {
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

	public Integer getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Integer phoneType) {
		this.phoneType = phoneType;
	}
	
}
