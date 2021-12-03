package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import prsite.spring.influencer.service.IInfluencerService;
import prsite.spring.influencer.service.InfluencerFashion_BeautyService;
import prsite.spring.influencer.service.InfluencerNewsAllService;
import prsite.spring.influencer.service.InfluencerNewsService;
import prsite.spring.influencer.service.InfluencerProfileService;
import prsite.spring.influencer.service.InfluencerRankingService;
import prsite.spring.influencer.service.InfluencerRcmmService;
import prsite.spring.influencer.service.InfluencerRelCatService;
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

	
	//구독자수 랭킹
	@RequestMapping("inRanking")
	public String inRanking(Model model) {
		
		System.out.println("---------inRanking()-----------");
		service = new InfluencerRankingService();
		service.execute(model);
		
		
		
		return "InfluencerRanking";
	}
	
	
	//index.jsp(메인화면)-----------------------------------------------------------------------------
	//구독자수 추천
	@RequestMapping("index")
	public String InfluencerRcmm(Model model) {
		
		System.out.println("---------InfluencerRcmm() : /index -----------");
		service = new InfluencerRcmmService();//수정
		service.execute(model);
		
		System.out.println("---------InfluencerNews() : /index -----------");
		service = new InfluencerNewsAllService();//수정
		service.execute(model);
		
		return "index";//메인화면
	}
	
	//인플루언서 검색
	@RequestMapping("InfluencerSearch")
	public String InfluencerSearch(Model model, HttpServletRequest Request) {
		
		System.out.println("---------SearchService()-----------");
		service = new InfluencerProfileService();
		service.execute(model);
		
		return "profile";
	}
	
	//--------------------------------------------------------
	//인플루언서 연관 카테고리 추천-InfluencerRelCatService
	@RequestMapping("/test3")
	public String InfluencerRel(Model model) {
		
		System.out.println("---------InfluencerRel()-----------");
		service = new InfluencerRelCatService();//수정
		service.execute(model);
		
		return "redirect:index";//메인화면
	}
	
	//카테고리별 IN버튼 누르면 해당 ID인플루언서 정보 보여지기
	@RequestMapping("/profile")
	public String profile(Model model, HttpServletRequest request) {
		//ID 가져오기
		service = new InfluencerProfileService();
		System.out.println("----profile page----");
		return "profile";
	}
	
	//인플루언서 카테고리별 불러오기
	@RequestMapping("/fashion")
	public String fashion(Model model) {
		
		System.out.println("---------fashion()-----------");
		service = new InfluencerFashion_BeautyService();//수정
		service.execute(model);
		
		return "fashion";//메인화면
	}
	
	
}
