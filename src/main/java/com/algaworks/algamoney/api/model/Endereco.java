package com.algaworks.algamoney.api.model;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class Endereco {

	private String logradouro;
 	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String complemento;


}
