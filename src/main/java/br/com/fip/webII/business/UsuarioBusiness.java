package br.com.fip.webII.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.fip.webII.bean.Usuario;
import br.com.fip.webII.dao.UsuarioDao;

public class UsuarioBusiness implements Serializable{

	
	
	
	public void salvarUsuario(Usuario usuario) {
		try {
			new UsuarioDao().salvar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Usuario> getUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		try {
			
			listaUsuarios = new UsuarioDao().listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaUsuarios;
	}
	
	public boolean getUsuario(String usuario, String senha) {
		boolean result = false;
		try {
			result = new UsuarioDao().buscarUsuario(usuario, senha);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public void deletar(Usuario usuario) {
		
		try {
			new UsuarioDao().deletar(usuario);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
public void atualizar(Usuario usuario) {
		
		try {
			new UsuarioDao().atualizar(usuario);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void mai() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios = getUsuarios();
		for (Usuario usuario : listaUsuarios) {
			System.out.println(usuario.getNomeUsuario());
		}

	}
}
