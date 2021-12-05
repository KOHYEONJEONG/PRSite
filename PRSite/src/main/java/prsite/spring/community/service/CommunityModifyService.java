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
		
		String b_title = request.getParameter("title");
		String b_content = request.getParameter("content");

		CommunityDao dao = new CommunityDao();
		dao.communityModify(bno,b_title,b_content);
		

		String id = request.getParameter("id");//�ۼ���
		
		//�������ڸ��� content_view�� ����������
		model.addAttribute("id", id);
		model.addAttribute("b_no", b_no);
		
		
		System.out.println("�Խñ� ���� �Ϸ�--- communityModify");

	}

}
