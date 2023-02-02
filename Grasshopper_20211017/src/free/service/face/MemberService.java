package free.service.face;

import javax.servlet.http.HttpServletRequest;

import free.dto.Member;

public interface MemberService {
	
	public boolean login(Member member);

	public Member getLoginMember(HttpServletRequest req);

	public Member info(Member member);
	
}
