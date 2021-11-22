package prsite.spring.community.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;

public class CommunitySearchService implements ICommunityService {
//게시글 제목 검색
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();//model을 map으로 변환하여 객체를 저장.

		//캐스팅 필수(String으로 형변환)

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key값을 통해 value를 가져옴.
		
		String b_title = request.getParameter("b_title");
		
		CommunityDao comunityDao = new CommunityDao();
		ArrayList<CommunityDto> dtos = comunityDao.communitySearch(b_title);
		model.addAttribute("search_title", dtos);
	}

}
