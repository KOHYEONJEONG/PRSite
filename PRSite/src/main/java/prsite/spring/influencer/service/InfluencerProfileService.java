package prsite.spring.influencer.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerProfileService implements IInfluencerService {
//인플루언서 프로필 가져오기
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		InfluencerDao dao = new InfluencerDao();
		
		String ino = request.getParameter("in_no");
		
		InfluencerDto dto = dao.influencerProfile(ino);

		
	}

}
