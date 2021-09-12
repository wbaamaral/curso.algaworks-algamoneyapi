package com.algaworks.algamoney.api.repository.pessoa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.filter.PessoaFilter;
import com.algaworks.algamoney.api.repository.projection.ResumoPessoas;

public interface PessoaRepositoryQuery {
	
	public Page<Pessoa> filtrarNome(PessoaFilter pessoaFilter, Pageable pageable);

	public List<ResumoPessoas> getCombobox(boolean acaoEditar);

}
