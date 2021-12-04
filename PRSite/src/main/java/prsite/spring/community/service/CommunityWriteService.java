package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;

public class CommunityWriteService implements ICommunityService {
	//�Խ��� �� ��� ó��
	//write_view.jsp���� �̸�, ����, ������ �Է��ϰ� "�Է�"��ư��  click�ϸ� �Էµ� �����ʹ� ��ϵȴ�.	
	@Override
	public void execute(Model model) {

		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		
		//�ۼ���id, ����, ������ HttpServletRequest��ü�� ���� �޾ƿ���
		String b_WriterID = (String) session.getAttribute("LoginID");
		
		String b_title = request.getParameter("title");
		String b_content = request.getParameter("content");

	
		CommunityDao dao = new CommunityDao();
		dao.communityInsert(b_WriterID,b_title,b_content);
	
	}

}
