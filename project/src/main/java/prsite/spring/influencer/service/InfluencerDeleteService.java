package prsite.spring.influencer.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.influencer.dao.InfluencerDao;

public class InfluencerDeleteService implements IInfluencerService {
//���÷�� ����
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model��ü�� map���·� �ٲ�
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		
		InfluencerDao dao = new InfluencerDao();
		
		dao.InfluencerDelete(id);
	}

}
