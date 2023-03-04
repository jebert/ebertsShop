package com.eberts.shop.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private String zip;
	private String street;
	@Column(nullable = false)
    private String number;
	private String complement;
	private String district;
	private boolean deliveryAddress;

	@Column(name = "ibge_code")
    private Integer city;

	
	public Address() {}

	public Address(UUID id, String zip, String street, String number, String complement, String district,
			boolean deliveryAddress, Integer city) {
		this.id = id;
		this.zip = zip;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.deliveryAddress = deliveryAddress;
		this.city = city;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public boolean isDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(boolean deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, complement, deliveryAddress, district, number, street, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(complement, other.complement)
				&& deliveryAddress == other.deliveryAddress && Objects.equals(district, other.district)
				&& Objects.equals(number, other.number) && Objects.equals(street, other.street)
				&& Objects.equals(zip, other.zip);
	}

}
