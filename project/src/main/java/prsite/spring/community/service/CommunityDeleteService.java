package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;

public class CommunityDeleteService implements ICommunityService {
//�Խ���  �� ���� ó��
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model��ü�� map���·� �ٲ�

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);

		CommunityDao dao = new CommunityDao();

		dao.communityDelete(bno);
		

	}

}
