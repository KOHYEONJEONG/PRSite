package prsite.spring.subscribe.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.dto.SubscribeDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeAddService implements ISubscribeService {
// 구독추가
	public boolean isSubscribed = false;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		//로그인한 id
		String LoginID = (String)session.getAttribute("LoginID");
		//인플루언서 id
		String Iid = request.getParameter("Iid");

		System.out.println("LoginID="+LoginID+", Iid="+Iid);
		
		//구독한 인플루언서
		SubscribeDao dao = new SubscribeDao();
		dao.subscribeInsert(LoginID, Iid);
		
		//해당 인플루언서는 구독자수가 증가됨.
		InfluencerDao dao2 = new InfluencerDao();
		dao2.InfluencerSubUpdate(Iid);
		
	}

}
