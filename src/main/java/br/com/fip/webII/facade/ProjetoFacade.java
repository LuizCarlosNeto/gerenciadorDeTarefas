package br.com.fip.webII.facade;

import java.util.List;

import br.com.fip.webII.bean.Projeto;
import br.com.fip.webII.business.CategoriaBusiness;
import br.com.fip.webII.business.ProjetoBusiness;

public class ProjetoFacade {


	public void salvar(Projeto projeto) {
		new ProjetoBusiness().salvarProjeto(projeto);
	}
	public void atualizar(Projeto categoria) {
		new ProjetoBusiness().atualizar(categoria);
	}
	public void deletar(Projeto categoria) {
		new ProjetoBusiness().deletar(categoria);
	}
	public List<Projeto> listar() {
		return new ProjetoBusiness().getProjetos();
	}
	public boolean getProjeto(String projeto) {
		return new ProjetoBusiness().getProjeto(projeto);
	}
}
