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
	//controller class에서 명시 Template선언(bean으로 설정)
	public JdbcTemplate template;
	IMemberService service;
	ISubscribeService SubService;
	
	
	@Autowired //객체를 자동으로 이용( JDBC Template 사용하기 위해 )
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용.
		ConstantTemplate.template = this.template;// static
	}
	
	// 로그인 성공하면 화면 변경 start----------------------------------------
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) { 
		//id,pwd 입력후 로그인 버튼 클릭
		
		System.out.println("---------login()-----------");
		
		model.addAttribute("request",request);
		service = new MemberloginService();
		service.execute(model);
		
		
		boolean result = service.getResult();
		System.out.println("result-" + result);
		
		
		if(result) {
			return "redirect:index";//로그인되면 메인페이지로 이동
		}
		else {
			return "loginpage"; //로그인 실패되면 다시 로그인 페이지로
		}
	}
	// end---------------------------------------

	// 회원가입 start 1)2)-----------------------------------------------
	// 1) 회원가입 화면으로 넘어가기.
	@RequestMapping("/joinForm")
	public String joinForm(Model model) {
		System.out.println("----joinForm page----");
		return "joinForm";
	}

	
	// 2) 가입하기 버튼 누르면 로그인페이지로 이동됨
	@RequestMapping("/MemberJoin")
	public String MemberJoin(HttpServletRequest request, Model model) {
		//회원 가입 버튼 클릭(가입하기)
		
		System.out.println("---------MemberJoin()-----------");
		
		model.addAttribute("request",request);
		service = new MemberJoinService();
		service.execute(model);
		
		return "redirect:loginpage";//회원가입되면 login화면으로 이동.
	}
	// end-----------------------------------------------
	
	
	// 마이페이지  start 1) 2) 3)--------------------------------------------
	// 1) 회원 정보 가져오기, 구독한 인플루언서 가져오기
	@RequestMapping("/mypage")
	public String MemberProfile(HttpServletRequest request, Model model) {
		System.out.println("---------MemberProfile()-----------");
		
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "mypage";
	}
	
	// 2) 수정하기 버튼 누르면 ModiInfo.jsp로 이동.(수정할 내용보여지게) 
	@RequestMapping("/ModiInfo")
	public String ModiInfo(HttpServletRequest request,Model model) {
		System.out.println("----ModiInfo page----");
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "ModiInfo";
	}
	
	
	
	// 3) 회원 정보, 인플루언서 정보 수정
	@RequestMapping("/MemberModify")
	public String MemberModify(HttpServletRequest request, Model model) {
		System.out.println("---------MemberModify()-----------");
		
		model.addAttribute("request",request);
		service = new MemberModifyService();
		service.execute(model);
		
		return  "redirect:mypage";//수정되면 '마이페이지'로 다시 돌아감.
	}
	//end---------------------------------------------------------
	
	
	//profile.jsp 구독 start 1)2)----------------------------------------
	// 1) 인플루언서 구독 추가, 클릭한 인플루언서 구독자 수 증가
	@RequestMapping("/SubInsert")
	public String SubInsert(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeInsert()-----------");
		SubService = new SubscribeAddService();
		model.addAttribute("request",request);
		SubService.execute(model);
		String Iid = request.getParameter("Iid");
		return "redirect:profilepage?Iid="+Iid;
	}
	
	// 2) 구독 취소, 클릭한 인플루언서 구독자 수 감소
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
