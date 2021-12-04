package prsite.spring.subscribe.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.dto.SubscribeDto;
import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeAddService implements ISubscribeService {
// �����߰�
	public boolean isSubscribed = false;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		//�α����� id
		String LoginID = (String)session.getAttribute("LoginID");
		//���÷�� id
		String Iid = request.getParameter("Iid");

		System.out.println("LoginID="+LoginID+", Iid="+Iid);
		
		SubscribeDao dao = new SubscribeDao();
		dao.subscribeInsert(LoginID, Iid);
		
	}

}
