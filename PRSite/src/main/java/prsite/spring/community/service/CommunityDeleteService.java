package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;

public class CommunityDeleteService implements ICommunityService {
//게시판  글 삭제 처리
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model객체를 map형태로 바꿈

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);

		CommunityDao dao = new CommunityDao();

		dao.communityDelete(bno);
		

	}

}
