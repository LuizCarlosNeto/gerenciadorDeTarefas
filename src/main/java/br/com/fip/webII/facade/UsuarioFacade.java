package br.com.fip.webII.facade;

import java.util.List;

import br.com.fip.webII.bean.Usuario;
import br.com.fip.webII.business.CategoriaBusiness;
import br.com.fip.webII.business.UsuarioBusiness;

public class UsuarioFacade {

 public void salvar(Usuario usuario) {
	 new UsuarioBusiness().salvarUsuario(usuario);
	
 }
 public void atualizar(Usuario usuario) {
		new UsuarioBusiness().atualizar(usuario);
 }
 public void deletar(Usuario usuario) {
		new UsuarioBusiness().deletar(usuario);
 }
 public List<Usuario> listar() {
	 
	 return new UsuarioBusiness().getUsuarios();
 }
	public boolean getUsuario(String usuario, String senha) {
		
		return new UsuarioBusiness().getUsuario(usuario,senha);
	}
}
