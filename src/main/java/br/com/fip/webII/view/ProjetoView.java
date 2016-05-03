package br.com.fip.webII.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.fip.webII.bean.Categoria;
import br.com.fip.webII.bean.Projeto;
import br.com.fip.webII.business.CategoriaBusiness;
import br.com.fip.webII.business.ProjetoBusiness;
import br.com.fip.webII.facade.CategoriaFacade;
import br.com.fip.webII.facade.ProjetoFacade;

public class ProjetoView {
	
	private Projeto projeto = new Projeto();
	private List<Projeto> projetos =new ArrayList<>();
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getSalvarProjeto() {

		try {
			new ProjetoFacade().salvar(projeto);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(" Projeto salva com sucesso! "));
			projeto = new Projeto();
			projetos = new ProjetoBusiness().getProjetos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro do Projeto!"));
		}
		return "principal";
	}

	public String getDeletarProjeto() {
		String result = "";
		try {
			new ProjetoFacade().deletar(this.projeto);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Projeto deletada com sucesso!"));
			projetos = new ProjetoFacade().listar();
			projeto = new Projeto();
			projetos = new ProjetoFacade().listar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Projeto não encontrada!"));

		}
		return result;
	}

	public String getAtualizarUsuario() {
		String result = "";
		try {
			new ProjetoFacade().atualizar(this.projeto);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Projeto atualizado com sucesso!"));
			projetos = new ProjetoFacade().listar();
			projeto = new Projeto();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login não encontrado"));

		}
		return result;
	}

	public List<Projeto> getListaProjetos() {
		projetos = new ProjetoFacade().listar();
		return projetos;
	}

	public void setListaUsuarios(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@PostConstruct
	public void init() {
		projetos = new ProjetoFacade().listar();
	}

}

