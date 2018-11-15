package br.com.bitwos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bitwos.cursomc.domain.Cliente;
import br.com.bitwos.cursomc.repositories.ClienteRepository;
import br.com.bitwos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	private @Autowired ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(msg(id)));
	}
	
	private String msg(Integer id) {
		return "Objeto não encontrado Id: " + id + ", Tipo: " + Cliente.class.getName();
	}
}
