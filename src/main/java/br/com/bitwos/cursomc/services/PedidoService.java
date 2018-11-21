package br.com.bitwos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bitwos.cursomc.domain.Pedido;
import br.com.bitwos.cursomc.repositories.PedidoRepository;
import br.com.bitwos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	private @Autowired PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(msg(id)));
	}
	
	private String msg(Integer id) {
		return "Objeto não encontrado Id: " + id + ", Tipo: " + Pedido.class.getName();
	}
}
