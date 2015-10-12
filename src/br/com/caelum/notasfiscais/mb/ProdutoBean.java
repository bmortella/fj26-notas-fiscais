package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	public void grava(){
		ProdutoDao dao = new ProdutoDao();
		dao.adiciona(produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto(){
		return this.produto;
	}
	
}
