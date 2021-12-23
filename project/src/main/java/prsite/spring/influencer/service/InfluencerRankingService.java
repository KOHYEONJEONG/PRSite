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
				
		InfluencerDao dao = new InfluencerDao();
		ArrayList<InfluencerDto> dtos = dao.influencerInstaRanking();
		System.out.println("------------�ν�Ÿ��ŷ----------------");
		model.addAttribute("Instar", dtos);
		
		
		
		ArrayList<InfluencerDto> dtos2 = dao.influencerYtbRanking();
		System.out.println("-----------����Ʈ��ŷ---------------");
		model.addAttribute("Youtube", dtos2);
	}

}
