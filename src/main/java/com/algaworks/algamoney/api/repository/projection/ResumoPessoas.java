package com.algaworks.algamoney.api.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.algaworks.algamoney.api.model.TipoLancamento;

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
}
