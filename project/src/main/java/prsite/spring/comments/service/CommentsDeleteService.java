package prsite.spring.comments.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.comments.dao.CommentsDao;
import prsite.spring.community.dao.CommunityDao;
import prsite.spring.community.service.ICommunityService;

public class CommentsDeleteService implements ICommentsService {
//�ش� �Խ��� �ۿ� ��� ����
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap(); //model��ü�� map���·� �ٲ�

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String c_no = request.getParameter("c_no");
		int cno = Integer.parseInt(c_no);

		CommentsDao dao = new CommentsDao();

		dao.commentsDelete(cno);
		
	}

}
