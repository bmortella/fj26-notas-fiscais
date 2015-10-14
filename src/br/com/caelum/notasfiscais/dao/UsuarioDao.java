package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.modelo.Usuario;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public boolean existe(Usuario usuario) {
		
		Query query = manager.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
						.setParameter("pLogin", usuario.getLogin())
						.setParameter("pSenha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}
	
	public void adiciona(Usuario usuario){
		manager.persist(usuario);
	}
	
	public void remove(Usuario usuario){
		manager.remove(manager.merge(usuario));
	}
	
	public void atualiza(Usuario usuario){
		manager.merge(usuario);
	}
	
	public List<Usuario> listaTodos(){
		String jpql = "select u from Usuario u";
		List<Usuario> lista = manager.createQuery(jpql, Usuario.class).getResultList();
		return lista;
	}
}