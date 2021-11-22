package prsite.spring.comments.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.comments.dao.CommentsDao;
import prsite.spring.community.dao.CommunityDao;

public class CommentsInsertService implements ICommentsService {
	//�ش� �Խ��� �ۿ� ��� ���

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		
		//Ŭ���� �Խ��� ��
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);

		//�ۼ���id, ����, ������ HttpServletRequest��ü�� ���� �޾ƿ���
		String b_WriterID = request.getParameter("b_WriterID");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");


		if(b_title.equals("") ||b_content.equals("")||b_content.equals("") ) 
		{
			//3�� �� �ϳ��� �Է� �ȵǸ� ���� �ȵ�.


		}else {

			CommentsDao dao = new CommentsDao();
			dao.commentsInsert(bno, b_WriterID,b_content);

		}

	}

}
