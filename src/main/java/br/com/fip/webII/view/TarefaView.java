package br.com.fip.webII.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.fip.webII.bean.Tarefa;
import br.com.fip.webII.business.TarefaBusiness;
import br.com.fip.webII.facade.TarefaFacade;



public class TarefaView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tarefa tarefa = new Tarefa();
	private List<Tarefa> tarefas =new ArrayList<>();
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public String getSalvarTarefa() {

		try {
			new TarefaFacade().salvar(tarefa);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(" Tarefa salva com sucesso! "));
			tarefa = new Tarefa();
			tarefas = new TarefaBusiness().getTarefas();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro da tarefa!"));
		}
		return "principal";
	}

	public String getDeletarTarefa() {
		String result = "";
		try {
			new TarefaFacade().deletar(this.tarefa);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Tarefa deletada com sucesso!"));
			tarefas = new TarefaFacade().listar();
			tarefa = new Tarefa();
			tarefas = new TarefaFacade().listar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Tarefa não encontrada!"));

		}
		return result;
	}

	public String getAtualizarTarefa() {
		String result = "";
		try {
			new TarefaFacade().atualizar(this.tarefa);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Tarefa atualizado com sucesso!"));
			tarefas = new TarefaFacade().listar();
			tarefa = new Tarefa();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Tarefa não encontrado"));

		}
		return result;
	}

	public List<Tarefa> getListaTarefas() {
		tarefas = new TarefaFacade().listar();
		return tarefas;
	}

	public void setListaTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@PostConstruct
	public void init() {
		tarefas = new TarefaFacade().listar();
	}
	
}
