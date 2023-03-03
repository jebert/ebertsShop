package com.eberts.shop.models.vo;

import java.io.Serializable;
import java.util.Objects;

public class AddressVoForSave implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private String cep;
	private String number;
	private String complement;
	private Boolean deliveryAddress;
	
	public AddressVoForSave() {}

	public AddressVoForSave(String cep, String number, String complement, Boolean deliveryAddress) {
		super();
		this.cep = cep;
		this.number = number;
		this.complement = complement;
		this.deliveryAddress = deliveryAddress;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Boolean getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Boolean deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, complement, deliveryAddress, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressVoForSave other = (AddressVoForSave) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(complement, other.complement)
				&& Objects.equals(deliveryAddress, other.deliveryAddress) && Objects.equals(number, other.number);
	}
	
	
}
