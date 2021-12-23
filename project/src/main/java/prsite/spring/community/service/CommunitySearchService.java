package prsite.spring.community.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;

public class CommunitySearchService implements ICommunityService {
//�Խñ� ���� �˻�
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();//model�� map���� ��ȯ�Ͽ� ��ü�� ����.

		//ĳ���� �ʼ�(String���� ����ȯ)

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key���� ���� value�� ������.
		
		String b_title = request.getParameter("b_title");
		
		CommunityDao comunityDao = new CommunityDao();
		ArrayList<CommunityDto> dtos = comunityDao.communitySearch(b_title);
		model.addAttribute("search_title", dtos);
	}

}
