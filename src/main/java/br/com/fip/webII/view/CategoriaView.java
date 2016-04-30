package br.com.fip.webII.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fip.webII.bean.Categoria;
import br.com.fip.webII.business.CategoriaBusiness;
import br.com.fip.webII.facade.CategoriaFacade;

@ManagedBean
@SessionScoped
public class CategoriaView  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Categoria categoria = new Categoria();
	private List<Categoria> categorias =new ArrayList<>();
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getSalvarCategoria() {

		try {
			new CategoriaFacade().salvar(categoria);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(" Categoria salva com sucesso! "));
			categoria = new Categoria();
			categorias = new CategoriaBusiness().getCategorias();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro da categoria!"));
		}
		return "principal";
	}

	public String getDeletarCategoria() {
		String result = "";
		try {
			new CategoriaFacade().deletar(this.categoria);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Categoria deletada com sucesso!"));
			categorias = new CategoriaFacade().listar();
			categoria = new Categoria();
			categorias = new CategoriaFacade().listar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Categoria não encontrada!"));

		}
		return result;
	}

	public String getAtualizarUsuario() {
		String result = "";
		try {
			new CategoriaFacade().atualizar(this.categoria);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Categoria atualizado com sucesso!"));
			categorias = new CategoriaFacade().listar();
			categoria = new Categoria();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login não encontrado"));

		}
		return result;
	}

	public List<Categoria> getListaCategorias() {
		categorias = new CategoriaFacade().listar();
		return categorias;
	}

	public void setListaUsuarios(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@PostConstruct
	public void init() {
		categorias = new CategoriaFacade().listar();
	}

}