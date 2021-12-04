package prsite.spring.member.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.dto.SubscribeDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;
import prsite.spring.subscibe.dao.SubscribeDao;

public class MemberProfileService implements IMemberService {
	
//회원 정보 가져오기, 구독한 인플루언서 가져오기(수정해야함)
	
	@Override
	public void execute(Model model) {
	
		Map<String, Object>map = model.asMap();//model을 map형태로 변환해서 객체를 담아줌.

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("LoginID");
		
		System.out.println("==========MemberProfileService===========" );
		System.out.println("id==" + id);
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.memberProfile(id);
		
		model.addAttribute("userProfile",dto);
		System.out.println("MemberDao addAttribute");
		
		
		//내가 구독한 인플루언서 뜨게
		String isEmpty="false";
		SubscribeDao Sdao = new SubscribeDao();
		ArrayList<SubscribeDto> dtos =Sdao.subscribeList(id);
		model.addAttribute("SubInsfluenser", dtos);
		System.out.println("SubscribeDao addAttribute");
		if(dtos.isEmpty()) {
			isEmpty = "true";
		}
		else {
			isEmpty = "false";
		}
		System.out.println("SubscribeDao isEmpty=" + isEmpty);
		
		//인플루언서는 'y'라디오 선택해야지만 내용을불러옴
		if(dto.getInfluyn().equals("y")) {
			System.out.println("dto.getInfluyn().equals(\"y\") " + dto.getInfluyn());
			InfluencerDao influencerdao = new InfluencerDao();
			InfluencerDto influencerdto = influencerdao.influencerProfile(id);
			
			model.addAttribute("influencerProfile",influencerdto);
			System.out.println("InfluencerDao addAttribute");
		}
		
	}

	@Override
	public boolean getResult() {
		// TODO Auto-generated method stub
		return false;
	}

}
