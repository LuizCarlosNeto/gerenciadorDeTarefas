package br.com.fip.webII.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.fip.webII.bean.Tarefa;
import br.com.fip.webII.dao.TarefaDao;

public class TarefaBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	

	public void salvarTarefa(Tarefa tarefa) {
		
		try {
			new TarefaDao().salvar(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Tarefa> getTarefas() {
		
		List<Tarefa> listaTarefas = new ArrayList<>();
		try {

			listaTarefas = new TarefaDao().listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTarefas;
	}

	public boolean getTarefa(String tarefa) {
		
		boolean result = false;
		try {
			result = new TarefaDao().buscarTarefa(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deletar(Tarefa tarefa) {

		try {
			new TarefaDao().deletar(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Tarefa tarefa) {

		try {
			new TarefaDao().atualizar(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
