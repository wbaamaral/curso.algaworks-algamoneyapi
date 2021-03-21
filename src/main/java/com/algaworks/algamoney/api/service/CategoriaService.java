package com.algaworks.algamoney.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria atualizar(Long codigo, @Valid Categoria categoria) {

		Categoria categoriaSalva = buscarCategoriaPorCodigo(codigo);

		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");

		categoriaRepository.save(categoriaSalva);

		return categoriaSalva;
	}

	private Categoria buscarCategoriaPorCodigo(Long codigo) {

		Categoria categoriaSalva = this.categoriaRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return categoriaSalva;
	}

}
