package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;

public class CommunityWriteService implements ICommunityService {
	//�Խ��� �� ��� ó��
	//write_view.jsp���� �̸�, ����, ������ �Է��ϰ� "�Է�"��ư��  click�ϸ� �Էµ� �����ʹ� ��ϵȴ�.	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		//�ۼ���id, ����, ������ HttpServletRequest��ü�� ���� �޾ƿ���
		String b_WriterID = request.getParameter("b_WriterID");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");

	
			CommunityDao dao = new CommunityDao();
			dao.communityInsert(b_WriterID,b_title,b_content);
	
	}

}
