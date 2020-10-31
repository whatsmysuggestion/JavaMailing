import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
 


public class mail {

public static final String MAIL_SERVER = "smtp.gmail.com";
public static final String USERNAME = "lymujava0903@gmail.com";
public static final String PASSWORD = "javalymu&0903";

public void mail_send(String a,String b)
{
try {
String fromAddress = a;
String toAddress = b;
String subject = "This is a Warning Message";
String message = "Your Card Has been Hacked";

Properties properties = System.getProperties();
properties.put("mail.smtps.host", MAIL_SERVER);
properties.put("mail.smtps.auth", "true");

Session session = Session.getInstance(properties);
MimeMessage msg = new MimeMessage(session);

msg.setFrom(new InternetAddress(fromAddress));
msg.addRecipients(Message.RecipientType.BCC, toAddress);
msg.setSubject(subject);
msg.setText(message);

Transport tr = session.getTransport("smtps");
tr.connect(MAIL_SERVER, USERNAME, PASSWORD);
tr.sendMessage(msg, msg.getAllRecipients());
tr.close();
} catch (AddressException ex) {
System.out.println(ex.getMessage());
} catch (MessagingException ex) {
System.out.println(ex.getMessage());
}



}


public static void main(String ar[])
{

new mail().mail_send("lymujava0903@gmail.com","akash5995@gmail.com");
}
}