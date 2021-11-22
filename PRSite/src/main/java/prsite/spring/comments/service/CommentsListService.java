package prsite.spring.comments.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.comments.dao.CommentsDao;
import prsite.spring.dto.CommentsDto;

public class CommentsListService implements ICommentsService {
	// �ش� �Խ��� �ۿ� ��ϵ� �ۿ� ���� ��� ��� ��������

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		CommentsDao dao = new CommentsDao();
		
		//Ŭ���� �Խ��� ��
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);
		
		ArrayList<CommentsDto> dtos = dao.commentslist(bno);

		model.addAttribute("list_comments", dtos);
	}

}
