package prsite.spring.subscribe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeCancelService implements ISubscribeService {
//���� ���
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model��ü�� map���·� �ٲ�

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String sno = request.getParameter("s_no");//form����
		String ino = request.getParameter("in_no");//form����
		
		SubscribeDao dao = new SubscribeDao();
		dao.subscribeDelete(sno, ino);
		
	}


}
