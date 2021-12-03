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
		String Iid = request.getParameter("Iid");//선택한 인플루언서 ID
		/*
		String Iid = request.getParameter("Iid");//선택한 인플루언서 ID
		if(Iid==null) {
			System.out.println("Select InfluencerID = null");
		}
		else {
			System.out.println("Select InfluencerID = "+Iid);
		}*/
		
		InfluencerDao dao = new InfluencerDao();
		InfluencerDto dto = dao.influencerProfile(Iid);//IN버튼을 누르면 해당 인플루언서 ID가 넘어감.
	
		model.addAttribute("dto", dto);
		
	}

}
