package com.algaworks.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);

		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");

		pessoaRepository.save(pessoaSalva);

		return pessoaSalva;
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {

		Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);

		pessoaSalva.setAtivo(ativo);

		pessoaRepository.save(pessoaSalva);
	}

	private Pessoa buscarPessoaPorCodigo(Long codigo) {
		Pessoa pessoaSalva = this.pessoaRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return pessoaSalva;
	}
}
