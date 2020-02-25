package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import persistence.DBManager;
import persistence.Dao;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 

@WebServlet("/LostUsername")
public class lostUsername extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void emailSender(String email) {
    	
    	
    	/*	importare mail.jar e activation.jar per farlo funzionare
         * 
         * 				SEND EMAIL IN JAVA BY Rocchicedo :D
         *  
         *  scaricabili dal sito di oracle o nel WEBBE in generale
         */
        
    	Cliente  user = DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByEmail(email);

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "sarella979797@gmail.com";//
        final String password = "*Francesco1.,";
        try{
        	Session session = Session.getDefaultInstance(props, 
                                new Authenticator(){
                                   protected PasswordAuthentication getPasswordAuthentication() {
                                      return new PasswordAuthentication(username, password);
                                   }});

        		Message msg = new MimeMessage(session);

        		msg.setFrom(new InternetAddress("sarella979797@gmail.com"));
        		msg.setRecipients(Message.RecipientType.TO, 
                            InternetAddress.parse(email,false));
        		msg.setSubject("recupero username:)");
        		msg.setText("Ciao, Siamo l'agriturismo Sarella,questo è il tuo username: "+user.getUsername());
        		msg.setSentDate(new Date());
        		Transport.send(msg);
        		System.out.println("Messaggio inviato correttamente.");

        }catch (MessagingException e){ System.out.println("Errore d'invio, causa:" + e);}
    }
	
	//TODO
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	try {
    		String email = request.getParameter("email");
	        emailSender(email);
	        response.setStatus(201);

    	} catch(Exception e) {
    		response.setStatus(500);
    	}
    
    }
}