package prsite.spring.influencer.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerRankingService implements IInfluencerService {
//���÷�� ��ŷ ��������
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		InfluencerDao dao = new InfluencerDao();

		ArrayList<InfluencerDto> dtos = dao.influencerRanking();
		
		model.addAttribute("ranking", dtos);
	}

}
