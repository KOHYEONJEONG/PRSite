package prsite.spring.subscribe.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.SubscribeDto;
import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeListService implements ISubscribeService {
//���� ����Ʈ ��������
	
	@Override
	public void execute(Model model) {
		
		SubscribeDao dao = new SubscribeDao();
		
		Map<String, Object>map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key���� ���� value�� ������.

		String sno = request.getParameter("b_no");//form�ۼ��Ѱ� ���� id(name) ����
		
		ArrayList<SubscribeDto> dtos = dao.subscribeList(sno);
		
		//�������������� �� �� ����.
		model.addAttribute("Sublist", dtos);//���� ������ ���÷�� ����Ʈ
	}

}
