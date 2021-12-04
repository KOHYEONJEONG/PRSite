package prsite.spring.subscribe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeCancelService implements ISubscribeService {
	//���� ���

	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();//model�� map���·� ��ȯ�ؼ� ��ü�� �����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();

		//�α����� id
		String LoginID = (String)session.getAttribute("LoginID");

		//���÷�� id
		String Ino = request.getParameter("Iid");//form����
		
		System.out.println("============���� ���===========");
		System.out.println("LoginID="+LoginID+", Iid="+Ino);
		//������ ���÷�� ���ֱ�(Mypage.jsp������ ���÷�𼭿� profile.jsp�ش� ���÷�� ��ư �۾��� '����'���� �ٲ�����
		SubscribeDao dao = new SubscribeDao();
		dao.subscribeDelete(LoginID, Ino);

		//�ش� ���÷�𼭴� �����ڼ��� ���ҵ�.
		InfluencerDao dao2 = new InfluencerDao();
		dao2.InfluencerSubUpdate(Ino);

	}


}
