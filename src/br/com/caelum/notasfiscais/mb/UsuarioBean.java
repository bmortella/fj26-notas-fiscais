package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao dao;
	
	private List<Usuario> usuarios;
	
	public void grava(){
		if(usuario.getId() == null){
			dao.adiciona(usuario);
		}else{
			dao.atualiza(usuario);
		}
		this.usuario = new Usuario();
		this.usuarios = dao.listaTodos();
	}
	
	public void cancela(){
		this.usuario = new Usuario();
	}
	
	public void remove(Usuario usuario){
		dao.remove(usuario);
		dao.listaTodos();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios(){		
		if(usuarios == null){
			this.usuarios = dao.listaTodos();
		}
		return usuarios;
	}
}
