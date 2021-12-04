package prsite.spring.subscribe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeCancelService implements ISubscribeService {
	//구독 취소

	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();//model을 map형태로 변환해서 객체를 담아줌.

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();

		//로그인한 id
		String LoginID = (String)session.getAttribute("LoginID");

		//인플루언서 id
		String Ino = request.getParameter("Iid");//form보기
		
		System.out.println("============구독 취소===========");
		System.out.println("LoginID="+LoginID+", Iid="+Ino);
		//구독한 인플루언서 없애기(Mypage.jsp구독한 인플루언서와 profile.jsp해당 인플루언서 버튼 글씨가 '구독'으로 바껴있음
		SubscribeDao dao = new SubscribeDao();
		dao.subscribeDelete(LoginID, Ino);

		//해당 인플루언서는 구독자수가 감소됨.
		InfluencerDao dao2 = new InfluencerDao();
		dao2.InfluencerSubUpdate(Ino);

	}


}
