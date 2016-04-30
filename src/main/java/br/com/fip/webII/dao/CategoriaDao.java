package br.com.fip.webII.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fip.webII.bean.Categoria;
import br.com.fip.webII.util.HibernateFactory;

public class CategoriaDao {

	private Session session;
	private Transaction trans;

	public void salvar(Categoria categoria) {
		try {
			
			session = HibernateFactory.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.saveOrUpdate(categoria);
			trans.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}

	}

	public List<Categoria> listar() {
		session = HibernateFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Categoria.class);
		List<Categoria> lista = criteria.list();
		trans = session.beginTransaction();
		trans.commit();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public boolean buscarCategoria(String categoria) {
		boolean result = false;
		try {
			String sql = "SELECT * FROM Categoria WHERE nome  = :categoria";
			session = HibernateFactory.getSessionFactory().openSession();
			List<Categoria> lista;
			lista = session.createSQLQuery(sql).addEntity(Categoria.class).setString("nome", categoria).list();
			if (lista.size() > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		return result;
	}

	public void deletar(Categoria categoria) {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(categoria);
			trans.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public void atualizar(Categoria categoria) {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(categoria);
			trans.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
}