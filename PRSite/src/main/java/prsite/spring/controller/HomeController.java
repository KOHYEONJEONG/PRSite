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
		/*
		System.out.println("---------InfluencerRcmm()-----------");
		service = new InfluencerRcmmService();//수정
		service.execute(model);
		
		System.out.println("---------InfluencerNews()-----------");
		service = new InfluencerNewsAllService();//수정
		service.execute(model);
		*/
		System.out.println("----home----");
		return "index";
		
		//Bootstrap 임시
		//System.out.println("----index----");
		//return "index";
	}
	
	//Bootstrap 임시
	/*
	 * @RequestMapping("/index") public String index(Model model) {
	 * System.out.println("----index----"); return "index"; }
	 */
	
	//Bootstrap 임시
	/*
	 * @RequestMapping("/index") public String index(Model model) {
	 * System.out.println("----index----"); return "index"; }
	 */
	
	@RequestMapping("/Logout")
	public String Logout(Model model) {
		System.out.println("----Logout----");
		return "Logout";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		System.out.println("----menu----");
		return "menu";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		System.out.println("----about----");
		return "about";
	}
	
	@RequestMapping("/book")
	public String book(Model model) {
		System.out.println("----book----");
		return "book";
	}
	
	@RequestMapping("/pet")
	public String pet(Model model) {
		System.out.println("----pet page----");
		return "pet";
	}
	
	@RequestMapping("/cook")
	public String cook(Model model) {
		System.out.println("----cook page----");
		return "cook";
	}
	
	@RequestMapping("/daily")
	public String daily(Model model) {
		System.out.println("----daily page----");
		return "daily";
	}

	@RequestMapping("/loginpage")
	public String loginpage(Model model) {
		System.out.println("----ranking page----");
		return "loginpage";
	}


}
