package br.com.fip.webII.util;

import java.util.Properties;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.fip.webII.bean.EmailDispatcher;

public class FormattedEmailDispatcher implements EmailDispatcher
{
    private Properties properties;

    public FormattedEmailDispatcher()
    {
    }

    public void setProperties(Properties properties) throws Exception
    {
        this.properties = properties;
    }

    public void sendEmail(String mailTo, String subject, String message, String anexo) throws IllegalArgumentException, Exception
    {
        HtmlEmail simpleEmail = null;
        
        try
        {
            simpleEmail = (HtmlEmail) this.getEmailImpl();

            String emailTo[] = mailTo.split(",");

            for (String mlTo : emailTo)
            {
                simpleEmail.addTo(mlTo);
            }
            
            simpleEmail.setSubject(subject);
            simpleEmail.setHtmlMsg(message);
            
            if(!anexo.equals("")){
                
                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath(anexo);
                
                simpleEmail.attach(attachment);
                
            }


            simpleEmail.send();
        }
        catch (EmailException emailException)
        {
            throw new IllegalArgumentException(emailException);
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            simpleEmail = null;
        }
    }

    private Email getEmailImpl() throws EmailException, Exception
    {
        if (this.properties != null)
        {
            HtmlEmail simpleEmail = new HtmlEmail();

            simpleEmail.setHostName(properties.getProperty("server.smtp.host"));
            simpleEmail.setSmtpPort(Integer.parseInt(properties.getProperty("server.smtp.port").trim()));
            simpleEmail.setSSL((Integer.parseInt(properties.getProperty("ssl.enable").trim()) == 0) ? false : true);
            simpleEmail.setTLS((Integer.parseInt(properties.getProperty("tls.enable").trim()) == 0) ? false : true);
            simpleEmail.setAuthentication(properties.getProperty("mail.from.user"),
                    properties.getProperty("mail.from.password"));
            simpleEmail.setFrom(properties.getProperty("mail.from.address"));
            
            return simpleEmail;
        }
        else
        {
            throw new Exception("Properties were not setting");
        }
    }

}
