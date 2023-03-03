package com.eberts.shop.resources.exceptions;

import java.io.Serializable;
import java.util.Objects;

public class FieldMessage  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String fieldMessage;
	
	public FieldMessage() {}
	
	public FieldMessage(String name, String fieldMessage) {
		this.name = name;
		this.fieldMessage = fieldMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fieldMessage, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldMessage other = (FieldMessage) obj;
		return Objects.equals(fieldMessage, other.fieldMessage) && Objects.equals(name, other.name);
	}
	
	

}
