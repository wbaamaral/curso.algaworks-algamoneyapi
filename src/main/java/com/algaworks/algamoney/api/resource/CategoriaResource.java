package com.algaworks.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoney.api.event.RecursoCriadoEvent;
import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import com.algaworks.algamoney.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private CategoriaService categoriaService;

	@CrossOrigin (maxAge = 10, origins = { "http://localhost:9800"})
	@GetMapping
	public List<Categoria> listar() {

		return categoriaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@Validated @RequestBody Categoria categoria, HttpServletResponse response) {

		Categoria categoriaSalva = categoriaRepository.save(categoria);

		// chamar o publicador de eventos para formatar uri do objeto novo
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Object> buscarPeloCodigo(@PathVariable Long codigo) {

		Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);

		return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		categoriaRepository.deleteById(codigo);

	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria) {

		Categoria categoriaSalva = categoriaService.atualizar(codigo, categoria);

		return ResponseEntity.ok(categoriaSalva);
	}
}
