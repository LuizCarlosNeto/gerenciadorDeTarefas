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
			new CategoriaBusiness().salvarCategoria(categoria);
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
			new CategoriaBusiness().deletar(this.categoria);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Categoria deletada com sucesso!"));
			categorias = new CategoriaBusiness().getCategorias();
			categoria = new Categoria();
			categorias = new CategoriaBusiness().getCategorias();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Categoria não encontrada!"));

		}
		return result;
	}

	public String getAtualizarUsuario() {
		String result = "";
		try {
			new CategoriaBusiness().atualizar(this.categoria);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Categoria atualizado com sucesso!"));
			categorias = new CategoriaBusiness().getCategorias();
			categoria = new Categoria();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login não encontrado"));

		}
		return result;
	}

	public List<Categoria> getListaCategorias() {
		categorias = new CategoriaBusiness().getCategorias();
		return categorias;
	}

	public void setListaUsuarios(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@PostConstruct
	public void init() {
		categorias = new CategoriaBusiness().getCategorias();
	}

}