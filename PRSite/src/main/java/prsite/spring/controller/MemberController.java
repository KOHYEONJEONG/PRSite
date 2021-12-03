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
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용.
		ConstantTemplate.template = this.template;// static
	}
	
	@RequestMapping("/login") // 로그인 버튼 누를 때 화면 변경
	public String login(HttpServletRequest request, Model model) { 
		//id,pwd 입력후 로그인 버튼 클릭
		
		System.out.println("---------login()-----------");
		
		model.addAttribute("request",request);
		service = new MemberloginService();
		service.execute(model);
		boolean result = service.getResult();
		System.out.println("-result = " + result);
		if(result) {
			System.out.println("---------redirect:index-----------");
			return "redirect:index";//로그인되면 메인페이지로 이동
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
		//회원 가입 버튼 클릭(가입하기)
		
		System.out.println("---------MemberJoin()-----------");
		
		model.addAttribute("request",request);
		service = new MemberJoinService();
		service.execute(model);
		
		return  "redirect:loginpage";//회원가입되면 login화면으로 이동.
	}
	
	
	//회원 정보 가져오기
	@RequestMapping("mypage")
	public String MemberProfile(HttpServletRequest request, Model model) {
		System.out.println("---------MemberProfile()-----------");
		
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return  "mypage";//일반사용자 '마이페이지' 화면.
	}
	
	//ModiInfo.jsp 눌렀을때 내용 뿌려지게
	@RequestMapping("/ModiInfo")
	public String ModiInfo(HttpServletRequest request,Model model) {
		System.out.println("----ModiInfo page----");
		model.addAttribute("request",request);
		service = new MemberProfileService();
		service.execute(model);
		
		return "ModiInfo";
	}
	
	//회원 정보, 인플루언서 정보 수정
	@RequestMapping("/MemberModify")
	public String MemberModify(HttpServletRequest request, Model model) {
		System.out.println("---------MemberModify()-----------");
		
		model.addAttribute("request",request);
		service = new MemberModifyService();
		service.execute(model);
		
		return  "redirect:mypage";//수정되면 '마이페이지'로 다시 돌아감.
	}
	
	//구독자 불러오기(list)
	@RequestMapping("/SubList")
	public String SubList(Model model) {
		
		System.out.println("-----------SubscribeList()-----------");
		SubService = new SubscribeListService();
		SubService.execute(model);
		
		return "MemberProfile";//마이페이지
	}
	
	
	//인플루언서 구독 추가
	@RequestMapping("/SubInsert")
	public void SubInsert(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeInsert()-----------");
		SubService = new SubscribeAddService();
		SubService.execute(model);
		
	}
	
	//구독 취소
	@RequestMapping("/SubCancel")
	public void SubCancel(HttpServletRequest request, Model model) {
		System.out.println("-----------subscribeInsert()-----------");
		SubService = new SubscribeCancelService();
		SubService.execute(model);
	}
	

	
	
	
}
