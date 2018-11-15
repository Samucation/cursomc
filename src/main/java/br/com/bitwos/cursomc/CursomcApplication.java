package br.com.bitwos.cursomc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bitwos.cursomc.domain.Categoria;
import br.com.bitwos.cursomc.domain.Cidade;
import br.com.bitwos.cursomc.domain.Cliente;
import br.com.bitwos.cursomc.domain.Endereco;
import br.com.bitwos.cursomc.domain.Estado;
import br.com.bitwos.cursomc.domain.Pagamento;
import br.com.bitwos.cursomc.domain.PagamentoComBoleto;
import br.com.bitwos.cursomc.domain.PagamentoComCartao;
import br.com.bitwos.cursomc.domain.Pedido;
import br.com.bitwos.cursomc.domain.Produto;
import br.com.bitwos.cursomc.domain.enums.EstadoPagamento;
import br.com.bitwos.cursomc.domain.enums.TipoCliente;
import br.com.bitwos.cursomc.repositories.CategoriaRepository;
import br.com.bitwos.cursomc.repositories.CidadeRepository;
import br.com.bitwos.cursomc.repositories.ClienteRepository;
import br.com.bitwos.cursomc.repositories.EnderecoRepository;
import br.com.bitwos.cursomc.repositories.EstadoRepository;
import br.com.bitwos.cursomc.repositories.PagamentoRepository;
import br.com.bitwos.cursomc.repositories.PedidoRepository;
import br.com.bitwos.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	private @Autowired CategoriaRepository categoriaRepository;
	private @Autowired ProdutoRepository produtoRepository;
	
	private @Autowired EstadoRepository estadoRepository;
	private @Autowired CidadeRepository cidadeRepository;

	private @Autowired ClienteRepository clienteRepository;
	private @Autowired EnderecoRepository enderecoRepository;
	
	private @Autowired PedidoRepository pedidoRepository;
	private @Autowired PagamentoRepository pagamentoRepository;
	

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
		
		Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("98312255", "98552311"));
		
		Endereco e1 = new Endereco("Rua Flores", "300", "Apto 303", "Jardim", "8702033662", cli1, c1);
		Endereco e2 = new Endereco("Rua Cravos", "600", "Apto 606", "Matagal", "8702033662", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(sdf.parse("10/10/2017 10:32"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2,
				                                  sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}
}
