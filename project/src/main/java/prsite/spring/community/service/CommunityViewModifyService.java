package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.member.dao.MemberDao;


public class CommunityViewModifyService implements ICommunityService {
	//�Խ���  �� ���� ���� + ������ �� �ѷ��ֱ�

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();//model�� map���·� ��ȯ�ؼ� ��ü�� �����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		//Ŭ���� ��
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);//����ȯ
		
		CommunityDao dao = new CommunityDao();//������ ó���ϱ� ���ؼ� ����

		//�̸�,����,������� �޾Ƽ� dto�� ����.
		CommunityDto dto = dao.contentView(bno);//�߿�(��ü �޾ƿ;���)

		// view�� ������� �ѷ�����ϴϱ� model.addAttribute�� �����.
		model.addAttribute("content_view", dto);
		//content_View.jsp������ {content_view.b_name}�̷��� ������ ��.
		
	}

}
