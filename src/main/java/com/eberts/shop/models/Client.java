package com.eberts.shop.models;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity	
@Table(name = "clients")
public class Client extends Person {

	private static final long serialVersionUID = 1L;
	
	private String lastName;
    private String userName;
    private String password;
    private String gender;
    
	@JsonManagedReference
	@OneToMany
    private List<Document> documents;
    
    public Client() {}

	public Client(UUID id, String name, String email,String lastName, String userName, String password, String gender) {
		super(id,name,email);
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
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

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(documents, gender, lastName, password, userName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(documents, other.documents) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}
	
}

