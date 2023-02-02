package member.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
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
import javax.servlet.http.HttpSession;

import member.dto.User_info;
import member.mail.MailAuth;
import member.service.face.MemberService;
import member.service.impl.MemberServiceImpl;
import member.util.password;


@WebServlet("/kh1/login/find")
public class PassFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//MemberService 객체 생성

	private MemberService memberService = new MemberServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/kh1/login/find");
		
		//VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/login/findps.jsp").forward(req, resp);
		
		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String newEmail = password.randomPassword(8);
		
//		System.out.println( newEmail );

		// -> DB에서 데이터조회 처리
//		User_info member = new User_info();
		
		//-> Update
//		member.setUser_email(newEmail);
			
		
		String newPassword = password.randomPassword(8);
		User_info newPassUserInfo = new User_info();
		newPassUserInfo.setUser_email(req.getParameter("user_email"));
		
		newPassUserInfo.setUser_no( memberService.getUsernoByEmail(newPassUserInfo.getUser_email()) );
		newPassUserInfo.setUser_password(newPassword);
		
		//비밀번호 변경
		memberService.changePass(newPassUserInfo);
		
		//메일 발송
		Properties prop = System.getProperties();
		
		prop.put("member.mail.smtp.starttls.enable", "true");
		prop.put("member.mail.smtp.host", "smtp.gmail.com");
		prop.put("member.mail.smtp.auth", "true");
		prop.put("member.mail.smtp.port", "587");
		prop.put("member.mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new MailAuth();

		Session session = Session.getDefaultInstance(prop, auth);

		MimeMessage msg = new MimeMessage(session);
		

		
		

		try {
			
			//전달파라미터 얻기 - 메일 보낼 Email
//			User_info email = memberService.getPassword(req);
			User_info emailToRecieve = memberService.getPassword(req);
			
			//email.getAttribute("userid", session.getUser_email());
			
			
			msg.setSentDate(new Date());

            msg.setFrom(new InternetAddress("projectkhwork@gmail.com", "cocktail관리자")); // 관리자 메일
//            InternetAddress to = new InternetAddress("wnsghd@gmail.com");   // TEST - 받을 메일주소 
            InternetAddress to = new InternetAddress(emailToRecieve.getUser_email());   // TEST - 받을 메일주소 
            msg.setRecipient(Message.RecipientType.TO, to);            
            msg.setSubject("임시비밀번호", "UTF-8");            
            msg.setText("임시비밀번호는 : " + newPassword + " 입니다.", "UTF-8");            

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
		resp.sendRedirect("/kh1/login");
		
	    }
		
		
		

//		String user = "projectkhwork@gmail.com"; // ID
//      String password = "qaz0987!";   // 패스워드
//
//      // SMTP 서버 정보를 설정한다.
//      Properties prop = new Properties();
//        
//		prop.put("member.mail.smtp.starttls.enable", "true");
//		prop.put("member.mail.smtp.host", "smtp.gmail.com");
//		prop.put("member.mail.smtp.auth", "true");
//		prop.put("member.mail.smtp.port", "587");
//		prop.put("member.mail.smtp.ssl.protocols", "TLSv1.2");
//      
//
//        
//      Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
//      	protected PasswordAuthentication getPasswordAuthentication() {
//      		return new PasswordAuthentication(user, password);
//      	}
//        });
//
//        
//      try {
//		MimeMessage message = new MimeMessage(session);
//		message.setFrom(new InternetAddress(user));
//
//      //수신자메일주소
//      message.addRecipient(Message.RecipientType.TO, new InternetAddress("wnsghd@gmail.com"));  //test
//
//      //메일제목
//		message.setSubject("임시 비밀번호 메일"); //메일 제목을 입력
//
//		//내용
//      message.setText("회원님의 임시 비밀번호는 : " + newEmail +"입니다." );    //메일 내용을 입력
//
//          // send the message
//		Transport.send(message); ////전송
//		System.out.println("member.mail sent");
//            
//      } catch (AddressException e) {
//          e.printStackTrace();
//      } catch (MessagingException e) {
//          e.printStackTrace();
//        }
	

	
	

}

