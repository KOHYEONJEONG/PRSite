package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.member.dao.MemberDao;

public class MemberloginService implements IMemberService {
//로그인
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao dao = new MemberDao();
		
		//로그인되면 true, false 반환됨
		boolean result = dao.memberLogin(id, pwd);
		if(result==true) {
			System.out.println("<script>alert(로그인성공);</script>");
		}else {
			System.out.println("<script>alert(로그인실패);</script>");
		}
		
	}

}
