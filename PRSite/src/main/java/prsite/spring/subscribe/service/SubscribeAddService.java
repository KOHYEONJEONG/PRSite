package prsite.spring.subscribe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeAddService implements ISubscribeService {
// �����߰�
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		//�α����� id
		String LoginID = (String)session.getAttribute("LoginID");
		
		//���÷�� id
		String Iid = request.getParameter("Iid");
		
		SubscribeDao dao = new SubscribeDao();
		
		dao.subscribeInsert(LoginID, Iid);
		
	}

}
