package br.com.fip.webII.bean;

import java.util.Properties;

public interface EmailDispatcher {
    /**
     * Configura o objeto EmailDispatcher.
     * @param prop Propriedades de Configuração.
     * @throws java.lang.Exception
     */
    void setProperties(Properties prop) throws Exception;

    /**
     * Envia um email.
     * @param mailTo Endereço de email do Destinatário.
     * @param subject Assunto da Mensagem.
     * @param message Mensagem a ser enviada.
     * @throws java.lang.Exception Caso as Propriedades de Configuração não foram enviadas ao objeto.
     * @throws java.lang.IllegalArgumentException Caso os argumentos recebidos pelo método sejam incorretos.
     */
    void sendEmail(String mailTo, String subject, String message, String anexo) throws IllegalArgumentException, Exception;
}
