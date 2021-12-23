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
//���÷�� �˻�
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model��ü�� map���·� �ٲ�
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String search =  request.getParameter("search");//���÷�� ID

		System.out.println("-----------�˻�-------------");
		
		InfluencerDao influencerDao =  new InfluencerDao();
		
		InfluencerDto influencerDto = influencerDao.influencerSearch(search);
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.memberProfile(search);
		
		if(influencerDto.equals(null)) {
			System.out.println("ã�� ���÷�𼭰� �����ϴ�.");
			return;
		}else {
			model.addAttribute("Iid", influencerDto.getId());
		}
		
		
	}

}
