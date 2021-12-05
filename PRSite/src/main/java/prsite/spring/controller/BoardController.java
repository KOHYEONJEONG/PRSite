package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prsite.spring.comments.service.CommentsInsertService;
import prsite.spring.comments.service.CommentsListService;
import prsite.spring.comments.service.CommentsDeleteService;
import prsite.spring.comments.service.ICommentsService;
import prsite.spring.community.service.CommunityContentService;
import prsite.spring.community.service.CommunityDeleteService;
import prsite.spring.community.service.CommunityListService;
import prsite.spring.community.service.CommunityModifyService;
import prsite.spring.community.service.CommunitySearchService;
import prsite.spring.community.service.CommunityViewModifyService;
import prsite.spring.community.service.CommunityWriteService;
import prsite.spring.community.service.ICommunityService;
import prsite.spring.util.ConstantTemplate;

@Controller
public class BoardController {

	//controller class에서 명시 Template선언(bean으로 설정)
	public JdbcTemplate template;
	ICommunityService service;
	ICommentsService commentService;

	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//모든 클래스에서 사용.
		ConstantTemplate.template = this.template;// static
	}
	
	//게시판 리스트 불러오기 + 페이징처리 함.--------------------------------------
	@RequestMapping("/community") 
	public String communityList(HttpServletRequest request, Model model) {

		//데이터만 가져와서 뿌려줌.
		System.out.println("---------community()-----------");
		model.addAttribute("request", request);
		service = new CommunityListService();
		service.execute(model);
		
		return "community";
	}
	//end--------------------------------------------------------------

	// 게시글 작성 start (1),(2)---------------------------------------------------
	// (1) 페이지이동
	@RequestMapping("/write_view") 
	public String write_view(Model model) { 
		System.out.println("---------write_view()-----------");
		return "write_view";
	}

	//(2) 게시글 작성후 올리기 버튼 누르기
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model ) {
		System.out.println("---------write( )-----------");

		model.addAttribute("request", request);

		service = new CommunityWriteService();
		service.execute(model);

		return "redirect:community";

	}
	//end---------------------------------------------------------------
	
	// 게시글 보기 (1)수정,(2)삭제-----------------------------------------------------------------
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {// content_view?b_no=${dto.b_no}.
		//HttpServletRequest 데이터를 가져옴

		System.out.println("-----------content_view()-----------");

		model.addAttribute("request",request);

		service = new CommunityContentService();//게시글 보기


		service.execute(model);

		return "content_view";
	}


	// 1)게실글 수정할 페이지로 이동
	@RequestMapping("/modify_view") 
	public String modify_view(HttpServletRequest request, Model model) {// content_view?b_no=${dto.b_no}.
		//HttpServletRequest 데이터를 가져옴

		System.out.println("-----------modify_view()-----------");

		model.addAttribute("request",request);//b_no를 가져옴.

		service = new CommunityViewModifyService();//게시글 가져오기

		service.execute(model);

		return "modify_view";
	}
	
	
	// 2)수정 후 올리기
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) { //form에 b_no, b_name,b_suject,b_content

		System.out.println("-----------modify()-----------");

		model.addAttribute("request",request);//수정할 게시판번호
		/*
		 * String id = request.getParameter("id");
		 *  String b_no = request.getParameter("b_no");
		 */
		
		service = new CommunityModifyService();
		
		service.execute(model);

		//"redirect:content_view?id='"+id+"'+,b_no='"+b_no+"'"
		return "redirect:content_view";//작성자
	}
	// end--------------------------------------------------------------
	
	
	// 2)게시글 삭제 start----------------------------------------------------------------
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("-----------delete()-----------");
		model.addAttribute("request", request);//삭제할 게시판번호

		service = new CommunityDeleteService();
		service.execute(model);

		return "redirect:community";// event가 끝나면 list화면으로 간다.
	}
	// end----------------------------------------------------------------
	
	
	
	// =============================( 댓글 컨트롤러 ㅣ 지우기 )===============================
	
	@RequestMapping("/commentslist")
	public String commentslist(HttpServletRequest request, Model model) {

		System.out.println("-----------CommentsList()-----------");
		model.addAttribute("request", request);

		commentService = new CommentsListService();
		service.execute(model);

		return "redirect:list";// event가 끝나면 list화면으로 간다.
	}
	
	@RequestMapping("/CommentsInsert")
	public String CommentsInsert(HttpServletRequest request, Model model) {

		System.out.println("-----------CommentsInsert()-----------");
		model.addAttribute("request", request);

		commentService = new CommentsInsertService();
		service.execute(model);

		return "redirect:list";// event가 끝나면 list화면으로 간다.
	}
	
	@RequestMapping("/CommunityDelete")
	public String CommunityDelete(HttpServletRequest request, Model model) {

		System.out.println("-----------CommunityDelete()-----------");
		model.addAttribute("request", request);

		commentService = new CommentsDeleteService();
		service.execute(model);

		return "redirect:list";// event가 끝나면 list화면으로 간다.
	}

	
}
