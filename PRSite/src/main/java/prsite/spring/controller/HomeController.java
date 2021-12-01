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

import prsite.spring.util.ConstantTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
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
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
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
	
	@RequestMapping("/loginpage")
	public String loginpage(Model model) {
		System.out.println("----login page----");
		return "loginpage";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		System.out.println("----index page----");
		return "index";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm(Model model) {
		System.out.println("----join Form page----");
		return "joinForm";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model model) {
		System.out.println("----my page----");
		return "mypage";
	}
	
}
