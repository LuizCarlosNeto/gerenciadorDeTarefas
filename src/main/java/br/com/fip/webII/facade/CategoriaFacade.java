package br.com.fip.webII.facade;

import java.util.List;

import br.com.fip.webII.bean.Categoria;
import br.com.fip.webII.business.CategoriaBusiness;

public class CategoriaFacade  {

	
	public void salvar(Categoria categoria) {
		new CategoriaBusiness().salvarCategoria(categoria);
	}
	public void atualizar(Categoria categoria) {
		new CategoriaBusiness().atualizar(categoria);
	}
	public void deletar(Categoria categoria) {
		new CategoriaBusiness().deletar(categoria);
	}
	public List<Categoria> listar() {
		return new CategoriaBusiness().getCategorias();
	}
	public boolean getCategoria(String categoria) {
		return new CategoriaBusiness().getCategoria(categoria);
	}
}
