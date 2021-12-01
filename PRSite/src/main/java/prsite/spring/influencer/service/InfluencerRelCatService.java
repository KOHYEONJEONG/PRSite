package prsite.spring.influencer.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerRelCatService implements IInfluencerService {
//���÷�� ���� ī�װ� ��õ
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model��ü�� map���·� �ٲ�

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String cat =  request.getParameter("cat");
		
		InfluencerDao influencerDao =  new InfluencerDao();
		
		ArrayList<InfluencerDto> dtos = influencerDao.influencerRelCat(cat);
		
		model.addAttribute("relcatlist", dtos);
	}

}
