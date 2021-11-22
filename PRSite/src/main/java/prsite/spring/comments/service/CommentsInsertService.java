package prsite.spring.comments.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.comments.dao.CommentsDao;
import prsite.spring.community.dao.CommunityDao;

public class CommentsInsertService implements ICommentsService {
	//해당 게시판 글에 댓글 등록

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		
		//클릭한 게시판 글
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);

		//작성자id, 제목, 내용을 HttpServletRequest객체를 통해 받아오고
		String b_WriterID = request.getParameter("b_WriterID");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");


		if(b_title.equals("") ||b_content.equals("")||b_content.equals("") ) 
		{
			//3개 중 하나라도 입력 안되면 저장 안됨.


		}else {

			CommentsDao dao = new CommentsDao();
			dao.commentsInsert(bno, b_WriterID,b_content);

		}

	}

}
