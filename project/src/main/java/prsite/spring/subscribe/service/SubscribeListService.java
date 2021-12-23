package prsite.spring.subscribe.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.SubscribeDto;
import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeListService implements ISubscribeService {
//구독 리스트 가져오기
	
	@Override
	public void execute(Model model) {
		
		SubscribeDao dao = new SubscribeDao();
		
		Map<String, Object>map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key값을 통해 value를 가져옴.

		String sno = request.getParameter("b_no");//form작성한거 보고 id(name) 수정
		
		ArrayList<SubscribeDto> dtos = dao.subscribeList(sno);
		
		//마이페이지에서 볼 수 있음.
		model.addAttribute("Sublist", dtos);//내가 구독한 인플루언서 리스트
	}

}
