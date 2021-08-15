package com.algaworks.algamoney.api.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

		Optional<Pessoa> pessoa = Optional.ofNullable(recuperarPessoa(lancamento));

		/*
		 * Com a mudança na versão do spring, a aula não reflete 100% da necessidade,
		 * existe a necessidade de utilizar o Optional<T>, para pegar a propriedade de
		 * ... dentro do objeto opicional pessoal isInativo usei o .get()
		 */

		validarPessoa(pessoa);

		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Long codigo, @Valid Lancamento lancamento) {
		Pessoa pessoa = null;
		Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);

		if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
			pessoa = validarPessoaLancamento(lancamento);
			lancamento.setPessoa(pessoa);
		}

		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

		return lancamentoRepository.save(lancamentoSalvo);
	}

	private Pessoa validarPessoaLancamento(@Valid Lancamento lancamento) {
		Pessoa pessoa = null;

		if (lancamento.getPessoa().getCodigo() != null) {
			pessoa = recuperarPessoa(lancamento);

		}
		validarPessoa(Optional.ofNullable(pessoa));

		return pessoa;
	}

	private void validarPessoa(Optional<Pessoa> pessoa) {

		if (!pessoa.isPresent() || pessoa.get().isInativo()) {

			throw new PessoaInexistenteOuInativaException();

		}
	}

	private Lancamento buscarLancamentoExistente(Long codigo) {
		Optional<Lancamento> lancamento = lancamentoRepository.findById(codigo);

		if (lancamento == null) {
			throw new IllegalArgumentException();
		}

		return lancamento.get();
	}

	private Pessoa recuperarPessoa(Lancamento lancamento) {

		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();

		return pessoa;
	}
}
