package com.eberts.shop.models.enums;

public enum PhoneType {

	RES("Residencial", 1),
	CEL("Celular", 2),
	EMP("Empresarial", 3);
	
	private String type;
	private Integer cod;
	
	private PhoneType(String type, Integer cod) {
		this.type = type;
		this.cod = cod;
	}

	public String getType() {
		return type;
	}

	public Integer getCod() {
		return cod;
	}

	public static PhoneType fromType(final String type) {
		for (final PhoneType pt : PhoneType.values()) {
			if (pt.type.equalsIgnoreCase(type)) {
				return pt;
			}
		}

		throw new IllegalArgumentException(type);
	}
	public static PhoneType fromCod(final Integer cod) {
		for (final PhoneType pt : PhoneType.values()) {
			if (pt.cod == cod) {
				return pt;
			}
		}

		throw new IllegalArgumentException(cod.toString());
	}
}
