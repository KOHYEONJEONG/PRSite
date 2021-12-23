package prsite.spring.community.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.member.dao.MemberDao;


public class CommunityViewModifyService implements ICommunityService {
	//게시판  글 내용 보기 + 수정할 때 뿌려주기

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map = model.asMap();//model을 map형태로 변환해서 객체를 담아줌.

		HttpServletRequest request = (HttpServletRequest)map.get("request");

		//클릭한 글
		String b_no = request.getParameter("b_no");
		int bno = Integer.parseInt(b_no);//형변환
		
		CommunityDao dao = new CommunityDao();//데이터 처리하기 위해서 선언

		//이름,제목,내용까지 받아서 dto에 저장.
		CommunityDto dto = dao.contentView(bno);//중요(전체 받아와야함)

		// view에 내용까지 뿌려줘야하니까 model.addAttribute를 사용함.
		model.addAttribute("content_view", dto);
		//content_View.jsp에서는 {content_view.b_name}이렇게 받으면 됨.
		
	}

}
