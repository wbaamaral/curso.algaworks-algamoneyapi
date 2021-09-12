package com.algaworks.algamoney.api.repository.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class ResumoPessoas {

	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String nome;
	
	private boolean ativo;
}
