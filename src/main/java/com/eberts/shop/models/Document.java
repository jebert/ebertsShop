package com.eberts.shop.models;

import java.io.Serializable;
import java.util.UUID;

import com.eberts.shop.models.helpers.DocType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Document implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private UUID id;
	private String document;
	private String docType;
		
	
	public Document(String document, DocType docType) {
		this.document = document;
		this.docType = docType.getDocName();
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public DocType getDocType(String docName) {
		return DocType.fromDocName(docName);
	}
	public void setDocType(DocType docType) {
		this.docType = docType.getDocName();
	}
}
