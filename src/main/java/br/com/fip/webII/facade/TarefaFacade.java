package br.com.fip.webII.facade;

import java.util.List;

import br.com.fip.webII.bean.Tarefa;
import br.com.fip.webII.business.TarefaBusiness;



public class TarefaFacade {
	

	public void salvar(Tarefa tarefa) {
		new TarefaBusiness().salvarTarefa(tarefa);
	}
	public void atualizar(Tarefa tarefa) {
		new TarefaBusiness().atualizar(tarefa);
	}
	public void deletar(Tarefa tarefa) {
		new TarefaBusiness().deletar(tarefa);
	}
	public List<Tarefa> listar() {
		return new TarefaBusiness().getTarefas();
	}
	public boolean getTarefa(String tarefa) {
		return new TarefaBusiness().getTarefa(tarefa);
	}
}
