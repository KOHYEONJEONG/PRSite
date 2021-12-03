package prsite.spring.influencer.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerRankingService implements IInfluencerService {
//인플루언서 랭킹 가져오기
	
	@Override
	public void execute(Model model) {
				
		InfluencerDao dao = new InfluencerDao();
		ArrayList<InfluencerDto> dtos = dao.influencerInstaRanking();
		System.out.println("------------인스타랭킹----------------");
		model.addAttribute("Instar", dtos);
		
		
		
		ArrayList<InfluencerDto> dtos2 = dao.influencerYtbRanking();
		System.out.println("-----------유뷰트랭킹---------------");
		model.addAttribute("Youtube", dtos2);
	}

}
