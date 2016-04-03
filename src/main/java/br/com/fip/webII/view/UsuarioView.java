package br.com.fip.webII.view;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fip.webII.bean.Usuario;
import br.com.fip.webII.business.UsuarioBusiness;

@ManagedBean
@SessionScoped
public class UsuarioView {
	
	private String login;
	private String senha;
	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	
	public UsuarioView() {
		login = "";
		senha ="fodase";
		usuario = new Usuario();
		listaUsuarios =  new ArrayList<>();
	}


	public Usuario getUsuario() {
		
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getSalvarUsuario() {
		
		try {
			Logger.getAnonymousLogger().info("eneehehehtrou metodo salvar j");

			new UsuarioBusiness().salvarUsuario(usuario);
			FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Usuario Salvo com sucesso") );
	        usuario = new Usuario();
		} catch (Exception e) {
			Logger.getAnonymousLogger().info("deu merda"
					+ "");

			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Erro no cadastr de usuário!")); 
		}
		return "principal";
	}
	public String getBuscarUsuarioLogin() {
		String retorno = "";
		try {
			boolean result  = getLoginUsuario();
			if(result) {
				retorno = "principal";
			} else {
				FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Login não encontrado")); 

			}
			usuario = new Usuario();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return retorno;
	}
		
	public String getDeletarUsuario() {
		String result = "";
		try {
			new UsuarioBusiness().deletar(this.usuario);
			FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Usuario deletado com sucesso") );
	        listaUsuarios = new UsuarioBusiness().getUsuarios();
	        usuario = new Usuario();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Login não encontrado")); 

		}
		return result;	
	
	}
	public String getAtualizarUsuario() {
		String result = "";
		try {
			new UsuarioBusiness().atualizar(this.usuario);
			FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Usuario atualizado com sucesso") );
	        listaUsuarios = new UsuarioBusiness().getUsuarios();
	        usuario = new Usuario();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Login não encontrado")); 

		}
		return result;	
	}
	
	public boolean getLoginUsuario() {
		
		return  new UsuarioBusiness().getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
	}
	
	
	
	public List<Usuario> getListaUsuarios() {
		listaUsuarios = new UsuarioBusiness().getUsuarios();
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	 @PostConstruct
	public void init() {
		 listaUsuarios = new UsuarioBusiness().getUsuarios();
	}
	 
	
	

}
