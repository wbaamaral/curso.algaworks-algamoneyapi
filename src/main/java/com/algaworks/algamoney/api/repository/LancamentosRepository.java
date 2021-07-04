package com.algaworks.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoney.api.model.Lancamento;

public interface LancamentosRepository extends JpaRepository<Lancamento, Long>{

}
