package com.eberts.shop.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.eberts.shop.models.helpers.DocType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id ;


	public Document() {
	}

	private String document;
	private String docType;

	public Document(UUID id, String document, DocType docType) {
		this.id = id;
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
	
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		Document other = (Document) obj;
		return Objects.equals(document, other.document);
	}

}
