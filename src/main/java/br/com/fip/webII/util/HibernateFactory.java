package br.com.fip.webII.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.fip.webII.bean.Usuario;
 
public class HibernateFactory {
 
    // Cria objeto da sessão
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    // Constroi sessão
    private static SessionFactory buildSessionFactory() {
        try {
            // buildSessionFactory não será utilizado em versões superiores
            // Veremos outros métodos para criar um Factory
            // Não é necessário incluir o "hibernate.cfg.xml" no configure()
            // Incluímos somente a nível de fácil entendimento da chamada da configuração.
            // Você pode retirar a chamada
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Em caso de erro
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    // Retorna Factory da sessão
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    // Encerra Sessão
    public static void shutdown() {
        getSessionFactory().close();
    }
    
   
	

	

 
}