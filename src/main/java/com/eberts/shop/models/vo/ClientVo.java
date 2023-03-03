package com.eberts.shop.models.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.eberts.shop.models.Address;
import com.eberts.shop.models.Document;
import com.eberts.shop.models.Phone;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.OneToMany;

public class ClientVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private UUID id;

    private String name;
	private String lastName;
    private String userName;
    private String email;
    private String password;
    private String gender;

    private List<PhoneVo> phones = new ArrayList<>();

	private List<AddressVo> addresses = new ArrayList<>();

    private List<DocumentVo> documents = new ArrayList<>();

	public ClientVo() {
	}

	public ClientVo(UUID id, String name, String lastName, String userName, String email, String password,
			String gender, List<PhoneVo> phones, List<AddressVo> addresses, List<DocumentVo> documents) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phones = phones;
		this.addresses = addresses;
		this.documents = documents;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<PhoneVo> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneVo> phones) {
		this.phones = phones;
	}

	public List<AddressVo> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressVo> addresses) {
		this.addresses = addresses;
	}

	public List<DocumentVo> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentVo> documents) {
		this.documents = documents;
	}
    
    


}
