package member.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.User_info;
import member.mail.MailAuth;
import member.service.face.MemberService;
import member.service.impl.MemberServiceImpl;


@WebServlet("/kh1/admin/email")
public class AdminMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/kh1/admin/email [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/email.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("POST TEST");
		
		User_info userEmail = new User_info();
		userEmail.setUser_email(req.getParameter("user_email"));
		
		userEmail.setUser_no( memberService.getUsernoByEmail(userEmail.getUser_email()) );
//		userEmail.setUser_email();
		
		
		
		/*
		 * List<String> emailList = new ArrayList<>(); for(int i=0; i<jsonArr.length();
		 * i++) {
		 * 
		 * }
		 */
		

	


		
//		System.out.println(jstr);
		
		
			
		//메일 발송
		Properties prop = System.getProperties();
				
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new MailAuth();

		Session session = Session.getDefaultInstance(prop, auth);

		MimeMessage msg = new MimeMessage(session);
				

				
				

		try {
					
			//전달파라미터 얻기 - 메일 보낼 Email
			User_info emailToRecieve = memberService.getEmail(req);
					
						
				
			msg.setSentDate(new Date());

		    msg.setFrom(new InternetAddress("projectkhwork@gmail.com", "cocktail관리자")); // 관리자 메일
		    InternetAddress to = new InternetAddress("wnsghd@gmail.com");   // TEST - 받을 메일주소 
//		    InternetAddress to = new InternetAddress(emailToRecieve.getUser_email());   // TEST - 받을 메일주소 
		    msg.setRecipient(Message.RecipientType.TO, to);            
		    msg.setSubject("Title Test", "UTF-8");            
		    msg.setText("Main test");            

		    System.out.println("메일 발송");
		            
		    Transport.send(msg);

			} catch(AddressException ae) {            
				System.out.println("AddressException : " + ae.getMessage());           
			} catch(MessagingException me) {            
				System.out.println("MessagingException : " + me.getMessage());
			} catch(UnsupportedEncodingException e) {
			    System.out.println("UnsupportedEncodingException : " + e.getMessage());
			}
			            
				
		//로그인페이지로 리다이렉트
//		resp.sendRedirect("/kh1/login");
				
		}
	
	

}
	
	


