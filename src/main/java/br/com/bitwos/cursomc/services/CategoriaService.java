package br.com.bitwos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bitwos.cursomc.domain.Categoria;
import br.com.bitwos.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	private @Autowired CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
