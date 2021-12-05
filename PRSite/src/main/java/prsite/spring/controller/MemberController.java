package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import prsite.spring.member.service.IMemberService;
import prsite.spring.member.service.MemberJoinService;
import prsite.spring.member.service.MemberModifyService;
import prsite.spring.member.service.MemberProfileService;
import prsite.spring.member.service.MemberloginService;
import prsite.spring.subscribe.service.ISubscribeService;
import prsite.spring.subscribe.service.SubscribeAddService;
import prsite.spring.subscribe.service.SubscribeCancelService;
import prsite.spring.subscribe.service.SubscribeListService;
import prsite.spring.util.ConstantTemplate;

@Controller
public class MemberController {
	//controller class���� ��� Template����(bean���� ����)
	public JdbcTemplate template;
	IMemberService service;
	ISubscribeService SubService;
	
	
	@Autowired //��ü�� �ڵ����� �̿�( JDBC Template ����ϱ� ���� )
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}
	
	// �α��� �����ϸ� ȭ�� ���� start----------------------------------------
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) { 
		//id,pwd �Է��� �α��� ��ư Ŭ��
		
		System.out.println("---------login()-----------");
		
		model.addAttribute("request",request);
		service = new MemberloginService();
		service.execute(model);
		
		
		boolean result = service.getResult();
		System.out.println("result-" + result);
		
		
		if(result) {
			return "redirect:index";//�α��εǸ� ������������ �̵�
		}
		else {
			return "loginpage"; //�α��� ���еǸ� �ٽ� �α��� ��������
		}
	}
	// end---------------------------------------

	// ȸ������ start 1)2)-----------------------------------------------
	// 1) ȸ������ ȭ������ �Ѿ��.
	@RequestMapping("/joinForm")
	public String joinForm(Model model) {
		System.out.println("----joinForm page----");
		return "joinForm";
	}

	
	// 2) �����ϱ� ��ư ������ �α����������� �̵���
	@RequestMapping("/MemberJoin")
	public String MemberJoin(HttpServletRequest request, Model model) {
		//ȸ�� ���� ��ư Ŭ��(�����ϱ�)
		
		System.out.println("---------MemberJoin()-----------");
		
		model.addAttribute("request",request);
		service = new MemberJoinService();
		service.execute(model);
		
		return "redirect:loginpage";//ȸ�����ԵǸ� loginȭ������ �̵�.
	}
	// end-----------------------------------------------
	
	
	// ����������  start 1) 2) 3)--------------------------------------------
	// 1) ȸ�� ���� ��������, ������ ���÷�� ��������
	@RequestMapping("/mypage")
	public String MemberProfile(HttpServletRequest request, Model model) {
		System.out.println("---------MemberProfile()-----------");
		
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "mypage";
	}
	
	// 2) �����ϱ� ��ư ������ ModiInfo.jsp�� �̵�.(������ ���뺸������) 
	@RequestMapping("/ModiInfo")
	public String ModiInfo(HttpServletRequest request,Model model) {
		System.out.println("----ModiInfo page----");
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "ModiInfo";
	}
	
	
	
	// 3) ȸ�� ����, ���÷�� ���� ����
	@RequestMapping("/MemberModify")
	public String MemberModify(HttpServletRequest request, Model model) {
		System.out.println("---------MemberModify()-----------");
		
		model.addAttribute("request",request);
		service = new MemberModifyService();
		service.execute(model);
		
		return  "redirect:mypage";//�����Ǹ� '����������'�� �ٽ� ���ư�.
	}
	//end---------------------------------------------------------
	
	
	//profile.jsp ���� start 1)2)----------------------------------------
	// 1) ���÷�� ���� �߰�, Ŭ���� ���÷�� ������ �� ����
	@RequestMapping("/SubInsert")
	public String SubInsert(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeInsert()-----------");
		SubService = new SubscribeAddService();
		model.addAttribute("request",request);
		SubService.execute(model);
		String Iid = request.getParameter("Iid");
		return "redirect:profilepage?Iid="+Iid;
	}
	
	// 2) ���� ���, Ŭ���� ���÷�� ������ �� ����
	@RequestMapping("/SubCancel")
	public String SubCancel(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeCancel()-----------");
		model.addAttribute("request",request);
		SubService = new SubscribeCancelService();
		SubService.execute(model);
		String Iid = request.getParameter("Iid");
		return "redirect:profilepage?Iid="+Iid;
	}
	//end---------------------------------------------------------

	
	
	
}
