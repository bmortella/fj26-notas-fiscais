package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@RequestScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	@Inject
	private ProdutoDao dao;
	
	public void grava(){
		if(produto.getId() == null){
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}
	
	public void remove(Produto produto){
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	
	public void cancela(){
		this.produto = new Produto();
	}
	
	public Produto getProduto(){
		return this.produto;
	}
	
	public void setProduto(Produto produto){
		this.produto = produto;
	}
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			System.out.println("Carregando produtos...");
			produtos = dao.listaTodos();
		}
		return produtos;
	}
	
}