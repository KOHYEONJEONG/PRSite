package prsite.spring.influencer.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerProfileService implements IInfluencerService {
//Iid ���÷�� ������ �������� + cat�� �������� ���� ���÷�� ��������
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		System.out.println("execute : Select InfluencerID = "+ request.getAttribute("Iid"));
		
		String Iid = request.getParameter("Iid");//������ ���÷�� ID
		
		InfluencerDao dao = new InfluencerDao();
		InfluencerDto dto = dao.influencerProfile(Iid);//IN��ư�� ������ �ش� ���÷�� ID�� �Ѿ.
	
		model.addAttribute("dto", dto);
		
	}

}
