package com.algaworks.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.LancamentoRepository;
import com.algaworks.algamoney.api.repository.PessoaRepository;
import com.algaworks.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());

		/*
		 * Com a mudança na versão do spring, a aula não reflete 100% da necessidade,
		 * existe a necessidade de utilizar o Optional<T>, para pegar a propriedade de
		 * ... dentro do objeto opicional pessoal isInativo usei o .get()
		 */

		if (!pessoa.isPresent() || pessoa.get().isInativo()) {

			throw new PessoaInexistenteOuInativaException();

		}

		return lancamentoRepository.save(lancamento);
	}

}
