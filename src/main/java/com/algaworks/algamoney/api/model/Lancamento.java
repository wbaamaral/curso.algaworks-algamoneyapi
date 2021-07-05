package com.algaworks.algamoney.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

// Lombok
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

// Hibernate
@Entity
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@NotNull
	private Long codigo;

	@NotNull
	private String descricao;

	@Column(name = "data_vencimento")
	@NotNull
	private LocalDate dataVencimento;

	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;

	@NotNull
	private BigDecimal valor;

	private String observacao;

	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoLancamento tipo;

	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	@NotNull
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	@NotNull
	private Pessoa pessoa;
}
