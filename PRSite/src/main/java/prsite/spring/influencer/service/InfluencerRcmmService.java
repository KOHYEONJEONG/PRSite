package prsite.spring.influencer.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerRcmmService implements IInfluencerService {
//인플루언서 구독자수 추천
	
	@Override
	public void execute(Model model) {
		InfluencerDao influencerDao =  new InfluencerDao();
		ArrayList<InfluencerDto> dtos = influencerDao.influencerRcmm();
		model.addAttribute("rcmmlist", dtos);

	}

}
