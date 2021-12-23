package prsite.spring.influencer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.dto.SubscribeDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;
import prsite.spring.subscibe.dao.SubscribeDao;

public class InfluencerProfileService implements IInfluencerService {
//Iid 인플루언서 프로필 가져오기 + cat도 가져오기 연관 인플루언서 가져오기
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		System.out.println("execute : Select InfluencerID = "+ request.getParameter("Iid"));
		
		//로그인한 id
		String LoginID = (String)session.getAttribute("LoginID");
		//인플루언서 id
		String Iid = request.getParameter("Iid");		
		model.addAttribute("Iid", Iid); //인플루언서 정보
		
		// 인플루언서 정보
		InfluencerDao dao = new InfluencerDao();
		InfluencerDto dto = dao.influencerProfile(Iid);//IN버튼을 누르면 해당 인플루언서 ID가 넘어감.
	
		
		model.addAttribute("dto", dto); //인플루언서 정보
		System.out.println(dto.getId());
		System.out.println(dto.getInfo());
		System.out.println(dto.getCat());
		
		
		
		MemberDao dao2 = new MemberDao();
		MemberDto dto2 =  dao2.memberProfile(Iid);
		model.addAttribute("photo",dto2);
		
		
		//구독 상태 검사-------------------------------------------------------------
		Object isSub = new Object();
		SubscribeDao subsdao = new SubscribeDao();
		ArrayList<SubscribeDto> subslist = subsdao.subscribeList(LoginID);
		if(subslist.isEmpty()) {
			isSub = "true";
		}
		else {
			for (SubscribeDto subdto : subslist){
				System.out.println("SubscribeDto"+subdto.getInfluid());
				if(subdto.getInfluid().equals(Iid)) {
					isSub = "false";
					break;
				}
				else {
					isSub = "true";
				}
			}	
		}
		model.addAttribute("isSub",isSub);
		
		//하단-----------------------------------------------------------
		//동일 카테고리 내 추천
		ArrayList<HashMap<String, String>> hashlist = new ArrayList<HashMap<String, String>>();
		ArrayList<InfluencerDto> relcatlist =  dao.influencerRelCat(dto.getCat());
		System.out.println("category-"+dto.getCat());
		if(relcatlist.isEmpty()) {
		}
		else {
			MemberDao memdao = new MemberDao();
			for (InfluencerDto influencerDto : relcatlist) {
				HashMap<String, String> hash = new HashMap<String, String>();//key, value
				hash.put("id",influencerDto.getId());
				hash.put("info",influencerDto.getInfo());
				hash.put("name",memdao.memberName(influencerDto.getId()));
				hashlist.add(hash);
				System.out.println(influencerDto.getId());
				System.out.println(influencerDto.getInfo());
				System.out.println(memdao.memberName(influencerDto.getId()));
			}
			model.addAttribute("relcatlist", hashlist); //동일 카테고리 내 랜덤 인플루언서 정보
		}
	}

}
