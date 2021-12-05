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

	//controller class���� ��� Template����(bean���� ����)
	public JdbcTemplate template;
	ICommunityService service;
	ICommentsService commentService;

	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}
	
	//�Խ��� ����Ʈ �ҷ����� + ����¡ó�� ��.--------------------------------------
	@RequestMapping("/community") 
	public String communityList(HttpServletRequest request, Model model) {

		//�����͸� �����ͼ� �ѷ���.
		System.out.println("---------community()-----------");
		model.addAttribute("request", request);
		service = new CommunityListService();
		service.execute(model);
		
		return "community";
	}
	//end--------------------------------------------------------------

	// �Խñ� �ۼ� start (1),(2)---------------------------------------------------
	// (1) �������̵�
	@RequestMapping("/write_view") 
	public String write_view(Model model) { 
		System.out.println("---------write_view()-----------");
		return "write_view";
	}

	//(2) �Խñ� �ۼ��� �ø��� ��ư ������
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model ) {
		System.out.println("---------write( )-----------");

		model.addAttribute("request", request);

		service = new CommunityWriteService();
		service.execute(model);

		return "redirect:community";

	}
	//end---------------------------------------------------------------
	
	// �Խñ� ���� (1)����,(2)����-----------------------------------------------------------------
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {// content_view?b_no=${dto.b_no}.
		//HttpServletRequest �����͸� ������

		System.out.println("-----------content_view()-----------");

		model.addAttribute("request",request);

		service = new CommunityContentService();//�Խñ� ����


		service.execute(model);

		return "content_view";
	}


	// 1)�ԽǱ� ������ �������� �̵�
	@RequestMapping("/modify_view") 
	public String modify_view(HttpServletRequest request, Model model) {// content_view?b_no=${dto.b_no}.
		//HttpServletRequest �����͸� ������

		System.out.println("-----------modify_view()-----------");

		model.addAttribute("request",request);//b_no�� ������.

		service = new CommunityViewModifyService();//�Խñ� ��������

		service.execute(model);

		return "modify_view";
	}
	
	
	// 2)���� �� �ø���
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) { //form�� b_no, b_name,b_suject,b_content

		System.out.println("-----------modify()-----------");

		model.addAttribute("request",request);//������ �Խ��ǹ�ȣ
		/*
		 * String id = request.getParameter("id");
		 *  String b_no = request.getParameter("b_no");
		 */
		
		service = new CommunityModifyService();
		
		service.execute(model);

		//"redirect:content_view?id='"+id+"'+,b_no='"+b_no+"'"
		return "redirect:content_view";//�ۼ���
	}
	// end--------------------------------------------------------------
	
	
	// 2)�Խñ� ���� start----------------------------------------------------------------
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("-----------delete()-----------");
		model.addAttribute("request", request);//������ �Խ��ǹ�ȣ

		service = new CommunityDeleteService();
		service.execute(model);

		return "redirect:community";// event�� ������ listȭ������ ����.
	}
	// end----------------------------------------------------------------
	
	
	
	// =============================( ��� ��Ʈ�ѷ� �� ����� )===============================
	
	@RequestMapping("/commentslist")
	public String commentslist(HttpServletRequest request, Model model) {

		System.out.println("-----------CommentsList()-----------");
		model.addAttribute("request", request);

		commentService = new CommentsListService();
		service.execute(model);

		return "redirect:list";// event�� ������ listȭ������ ����.
	}
	
	@RequestMapping("/CommentsInsert")
	public String CommentsInsert(HttpServletRequest request, Model model) {

		System.out.println("-----------CommentsInsert()-----------");
		model.addAttribute("request", request);

		commentService = new CommentsInsertService();
		service.execute(model);

		return "redirect:list";// event�� ������ listȭ������ ����.
	}
	
	@RequestMapping("/CommunityDelete")
	public String CommunityDelete(HttpServletRequest request, Model model) {

		System.out.println("-----------CommunityDelete()-----------");
		model.addAttribute("request", request);

		commentService = new CommentsDeleteService();
		service.execute(model);

		return "redirect:list";// event�� ������ listȭ������ ����.
	}

	
}
