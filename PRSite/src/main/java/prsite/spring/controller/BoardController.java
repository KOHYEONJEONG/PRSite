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

	
	
	@RequestMapping("/list") //�Խ��� ����Ʈ �ҷ�����
	public void community(Model model) {

		//�����͸� �����ͼ� �ѷ���.
		System.out.println("---------list()-----------");
		service = new CommunityListService();
		service.execute(model);

	}

	
	
	@RequestMapping("/write_view") // Ŀ�´�Ƽ���� �۾��� ��ư Ŭ��.
	public String write_view(Model model) { 

		System.out.println("---------write_view()-----------");


		return "write_view";//url�� �Է� �ƴϰ� jsp�� ã�ư�.
	}

	
	
	//write_view.jsp���� �۾��� ��ư ������ from action�� �����.
	//form action="write"
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model ) {// �۾��� ��ư ������ ����
		//HttpServletRequest�� ����ϸ�, ���� �޾ƿ� �� �ִ�.
		//HttpServletRequest ��ü�ȿ� ��� �����͵��� ���� �ȴ�.
		//string Ÿ���̴�.

		System.out.println("---------write( )-----------");

		// Model��ü�� �̿��ؼ� ��� ���� �ѱ��.
		model.addAttribute("request", request);//model��ü(����)�� addAttribute()�� ���� ����

		service = new CommunityWriteService();//
		service.execute(model);


		//redirect: �����̷�Ʈ , forward: ������(������ �갡 �⺻)
		return "redirect:list";//��ϰ� ���ÿ� ����Ʈȭ������ ����("redirect:list");.

	}

	
	
	@RequestMapping("/content_view") //���뺸��
	public String content_view(HttpServletRequest request, Model model) {// content_view?b_no=${dto.b_no}.
		//HttpServletRequest �����͸� ������

		System.out.println("-----------content_view()-----------");

		model.addAttribute("request",request);

		service = new CommunityContentService();//���뺸��


		service.execute(model);

		return "content_view";
	}

	
	
	
	//������ post������� ó���ض�.
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) { //form�� b_no, b_name,b_suject,b_content

		System.out.println("-----------modify()-----------");

		model.addAttribute("request",request);

		service = new CommunityModifyService();//����ó��

		service.execute(model);


		return "redirect:list";//������ ���ÿ� list.jspȭ������ ����.
	}

	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("-----------delete()-----------");
		model.addAttribute("request", request);

		service = new CommunityDeleteService();
		service.execute(model);

		return "redirect:list";// event�� ������ listȭ������ ����.
	}

	
	
	
	//@RequestMapping�� ���� url�� ���ǵ�.
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {

		System.out.println("-----------search()-----------");

		model.addAttribute("request", request);

		service = new CommunitySearchService();
		service.execute(model);

		return "content_view";
	}
	
	
	
	
	// =============================( ��� ��Ʈ�ѷ� )===============================
	
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
