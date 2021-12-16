package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import prsite.spring.member.dao.MemberDao;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		//���̵� üũ
		System.out.println("userIdCheck ���� , id : " + id);
		
		MemberDao dao = new MemberDao();
		
		int cnt = dao.joinIdCheck(id);
		
		return  cnt;
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
			return "login/loginpage"; //�α��� ���еǸ� �ٽ� �α��� ��������
		}
	}
	// end---------------------------------------

	// ȸ������ start 1)2)-----------------------------------------------
	// 1) ȸ������ ȭ������ �Ѿ��.
	@RequestMapping("/joinForm")
	public String joinForm(Model model) {
		System.out.println("----joinForm page----");
		return "login/joinForm";
	}

	
	// 2) �����ϱ� ��ư ������ �α����������� �̵���
	@RequestMapping(method=RequestMethod.POST, value ="/join")
	public String join(MultipartHttpServletRequest request, Model model) {
		//ȸ�� ���� ��ư Ŭ��(�����ϱ�)
		
		System.out.println("---------join()-----------");
		
		model.addAttribute("request",request);
		
		service = new MemberJoinService();
		service.execute(model);
		
		return "login/loginpage";//ȸ�����ԵǸ� loginȭ������ �̵�.
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
		
		return "info/mypage";
	}
	
	// 2) �����ϱ� ��ư ������ ModiInfo.jsp�� �̵�.(������ ���뺸������) 
	@RequestMapping("/ModiInfo")
	public String ModiInfo(HttpServletRequest request,Model model) {
		System.out.println("----ModiInfo page----");
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "info/ModiInfo";
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
