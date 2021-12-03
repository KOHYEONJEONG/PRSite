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
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}
	
	@RequestMapping("/login") // �α��� ��ư ���� �� ȭ�� ����
	public String login(HttpServletRequest request, Model model) { 
		//id,pwd �Է��� �α��� ��ư Ŭ��
		
		System.out.println("---------login()-----------");
		
		model.addAttribute("request",request);
		service = new MemberloginService();
		service.execute(model);
		boolean result = service.getResult();
		System.out.println("-result = " + result);
		if(result) {
			System.out.println("---------redirect:index-----------");
			return "redirect:index";//�α��εǸ� ������������ �̵�
		}
		else {
			System.out.println("---------redirect:index-----------");
			return "loginpage";
		}
	}

	
	@RequestMapping("/joinForm")
	public String joinForm(Model model) {
		System.out.println("----joinForm page----");
		return "loginpage";
	}

	
	@RequestMapping("/MemberJoin")
	public String MemberJoin(HttpServletRequest request, Model model) {
		//ȸ�� ���� ��ư Ŭ��(�����ϱ�)
		
		System.out.println("---------MemberJoin()-----------");
		
		model.addAttribute("request",request);
		service = new MemberJoinService();
		service.execute(model);
		
		return  "redirect:loginpage";//ȸ�����ԵǸ� loginȭ������ �̵�.
	}
	
	
	//ȸ�� ���� ��������
	@RequestMapping("mypage")
	public String MemberProfile(HttpServletRequest request, Model model) {
		System.out.println("---------MemberProfile()-----------");
		
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return  "mypage";//�Ϲݻ���� '����������' ȭ��.
	}
	
	//ModiInfo.jsp �������� ���� �ѷ�����
	@RequestMapping("/ModiInfo")
	public String ModiInfo(HttpServletRequest request,Model model) {
		System.out.println("----ModiInfo page----");
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "ModiInfo";
	}
	
	//ȸ�� ����, ���÷�� ���� ����
	@RequestMapping("/MemberModify")
	public String MemberModify(HttpServletRequest request, Model model) {
		System.out.println("---------MemberModify()-----------");
		
		model.addAttribute("request",request);
		service = new MemberModifyService();
		service.execute(model);
		
		return  "redirect:mypage";//�����Ǹ� '����������'�� �ٽ� ���ư�.
	}
	
	//������ �ҷ�����(list)
	@RequestMapping("/SubList")
	public String SubList(Model model) {
		
		System.out.println("-----------SubscribeList()-----------");
		SubService = new SubscribeListService();
		SubService.execute(model);
		
		return "MemberProfile";//����������
	}
	
	
	//���÷�� ���� �߰�
	@RequestMapping("/SubInsert")
	public void SubInsert(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeInsert()-----------");
		SubService = new SubscribeAddService();
		SubService.execute(model);
		
	}
	
	//���� ���
	@RequestMapping("/SubCancel")
	public void SubCancel(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeInsert()-----------");
		SubService = new SubscribeCancelService();
		SubService.execute(model);
	}
	

	
	
	
}
