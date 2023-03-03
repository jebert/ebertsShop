package com.eberts.shop.models;

import java.io.Serializable;

import com.eberts.shop.models.helpers.DocType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String document;
	private String docType;
	private Person owner;

	public Document( String document, DocType docType, Person owner) {
		this.document = document;
		this.docType = docType.getDocName();
		this.owner = owner;
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

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

}
