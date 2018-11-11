package br.com.bitwos.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitwos.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritorio");
		
		List<Categoria> listaCategoria = new ArrayList<>();
		
		listaCategoria.add(cat);
		listaCategoria.add(cat2);
		
		return listaCategoria;
	}
	
}
