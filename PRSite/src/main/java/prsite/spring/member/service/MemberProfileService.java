package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class MemberProfileService implements IMemberService {
//ȸ�� ���� ��������
	
	@Override
	public void execute(Model model) {
	
		Map<String, Object>map = model.asMap();//model�� map���·� ��ȯ�ؼ� ��ü�� �����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.memberProfile("influencer2");
		
		model.addAttribute("userProfile",dto);
		System.out.println("MemberDao addAttribute");
		
		
		if(dto.getInfluyn().equals("y")) {
			System.out.println("dto.getInfluyn().equals(\"y\") " + dto.getInfluyn());
			InfluencerDao influencerdao = new InfluencerDao();
			InfluencerDto influencerdto = influencerdao.influencerProfile("influencer2");
			
			model.addAttribute("influencerProfile",influencerdto);
			System.out.println("InfluencerDao addAttribute");
		}
		
	}

}
