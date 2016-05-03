package br.com.fip.webII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fip.webII.bean.Tarefa;
import br.com.fip.webII.util.HibernateFactory;

public class TarefaDao {

	private Session session;
	private Transaction trans;

	public void salvar(Tarefa tarefa) {
//		try {
//			
//			session = HibernateFactory.getSessionFactory().openSession();
//			trans = session.beginTransaction();
//			session.saveOrUpdate(tarefa);
//			trans.commit();
//			session.flush();
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trans.rollback();
//		}try {
		try{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		manager.close();

		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	

	public List<Tarefa> listar() {
		session = HibernateFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Tarefa.class);
		List<Tarefa> lista = criteria.list();
		trans = session.beginTransaction();
		trans.commit();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public boolean buscarTarefa(String tarefa) {
		boolean result = false;
		try {
			String sql = "SELECT * FROM Tarefa WHERE nome  = :tarefa";
			session = HibernateFactory.getSessionFactory().openSession();
			List<Tarefa> lista;
			lista = session.createSQLQuery(sql).addEntity(Tarefa.class).setString("descricao", tarefa).list();
			if (lista.size() > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		return result;
	}

	public void deletar(Tarefa tarefa) {
//		try {
//			session = HibernateFactory.getSessionFactory().openSession();
//			trans = session.beginTransaction();
//			session.delete(tarefa);
//			trans.commit();
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trans.rollback();
//		}
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");

			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.remove(tarefa);
			manager.getTransaction().commit();
			manager.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

	}

	public void atualizar(Tarefa tarefa) {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(tarefa);
			trans.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
}
