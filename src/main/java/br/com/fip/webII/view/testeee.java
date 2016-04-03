package br.com.fip.webII.view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fip.webII.bean.Usuario;
import br.com.fip.webII.dao.UsuarioDao;
import br.com.fip.webII.util.HibernateFactory;

public class testeee {


		 public static void main(String[] args) {
			boolean result = new UsuarioDao().buscarUsuario("teste", "t");
			System.out.println(result);
	}

}
