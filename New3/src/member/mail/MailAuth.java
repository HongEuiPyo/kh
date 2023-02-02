package member.mail;

 

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{

    PasswordAuthentication pa;
    
    public MailAuth() {
        String mail_id = "projectkhwork@gmail.com"; // Gmail ID
        String mail_pw = "qaz0987!"; // PW

        pa = new PasswordAuthentication(mail_id, mail_pw);
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return pa;

    }

}



