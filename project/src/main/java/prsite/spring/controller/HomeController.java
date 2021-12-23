package prsite.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prsite.spring.influencer.service.IInfluencerService;
import prsite.spring.influencer.service.InfluencerNewsAllService;
import prsite.spring.influencer.service.InfluencerNewsService;
import prsite.spring.influencer.service.InfluencerRcmmService;
import prsite.spring.util.ConstantTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	IInfluencerService service;//인플루언서
	
	/* JdbcTemplate */
	public JdbcTemplate template;
	
	@Autowired
	public  void setTemplate(JdbcTemplate template) {
		this.template = template;
		ConstantTemplate.template = this.template; // 모든 클래스에서 사용
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println("---------InfluencerRcmm()-----------");
		service = new InfluencerRcmmService();//수정
		service.execute(model);
		
		System.out.println("---------InfluencerNews()-----------");
		service = new InfluencerNewsAllService();//수정
		service.execute(model);
		
		System.out.println("----index----");
		return "index";

	}
		
	@RequestMapping("/Logout")
	public String Logout(Model model) {
		System.out.println("----Logout----");
		return "login/Logout";
	}
	
	@RequestMapping("/book")
	public String book(Model model) {
		System.out.println("----book----");
		return "category/book";
	}
	
	@RequestMapping("/pet")
	public String pet(Model model) {
		System.out.println("----pet page----");
		return "category/pet";
	}
	
	@RequestMapping("/cook")
	public String cook(Model model) {
		System.out.println("----cook page----");
		return "category/cook";
	}
	
	@RequestMapping("/daily")
	public String daily(Model model) {
		System.out.println("----daily page----");
		return "category/daily";
	}

	@RequestMapping("/loginpage")
	public String loginpage(Model model) {
		System.out.println("----ranking page----");
		return "login/loginpage";
	}
	
	// 에러페이지-------------------------------------
	@RequestMapping("/error404")
	public String error404(Model model) {
		System.out.println("----ranking page----");
		return "error/404";
	}
	
	@RequestMapping("/error500")
	public String error500(Model model) {
		System.out.println("----ranking page----");
		return "error/500";
	}
	//--------------------------------------------


}
