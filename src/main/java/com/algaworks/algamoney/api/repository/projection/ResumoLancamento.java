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
public class ResumoLancamento {

	@EqualsAndHashCode.Include
	private Long codigo;

	private String descricao;

	private LocalDate dataVencimento;

	private LocalDate dataPagamento;
	
	private BigDecimal valor;

	private TipoLancamento tipo;

	private String categoria;

	private String pessoa;

}
