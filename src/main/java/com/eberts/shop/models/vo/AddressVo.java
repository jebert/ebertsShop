package com.eberts.shop.models.vo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AddressVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Cep is required!")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}|[0-9]{5}[0-9]{3}", message = "Please insert a valid CEP! - XXXXXX-XXX")
	private String cep;
	@NotBlank(message = "Number is required!")
	private String number;
	private String complement;
	private Boolean deliveryAddress;
	
	public AddressVo() {}

	public AddressVo(String cep, String number, String complement, Boolean deliveryAddress) {
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
		AddressVo other = (AddressVo) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(complement, other.complement)
				&& Objects.equals(deliveryAddress, other.deliveryAddress) && Objects.equals(number, other.number);
	}
	
	
}
