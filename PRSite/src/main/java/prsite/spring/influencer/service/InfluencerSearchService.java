package prsite.spring.influencer.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerSearchService implements IInfluencerService {
//인플루언서 검색
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model객체를 map형태로 바꿈

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String search =  request.getParameter("search");
		
		InfluencerDao influencerDao =  new InfluencerDao();
		
		InfluencerDto influencerDto = influencerDao.influencerSearch(search);
		
		model.addAttribute("newlist", influencerDto);
		
	}

}
