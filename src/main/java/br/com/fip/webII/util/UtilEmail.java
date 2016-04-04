package br.com.fip.webII.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.fip.webII.bean.EmailDispatcher;

public class UtilEmail {

	
	
	public void enviarEmail(String conteudo) {
        try {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/email.properties"));

        if (properties.getProperty("system.notification.enable").equals("1")) {
            String subject = properties.getProperty("mail.subject");
            EmailDispatcher emailDispatcher = new FormattedEmailDispatcher();
            emailDispatcher.setProperties(properties);
            if (conteudo != null) {
                emailDispatcher.sendEmail(properties.getProperty("mail.from.destination"), properties.getProperty("mail.assunto"), conteudo, "");

            } else {
                emailDispatcher.sendEmail(properties.getProperty("mail.from.destination"), properties.getProperty("mail.assunto"), properties.getProperty("mail.conteudo"), "");

            }
        }
    }catch(Exception e) {
        e.printStackTrace();
    }
    }
	public static void main(String[] args) {
		try {
			new UtilEmail().enviarEmail("teste");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
