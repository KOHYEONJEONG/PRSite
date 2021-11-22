package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;


public class CommunityModifyService implements ICommunityService {
	//게시판 글 수정처리

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key값을 통해 value를 가져옴.

		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);
		
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");

		CommunityDao dao = new CommunityDao();
		dao.communityModify(bno,b_title,b_content);

	}

}
