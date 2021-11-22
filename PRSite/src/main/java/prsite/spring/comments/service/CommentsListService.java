package prsite.spring.comments.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.comments.dao.CommentsDao;
import prsite.spring.dto.CommentsDto;

public class CommentsListService implements ICommentsService {
	// 해당 게시판 글에 등록된 글에 대한 댓글 모두 가져오기

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		CommentsDao dao = new CommentsDao();
		
		//클릭한 게시판 글
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);
		
		ArrayList<CommentsDto> dtos = dao.commentslist(bno);

		model.addAttribute("list_comments", dtos);
	}

}
