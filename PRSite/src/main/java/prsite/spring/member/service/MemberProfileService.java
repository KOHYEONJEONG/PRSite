package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.MemberDto;
import prsite.spring.member.dao.MemberDao;

public class MemberProfileService implements IMemberService {
//ȸ�� ���� ��������
	
	@Override
	public void execute(Model model) {
	
		Map<String, Object>map = model.asMap();//model�� map���·� ��ȯ�ؼ� ��ü�� �����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.memberProfile(id);
		
		model.addAttribute("userProfile",dto);
		
		
	}

}
