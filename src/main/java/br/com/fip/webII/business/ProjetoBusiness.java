package br.com.fip.webII.business;

import java.util.ArrayList;
import java.util.List;

import br.com.fip.webII.bean.Categoria;
import br.com.fip.webII.bean.Projeto;
import br.com.fip.webII.dao.CategoriaDao;
import br.com.fip.webII.dao.ProjetoDao;

public class ProjetoBusiness {

public void salvarProjeto(Projeto projeto) {
		
		try {
			new ProjetoDao().salvar(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Projeto> getProjetos() {
		
		List<Projeto> listaProjetos = new ArrayList<>();
		try {

			listaProjetos = new ProjetoDao().listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProjetos;
	}

	public boolean getProjeto(String projeto) {
		
		boolean result = false;
		try {
			result = new ProjetoDao().buscarProjeto(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deletar(Projeto projeto) {

		try {
			new ProjetoDao().deletar(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Projeto projeto) {

		try {
			new ProjetoDao().atualizar(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
