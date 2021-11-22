package prsite.spring.community.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;

public class CommunityListService implements ICommunityService {
//�Խ��� ����Ʈ ��������
	
	@Override
	public void execute(Model model) {
		
		CommunityDao comunityDao = new CommunityDao();
		
		ArrayList<CommunityDto> dtos = comunityDao.communitylist();
		
		model.addAttribute("list", dtos);

	}

}
