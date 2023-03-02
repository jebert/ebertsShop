package com.eberts.shop.models.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityVOForIbge implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "municipio-id")
	private Integer municipioId;
	
	@JsonProperty(value = "municipio-nome")
	private String  municipioNome;
	
	@JsonProperty(value = "microrregiao-id")
	private Integer microRregiaoId;
	
	@JsonProperty(value = "microrregiao-nome")
	private String microRregiaoNome;
	
	@JsonProperty(value = "mesorregiao-id")
	private Integer mesoRregiaoId;
	
	@JsonProperty(value =  "mesorregiao-nome")
	private String mesoRregiaoNome;
	
	@JsonProperty(value = "regiao-imediata-id")
	private Integer regiaoImediataId;
	
	@JsonProperty(value = "regiao-imediata-nome")
	private String regiaoImediataNome;
	
	@JsonProperty(value = "regiao-intermediaria-id")
	private Integer regiaoIntermediariaId;
	
	@JsonProperty(value = "regiao-intermediaria-nome")
	private String regiaoIntermediariaNome;
	
	@JsonProperty(value = "UF-id")
	private Integer UFId;
	
	@JsonProperty(value = "UF-sigla")
	private String UFSigla;
	
	@JsonProperty(value = "UF-nome")
	private String UFNome;
	
	@JsonProperty(value = "regiao-id")
	private Integer regiaoId;
	
	@JsonProperty(value = "regiao-sigla")
	private String regiaoSigla;
	
	@JsonProperty(value = "regiao-nome")
	private String regiaoNme;

	public CityVOForIbge() {
	}

	public CityVOForIbge(Integer municipioId, String municipioNome, Integer microRregiaoId, String microRregiaoNome,
			Integer mesoRregiaoId, String mesoRregiaoNome, Integer regiaoImediataId, String regiaoImediataNome,
			Integer regiaoIntermediariaId, String regiaoIntermediariaNome, Integer uFId, String uFSigla, String uFNome,
			Integer regiaoId, String regiaoSigla, String regiaoNme) {
		super();
		this.municipioId = municipioId;
		this.municipioNome = municipioNome;
		this.microRregiaoId = microRregiaoId;
		this.microRregiaoNome = microRregiaoNome;
		this.mesoRregiaoId = mesoRregiaoId;
		this.mesoRregiaoNome = mesoRregiaoNome;
		this.regiaoImediataId = regiaoImediataId;
		this.regiaoImediataNome = regiaoImediataNome;
		this.regiaoIntermediariaId = regiaoIntermediariaId;
		this.regiaoIntermediariaNome = regiaoIntermediariaNome;
		this.UFId = uFId;
		this.UFSigla = uFSigla;
		this.UFNome = uFNome;
		this.regiaoId = regiaoId;
		this.regiaoSigla = regiaoSigla;
		this.regiaoNme = regiaoNme;
	}

	public Integer getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

	public String getMunicipioNome() {
		return municipioNome;
	}

	public void setMunicipioNome(String municipioNome) {
		this.municipioNome = municipioNome;
	}

	public Integer getMicroRregiaoId() {
		return microRregiaoId;
	}

	public void setMicroRregiaoId(Integer microRregiaoId) {
		this.microRregiaoId = microRregiaoId;
	}

	public String getMicroRregiaoNome() {
		return microRregiaoNome;
	}

	public void setMicroRregiaoNome(String microRregiaoNome) {
		this.microRregiaoNome = microRregiaoNome;
	}

	public Integer getMesoRregiaoId() {
		return mesoRregiaoId;
	}

	public void setMesoRregiaoId(Integer mesoRregiaoId) {
		this.mesoRregiaoId = mesoRregiaoId;
	}

	public String getMesoRregiaoNome() {
		return mesoRregiaoNome;
	}

	public void setMesoRregiaoNome(String mesoRregiaoNome) {
		this.mesoRregiaoNome = mesoRregiaoNome;
	}

	public Integer getRegiaoImediataId() {
		return regiaoImediataId;
	}

	public void setRegiaoImediataId(Integer regiaoImediataId) {
		this.regiaoImediataId = regiaoImediataId;
	}

	public String getRegiaoImediataNome() {
		return regiaoImediataNome;
	}

	public void setRegiaoImediataNome(String regiaoImediataNome) {
		this.regiaoImediataNome = regiaoImediataNome;
	}

	public Integer getRegiaoIntermediariaId() {
		return regiaoIntermediariaId;
	}

	public void setRegiaoIntermediariaId(Integer regiaoIntermediariaId) {
		this.regiaoIntermediariaId = regiaoIntermediariaId;
	}

	public String getRegiaoIntermediariaNome() {
		return regiaoIntermediariaNome;
	}

	public void setRegiaoIntermediariaNome(String regiaoIntermediariaNome) {
		this.regiaoIntermediariaNome = regiaoIntermediariaNome;
	}

	public Integer getUFId() {
		return UFId;
	}

	public void setUFId(Integer uFId) {
		UFId = uFId;
	}

	public String getUFSigla() {
		return UFSigla;
	}

	public void setUFSigla(String uFSigla) {
		UFSigla = uFSigla;
	}

	public String getUFNome() {
		return UFNome;
	}

	public void setUFNome(String uFNome) {
		UFNome = uFNome;
	}

	public Integer getRegiaoId() {
		return regiaoId;
	}

	public void setRegiaoId(Integer regiaoId) {
		this.regiaoId = regiaoId;
	}

	public String getRegiaoSigla() {
		return regiaoSigla;
	}

	public void setRegiaoSigla(String regiaoSigla) {
		this.regiaoSigla = regiaoSigla;
	}

	public String getRegiaoNme() {
		return regiaoNme;
	}

	public void setRegiaoNme(String regiaoNme) {
		this.regiaoNme = regiaoNme;
	}

	@Override
	public int hashCode() {
		return Objects.hash(municipioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityVOForIbge other = (CityVOForIbge) obj;
		return Objects.equals(municipioId, other.municipioId);
	}
}
