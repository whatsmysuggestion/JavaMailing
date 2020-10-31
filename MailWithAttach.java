import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailWithAttach {
   public static void main(String[] args) {
   
      String to = "akash5995@gmail.com";

     
      String from = "lymujava0903@gmail.com";

      final String username = "lymujava0903@gmail.com"; 
      final String password = "javalymu&0903"; 

 
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");

    
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
 
         Message message = new MimeMessage(session);         
         message.setFrom(new InternetAddress(from));    
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

   
         message.setSubject("MAil Attach");

 
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("Attachment Body");
         Multipart multipart = new MimeMultipart();
          multipart.addBodyPart(messageBodyPart);

         
         messageBodyPart = new MimeBodyPart();
         String filename = "D:\\dummy\\a.pdf";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName("fileAttachmentName.pdf");
         multipart.addBodyPart(messageBodyPart);

       
         message.setContent(multipart);

     
         Transport.send(message);

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}