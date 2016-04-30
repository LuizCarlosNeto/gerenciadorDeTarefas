package br.com.fip.webII.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fip.webII.util.HibernateFactory;

public abstract class GenericDao {

	
	public abstract void salvar(Object object);
	public abstract void deletar(Object object);
		
		
	
	
}
