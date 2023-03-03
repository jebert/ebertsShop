package com.eberts.shop.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> list = new ArrayList<>();
	public ValidationError() {
	}

	public ValidationError(Integer status, String msg, long timeStamp) {
		super(status, msg, timeStamp);

	}

	public List<FieldMessage> getError() {
		return list;
	}

	public void addError (String fieldName, String message) {
		list.add(new FieldMessage(fieldName, message));
	}


}
