package prsite.spring.subscribe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeCancelService implements ISubscribeService {
//구독 취소
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model객체를 map형태로 바꿈

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String sno = request.getParameter("s_no");//form보기
		String ino = request.getParameter("in_no");//form보기
		
		SubscribeDao dao = new SubscribeDao();
		dao.subscribeDelete(sno, ino);
		
	}


}
