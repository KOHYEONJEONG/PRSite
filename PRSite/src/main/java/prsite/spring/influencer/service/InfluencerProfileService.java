package prsite.spring.influencer.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerProfileService implements IInfluencerService {
//���÷�� ������ ��������
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String Iid = request.getParameter("Iid");//������ ���÷�� ID
		/*
		String Iid = request.getParameter("Iid");//������ ���÷�� ID
		if(Iid==null) {
			System.out.println("Select InfluencerID = null");
		}
		else {
			System.out.println("Select InfluencerID = "+Iid);
		}*/
		
		InfluencerDao dao = new InfluencerDao();
		InfluencerDto dto = dao.influencerProfile(Iid);//IN��ư�� ������ �ش� ���÷�� ID�� �Ѿ.
	
		model.addAttribute("dto", dto);
		
	}

}
