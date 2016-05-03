package br.com.fip.webII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fip.webII.bean.Projeto;
import br.com.fip.webII.bean.Tarefa;
import br.com.fip.webII.util.HibernateFactory;

public class ProjetoDao {

	private Session session;
	private Transaction trans;

	public void salvar(Projeto projeto) {
//		try {
//			
//			session = HibernateFactory.getSessionFactory().openSession();
//			trans = session.beginTransaction();
//			session.saveOrUpdate(projeto);
//			trans.commit();
//			session.flush();
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			trans.rollback();
//		}
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");

			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.persist(projeto);
			manager.getTransaction().commit();
			manager.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Projeto> listar() {
		session = HibernateFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Projeto.class);
		List<Projeto> lista = criteria.list();
		trans = session.beginTransaction();
		trans.commit();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public boolean buscarProjeto(String projeto) {
		boolean result = false;
		try {
			String sql = "SELECT * FROM projeto WHERE nome  = :projeto";
			session = HibernateFactory.getSessionFactory().openSession();
			List<Tarefa> lista;
			lista = session.createSQLQuery(sql).addEntity(Tarefa.class).setString("descricao", projeto).list();
			if (lista.size() > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		return result;
	}

	public void deletar(Projeto projeto) {
//		try {
//			session = HibernateFactory.getSessionFactory().openSession();
//			trans = session.beginTransaction();
//			session.delete(projeto);
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
			manager.remove(projeto);
			manager.getTransaction().commit();
			manager.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	public void atualizar(Projeto projeto) {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(projeto);
			trans.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
}
