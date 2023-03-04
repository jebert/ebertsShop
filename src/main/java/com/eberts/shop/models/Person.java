package com.eberts.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity	
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
    private String name;
    private String email;
    
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();
    
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

	public Person() {}

	public Person(UUID id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documents, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(documents, other.documents) && Objects.equals(id, other.id);
	}


}
