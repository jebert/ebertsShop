package com.eberts.shop.models.vo;

import java.io.Serializable;
import java.util.Objects;

public class DocumentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String document;
	private String docType;
	
	public DocumentVo(){}
	
	public DocumentVo(String document, String docType) {
		this.document = document;
		this.docType = docType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(document);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentVo other = (DocumentVo) obj;
		return Objects.equals(document, other.document);
	}

}
