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

	
	
	@RequestMapping("/list") //게시판 리스트 불러오기
	public void community(Model model) {

		//데이터만 가져와서 뿌려줌.
		System.out.println("---------list()-----------");
		service = new CommunityListService();
		service.execute(model);

	}

	
	
	@RequestMapping("/write_view") // 커뮤니티에서 글쓰기 버튼 클릭.
	public String write_view(Model model) { 

		System.out.println("---------write_view()-----------");


		return "write_view";//url에 입력 아니고 jsp를 찾아감.
	}

	
	
	//write_view.jsp에서 글쓰기 버튼 누르면 from action이 실행됨.
	//form action="write"
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model ) {// 글씨기 버튼 누르면 실행
		//HttpServletRequest를 사용하면, 값을 받아올 수 있다.
		//HttpServletRequest 객체안에 모든 데이터들이 들어가게 된다.
		//string 타입이다.

		System.out.println("---------write( )-----------");

		// Model객체를 이용해서 뷰로 값을 넘긴다.
		model.addAttribute("request", request);//model객체(정보)는 addAttribute()를 통해 전달

		service = new CommunityWriteService();//
		service.execute(model);


		//redirect: 리다이렉트 , forward: 포워딩(생략시 얘가 기본)
		return "redirect:list";//등록과 동시에 리스트화면으로 간다("redirect:list");.

	}

	
	
	@RequestMapping("/content_view") //내용보기
	public String content_view(HttpServletRequest request, Model model) {// content_view?b_no=${dto.b_no}.
		//HttpServletRequest 데이터를 가져옴

		System.out.println("-----------content_view()-----------");

		model.addAttribute("request",request);

		service = new CommunityContentService();//내용보기


		service.execute(model);

		return "content_view";
	}

	
	
	
	//수정은 post방식으로 처리해라.
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) { //form에 b_no, b_name,b_suject,b_content

		System.out.println("-----------modify()-----------");

		model.addAttribute("request",request);

		service = new CommunityModifyService();//수정처리

		service.execute(model);


		return "redirect:list";//수정과 동시에 list.jsp화면으로 간다.
	}

	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("-----------delete()-----------");
		model.addAttribute("request", request);

		service = new CommunityDeleteService();
		service.execute(model);

		return "redirect:list";// event가 끝나면 list화면으로 간다.
	}

	
	
	
	//@RequestMapping을 통해 url이 정의됨.
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {

		System.out.println("-----------search()-----------");

		model.addAttribute("request", request);

		service = new CommunitySearchService();
		service.execute(model);

		return "content_view";
	}
	
	
	
	
	// =============================( 댓글 컨트롤러 )===============================
	
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @RequestMapping("loginpage") public void loginpage() {
	 * 
	 * }
	 * 
	 * @RequestMapping("community") public void community() {
	 * 
	 * }
	 * 
	 * @RequestMapping("category") public void category() {
	 * 
	 * }
	 * 
	 * @RequestMapping("profile") public void profile() {
	 * 
	 * }
	 */
}
