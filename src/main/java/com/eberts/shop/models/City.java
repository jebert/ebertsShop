package com.eberts.shop.models;

import java.io.Serializable;
import java.util.Objects;

import com.eberts.shop.models.enums.StateCode;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;	

	private Integer ibgeCode;
	private String name;
	private String state;

	public City() {
	}

	public City(String name, String stateAcronym, Integer ibgeCode) {
		this.name = name;
		this.ibgeCode = ibgeCode;
		this.state = StateCode.fromAcronym(stateAcronym).getAcronym();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getIbgeCode() {
		return ibgeCode;
	}

	public void setIbgeCode(Integer ibgeCode) {
		this.ibgeCode = ibgeCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(ibgeCode, other.ibgeCode);
	}
}
