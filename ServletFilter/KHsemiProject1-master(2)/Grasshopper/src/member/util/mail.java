package member.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {

	public static void main(String[] args) {

	String mailProtocol = "smtp";
	String mailHost = "smtp.gmail.com";
	String mailPort = "587";
	String mailId = "abc@gmail.com"; // 구글계정
	String mailPassword = "abc"; // 구글계정 비밀번호 

	String fromName = "보내는사람이름";
	String fromEmail = "abc@gmail.com"; // 보내는 사람 메일
	String toName = "받는사람이름";
	String toEmail = "abc@daum.net"; // 받는사람메일
	String mailTitle = "메일 타이틀입니다.";
	String mailContents = "메일 내용입니다.";
	String debugMode = "false";
	String authMode = "true";

	 
	try {

	 
	boolean debug = Boolean.valueOf(debugMode).booleanValue();

	Properties mailProps = new Properties();

	mailProps.put("member.mail.smtp.starttls.enable", "true");

	mailProps.setProperty("member.mail.transport.protocol", mailProtocol); 

	mailProps.put("member.mail.debug", debugMode);

	mailProps.put("member.mail.smtp.host", mailHost);

	mailProps.put("member.mail.smtp.port", mailPort);

	mailProps.put("member.mail.smtp.connectiontimeout", "5000");

	mailProps.put("member.mail.smtp.timeout", "5000");  

	mailProps.put("member.mail.smtp.auth", authMode);

	 

	Session msgSession = null;

	if(authMode.equals("true")) {

	        Authenticator auth = new MyAuthentication(mailId, mailPassword);

	msgSession = Session.getInstance(mailProps, auth);

	} else {

	msgSession = Session.getInstance(mailProps, null); 

	}

	 

	msgSession.setDebug(debug);

	 

	MimeMessage msg = new MimeMessage(msgSession);

	msg.setFrom(new InternetAddress(fromEmail, fromName));

	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, toName));

	msg.setSubject(mailTitle);

	msg.setContent(mailContents, "text/html; charset=euc-kr");

	 

	// 스태틱함수로 직접 보내지 않고 객체를 이용해서 보내고 객체를 닫아준다. 

	Transport t = msgSession.getTransport(mailProtocol);

	try {

	t.connect();

	t.sendMessage(msg, msg.getAllRecipients());

	} finally {

	  t.close();

	}

	  

	} catch(Exception e) {

	e.printStackTrace();

	}

	}

	 

	}

	 

	class MyAuthentication extends Authenticator {

	    PasswordAuthentication pa;

	    public MyAuthentication(String mailId, String mailPass) {

	        pa = new PasswordAuthentication(mailId, mailPass);  

	    }

	    public PasswordAuthentication getPasswordAuthentication() {

	        return pa;

	    }

	
}
