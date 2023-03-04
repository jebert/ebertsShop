package com.eberts.shop.models.vo;

import java.io.Serializable;

import com.eberts.shop.models.Phone;

public class PhoneVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer ddd;
	private String number;
	private Boolean isWhatsApp;
	private Integer phoneType;

	public PhoneVo() {
	}
	
	public Phone convertFromVo(PhoneVo phoneVo) {
		return new Phone(null, phoneVo.getDdd(), phoneVo.getNumber(), phoneVo.getIsWhatsApp(), phoneVo.getPhoneType());
	}

	public PhoneVo(Integer ddd, String number, Boolean isWhatsApp, Integer phoneType) {

		this.ddd = ddd;
		this.number = number;
		this.isWhatsApp = isWhatsApp;
		this.phoneType = phoneType;
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
