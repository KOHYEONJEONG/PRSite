package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;


public class CommunityModifyService implements ICommunityService {
	//�Խ��� �� ����ó��

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key���� ���� value�� ������.

		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);
		
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");

		CommunityDao dao = new CommunityDao();
		dao.communityModify(bno,b_title,b_content);

	}

}
