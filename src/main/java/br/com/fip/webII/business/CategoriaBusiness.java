package br.com.fip.webII.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.fip.webII.bean.Categoria;
import br.com.fip.webII.dao.CategoriaDao;

public class CategoriaBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	public void salvarCategoria(Categoria categoria) {
		
		try {
			new CategoriaDao().salvar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Categoria> getCategorias() {
		
		List<Categoria> listaCategorias = new ArrayList<>();
		try {

			listaCategorias = new CategoriaDao().listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCategorias;
	}

	public boolean getCategoria(String categoria) {
		
		boolean result = false;
		try {
			result = new CategoriaDao().buscarCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deletar(Categoria categoria) {

		try {
			new CategoriaDao().deletar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Categoria categoria) {

		try {
			new CategoriaDao().atualizar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}