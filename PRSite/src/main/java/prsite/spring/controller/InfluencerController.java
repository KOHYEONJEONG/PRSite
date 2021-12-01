package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import prsite.spring.influencer.service.IInfluencerService;
import prsite.spring.influencer.service.InfluencerNewsService;
import prsite.spring.influencer.service.InfluencerProfileService;
import prsite.spring.influencer.service.InfluencerRankingService;
import prsite.spring.influencer.service.InfluencerRcmmService;
import prsite.spring.util.ConstantTemplate;

@Controller
public class InfluencerController {
	//controller class에서 명시 Template선언(bean으로 설정)
	public JdbcTemplate template;	
	IInfluencerService service;//인플루언서
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//모든 클래스에서 사용.
		ConstantTemplate.template = this.template;// static
	}

	
	@RequestMapping("inProfile")
	public String inProfile(Model model) {
		
		System.out.println("---------inProfile()-----------");
		service = new InfluencerProfileService();
		service.execute(model);
		
		
		return "InfluencerProfile";
	}
	
	//구독자수 랭킹
	@RequestMapping("inRanking")
	public String inRanking(Model model) {
		
		System.out.println("---------inRanking()-----------");
		service = new InfluencerRankingService();
		service.execute(model);
		
		
		
		return "InfluencerRanking";
	}
	
	//인플루언서 검색
	@RequestMapping("InfluencerSearch")
	public String InfluencerSearch(Model model, HttpServletRequest Request) {
		
		System.out.println("---------SearchService()-----------");
		service = new InfluencerProfileService();
		service.execute(model);
		
		return "profile";
	}
	
	//구독자수 추천
	@RequestMapping("/")
	public String InfluencerRcmm(Model model) {
		
		System.out.println("---------InfluencerRcmm()-----------");
		service = new InfluencerRcmmService();
		service.execute(model);
		
		return "redirect:index";//메인화면
	}
	
	//인플루언서 신규
	@RequestMapping("/")
	public String InfluencerNews(Model model) {
		
		System.out.println("---------InfluencerNews()-----------");
		service = new InfluencerNewsService();
		service.execute(model);
		
		return "redirect:index";//메인화면
	}
	
	//인플루언서 연관 카테고리 추천-InfluencerRelCatService
	
}
