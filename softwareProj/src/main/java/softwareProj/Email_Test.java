package softwareProj;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class Email_Test {
    
	String messageHeader  ;
	String messageContent ;
	String emailToContact ; 
    public void sendEmail(String subject, String message, String recipientEmail) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator("gazafitnessgymsystem@gmail.com", System.getenv("GYM_SMTP_APP_PASSWORD")));
            email.setStartTLSRequired(true);
            email.setFrom("gazafitnessgymsystem@gmail.com");
            email.addTo(recipientEmail);  
            email.setSubject(subject);    
            email.setMsg(message);        
            
            email.send();  
            System.out.println("Email sent successfully!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
    public void sendEmailWithAttachment(String subject, String message, String recipientEmail, String attachmentFilePath, String attachmentName) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator("gazafitnessgymsystem@gmail.com", System.getenv("GYM_SMTP_APP_PASSWORD")));
            email.setStartTLSRequired(true);
            email.setFrom("gazafitnessgymsystem@gmail.com");
            email.addTo(recipientEmail);  
            email.setSubject(subject);    
            email.setMsg(message);        

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(attachmentFilePath);
            attachment.setName(attachmentName);
            email.attach(attachment);

            email.send();  
            System.out.println("Email with attachment sent successfully!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}

   

