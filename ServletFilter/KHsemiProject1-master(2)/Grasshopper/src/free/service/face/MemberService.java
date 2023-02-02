package free.service.face;

import javax.servlet.http.HttpServletRequest;

import free.dto.User_info;

public interface MemberService {
	
	public boolean login(User_info member);

	public User_info getLoginMember(HttpServletRequest req);

	public User_info info(User_info member);
	
}
