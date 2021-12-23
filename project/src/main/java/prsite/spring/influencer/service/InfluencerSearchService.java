package prsite.spring.influencer.service;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class InfluencerSearchService implements IInfluencerService {
//인플루언서 검색
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model객체를 map형태로 바꿈
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String search =  request.getParameter("search");//인플루언서 ID

		System.out.println("-----------검색-------------");
		
		InfluencerDao influencerDao =  new InfluencerDao();
		
		InfluencerDto influencerDto = influencerDao.influencerSearch(search);
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.memberProfile(search);
		
		if(influencerDto.equals(null)) {
			System.out.println("찾는 인플루언서가 없습니다.");
			return;
		}else {
			model.addAttribute("Iid", influencerDto.getId());
		}
		
		
	}

}
