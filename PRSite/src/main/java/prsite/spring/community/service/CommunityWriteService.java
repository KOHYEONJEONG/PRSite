package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;

public class CommunityWriteService implements ICommunityService {
	//게시판 글 등록 처리
	//write_view.jsp에서 이름, 제목, 내용을 입력하고 "입력"버튼을  click하면 입력된 데이터는 등록된다.	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		//작성자id, 제목, 내용을 HttpServletRequest객체를 통해 받아오고
		String b_WriterID = request.getParameter("b_WriterID");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");

	
			CommunityDao dao = new CommunityDao();
			dao.communityInsert(b_WriterID,b_title,b_content);
	
	}

}
