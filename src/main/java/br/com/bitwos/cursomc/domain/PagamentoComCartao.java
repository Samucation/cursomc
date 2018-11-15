package br.com.bitwos.cursomc.domain;

import javax.persistence.Entity;

import br.com.bitwos.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{

	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;
	
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(EstadoPagamento estado, Pedido pedido,
			                  Integer numeroDeParcelas) {
		super(estado, pedido);
	    this.numeroDeParcelas = numeroDeParcelas;
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, 
			                  Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	@Override
	public String toString() {
		return "PagamentoComCartao [numeroDeParcelas=" + numeroDeParcelas + "]";
	}
	
}