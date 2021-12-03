package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.member.dao.MemberDao;

public class MemberloginService implements IMemberService {
//�α���
	private boolean result = false;
	
	public boolean getResult() {
		return result;
	}
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao dao = new MemberDao();
		
		//�α��εǸ� true, false ��ȯ��
		result = dao.memberLogin(id, pwd);
		if(result==true) {
			model.addAttribute("isLogin",true);
			model.addAttribute("LoginID",id);
			System.out.println("isLogin==" + result);
			//out.println("<script>alert(�α��μ���);</script>");
			
			HttpSession session = request.getSession();
			session.setAttribute("LoginID", id);
		}else {
			model.addAttribute("isLogin",result);
			System.out.println("isLogin==" +result);
			//out.println("<script>alert(�α��ν���);</script>");
		}
		
	}

}
