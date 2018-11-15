package br.com.bitwos.cursomc;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bitwos.cursomc.domain.Categoria;
import br.com.bitwos.cursomc.domain.Cidade;
import br.com.bitwos.cursomc.domain.Estado;
import br.com.bitwos.cursomc.domain.Produto;
import br.com.bitwos.cursomc.repositories.CategoriaRepository;
import br.com.bitwos.cursomc.repositories.CidadeRepository;
import br.com.bitwos.cursomc.repositories.EstadoRepository;
import br.com.bitwos.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	private @Autowired CategoriaRepository categoriaRepository;
	private @Autowired ProdutoRepository produtoRepository;
	
	private @Autowired EstadoRepository estadoRepository;
	private @Autowired CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		
		Produto p1 = new Produto("Computador", new BigDecimal("10.00"));
		Produto p2 = new Produto("Impressora", new BigDecimal("30.00"));
		Produto p3 = new Produto("Scanner", new BigDecimal("40.00"));
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade c1 = new Cidade("Uberlandia", est1);
		Cidade c2 = new Cidade("São Paulo", est2);
		Cidade c3 = new Cidade("Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
}
