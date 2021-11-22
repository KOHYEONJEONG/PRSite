package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;


public class CommunityContentService implements ICommunityService {
	//�Խ���  �� ���� ����

	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();//model�� map���·� ��ȯ�ؼ� ��ü�� �����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		//Ŭ���� ��
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);

		CommunityDao dao = new CommunityDao();//������ ó���ϱ� ���ؼ� ����

		//db�� ������ ���� ������ �̸�,����,������� �޾Ƽ� dto�� ����.
		CommunityDto dto = dao.contentView(bno);//�߿�(��ü �޾ƿ;���)

		// view�� ������� �ѷ�����ϴϱ� model.addAttribute�� �����.
		model.addAttribute("content_view", dto); // model�� dto��ü�� ��´�.
		//content_View.jsp������ {content_view.b_name}�̷��� ������ ��.

	}

}
