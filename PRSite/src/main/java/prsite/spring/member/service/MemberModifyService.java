package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.MemberDto;
import prsite.spring.member.dao.MemberDao;

public class MemberModifyService implements IMemberService {
	//회원 정보 수정

	@Override
	public void execute(Model model) {
		//map(키,값) , 중복키로는 값을 정의 못함.
		Map<String, Object>map = model.asMap();//model을 map으로 변환하여 객체를 저장.

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key값을 통해 value를 가져옴.
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String influyn = request.getParameter("influyn");
		String name = request.getParameter("name");
		
		
		MemberDto member =new  MemberDto(id ,pwd,influyn, name);
		
		MemberDao dao = new MemberDao();
		
		dao.memberUpdate(member);
		
	}

}
