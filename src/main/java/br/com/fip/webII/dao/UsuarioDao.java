package br.com.fip.webII.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fip.webII.bean.Usuario;
import br.com.fip.webII.util.HibernateFactory;

public class UsuarioDao {
	
	private Session session;
	private Transaction trans;
	
	
	public void salvar(Usuario ususario) {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.saveOrUpdate(ususario);
			trans.commit();
			session.flush();
		
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	
	public List<Usuario> listar() {
		session = HibernateFactory.getSessionFactory().openSession();
		Criteria cri = session.createCriteria(Usuario.class);
		List<Usuario> lista = cri.list();
		trans = session.beginTransaction();
		trans.commit();
		return lista;
		
	}
	
	public void remover(Usuario usuario) {
		
	}
	
	public boolean buscarUsuario(String usuario, String senha) {
		
		boolean result = false;
		try {
		String sql = "SELECT * FROM Usuario WHERE senha  = :senha and nomeUsuario = :usuario";
		session = HibernateFactory.getSessionFactory().openSession();
		List<Usuario> lista;
		lista =  session.createSQLQuery(sql).addEntity(Usuario.class).setString("senha", senha).setString("usuario", usuario).list();
		if(lista.size() > 0) {
			result = true;
		}
		} catch (Exception e) {
e.printStackTrace();
		}
		return result;
	}
	public void deletar(Usuario usuario) {
		try {
			session = HibernateFactory.getSessionFactory().getCurrentSession();
			trans = session.beginTransaction();
			session.delete(usuario);
			trans.commit();
			session.close();
			
			
		} catch (Exception e) {
			trans.rollback();
		}
	}
	public void atualizar(Usuario usuario) {
		try {
			session = HibernateFactory.getSessionFactory().getCurrentSession();
			trans = session.beginTransaction();
			session.update(usuario);
			trans.commit();
			session.close();
			
			
		} catch (Exception e) {
			trans.rollback();
		}
	}

	}


