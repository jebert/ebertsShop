package com.eberts.shop.models.enums;

public enum StateCode {
	AM("Amazonas", "AM", "Manaus", 13), 
	AL("Alagoas", "AL", "Maceió", 27), 
	AC("Acre", "AC", "Rio Branco", 12),
	AP("Amapá", "AP", "Macapá", 16), 
	BA("Bahia", "BA", "Salvador", 19), 
	PA("Pará", "PA", "Belém", 15),
	MT("Mato Grosso", "MT", "Cuiabá", 51), 
	MG("Minas Gerais", "MG", "Belo Horizonte", 31),
	MS("Mato Grosso do Sul", "MS", "Campo Grande", 50), 
	GO("Goiás", "GO", "Goiânia", 52),
	MA("Maranhão", "MA", "São Luís", 21), 
	RS("Rio Grande do Sul", "RS", "Porto Alegre", 43),
	TO("Tocantins", "TO", "Palmas", 17), 
	PI("Piauí", "PI", "Teresina", 22), 
	SP("São Paulo", "SP", "São Paulo", 35),
	RO("Rondônia", "RO", "Porto Velho", 11), 
	RR("Roraima", "RR", "Boa Vista", 14), 
	PR("Paraná", "PR", "Curitiba", 41),
	CE("Ceará", "CE", "Fortaleza", 23), 
	PE("Pernambuco", "PE", "Recife", 26),
	SC("Santa Catarina", "SC", "Florianópolis", 42), 
	PB("Paraíba", "PB", "João Pessoa", 25),
	RN("Rio Grande do Norte", "RN", "Natal", 24), 
	ES("Espírito Santo", "ES", "Vitória", 32),
	RJ("Rio de Janeiro", "RJ", "Rio de Janeiro", 33), 
	SE("Sergipe", "SE", "Aracaju", 28),
	DF("Distrito Federal", "DF", "Brasília", 53);

	private final String name;
	private final String acronym;
	private final String capital;
	private final Integer ibgeCode;

	private StateCode(final String name, final String acronym, final String capital, final Integer ibgeCode) {
		this.name = name;
		this.acronym = acronym;
		this.capital = capital;
		this.ibgeCode = ibgeCode;
	}

	public static StateCode fromName(final String nomeUf) {
		for (final StateCode uf : StateCode.values()) {
			if (uf.name.equalsIgnoreCase(nomeUf)) {
				return uf;
			}
		}

		throw new IllegalArgumentException(nomeUf);
	}

	public static StateCode fromAcronym(final String acronym) {
		for (final StateCode uf : StateCode.values()) {
			if (uf.acronym.equalsIgnoreCase(acronym)) {
				return uf;
			}
		}
		throw new IllegalArgumentException(acronym);
	}

	public static StateCode fromCapital(final String capital) {
		for (final StateCode uf : StateCode.values()) {
			if (uf.capital.equalsIgnoreCase(capital)) {
				return uf;
			}
		}
		throw new IllegalArgumentException(capital);
	}

	public static StateCode fromIbgeCode(final Integer ibgeCode) {
		for (final StateCode uf : StateCode.values()) {
			if (uf.ibgeCode == ibgeCode) {
				return uf;
			}
		}

		throw new IllegalArgumentException(ibgeCode.toString());
	}

	public String getName() {
		return name;
	}

	public String getAcronym() {
		return acronym;
	}

	public String getCapital() {
		return capital;
	}

	public Integer getIbgeCode() {
		return ibgeCode;
	}

}