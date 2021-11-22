package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.MemberDto;
import prsite.spring.member.dao.MemberDao;

public class MemberModifyService implements IMemberService {
	//ȸ�� ���� ����

	@Override
	public void execute(Model model) {
		//map(Ű,��) , �ߺ�Ű�δ� ���� ���� ����.
		Map<String, Object>map = model.asMap();//model�� map���� ��ȯ�Ͽ� ��ü�� ����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key���� ���� value�� ������.
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String influyn = request.getParameter("influyn");
		String name = request.getParameter("name");
		
		
		MemberDto member =new  MemberDto(id ,pwd,influyn, name);
		
		MemberDao dao = new MemberDao();
		
		dao.memberUpdate(member);
		
	}

}
