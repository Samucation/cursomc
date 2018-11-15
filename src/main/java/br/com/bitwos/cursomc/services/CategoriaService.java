package br.com.bitwos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bitwos.cursomc.domain.Categoria;
import br.com.bitwos.cursomc.repositories.CategoriaRepository;
import br.com.bitwos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	private @Autowired CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(msg(id)));
	}
	
	private String msg(Integer id) {
		return "Objeto não encontrado Id: " + id + ", Tipo: " + Categoria.class.getName();
	}
}
