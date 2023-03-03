package com.eberts.shop.models.helpers;

public enum DocType {

	RG("Registro Geral", 1), 
	CPF("Código de Pessoa Fisica", 2), 
	CNH("Carteira Nacional de Habilitação", 3),
	PB("Passaporte Brasileiro", 4), 
	DNI("Documento Nacional de Identificação", 5), 
	CN("Certidão de Nascimento", 6),
	CC("Certidão de Casamento", 7), 
	CTPS("Carteira de Trabalho e Previdência Social", 8), 
	TE("Titulo de Eleitor", 9),
	CNPJ("Código Nacional da Pessoa Jurídica", 10), 
	IE("Inscrissão Estadual", 11), 
	AF("Alvará de Funcionamento", 12),
	CD("Certificado Digital", 13);

	private final String docName;
	private final Integer docCode;

	private DocType(final String docName, final Integer docCode) {
		this.docName = docName;
		this.docCode = docCode;
	}
	
	public static DocType fromDocName(final String docName) {
		for (final DocType docType : DocType.values()) {
			if (docType.docName.equalsIgnoreCase(docName)) {
				return docType;
			}
		}

		throw new IllegalArgumentException(docName);
	}
	
	public static DocType fromDocCode(final Integer docCode) {
		for (final DocType docType : DocType.values()) {
			if (docType.getDocCode() == docCode) {
				return docType;
			}
		}

		throw new IllegalArgumentException("Invalid "+ docCode);
	}

	public String getDocName() {
		return docName;
	}

	public Integer getDocCode() {
		return docCode;
	}
	
}
