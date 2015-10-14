package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public void efetuaLogin(){
		UsuarioDao dao = new UsuarioDao();
		boolean loginValido = dao.existe(this.usuario);
		System.out.println("O login era válido? " + loginValido);
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
}
