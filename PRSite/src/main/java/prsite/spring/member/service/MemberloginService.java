package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.member.dao.MemberDao;

public class MemberloginService implements IMemberService {
//�α���
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao dao = new MemberDao();
		
		//�α��εǸ� true, false ��ȯ��
		boolean result = dao.memberLogin(id, pwd);
		if(result==true) {
			System.out.println("<script>alert(�α��μ���);</script>");
		}else {
			System.out.println("<script>alert(�α��ν���);</script>");
		}
		
	}

}
