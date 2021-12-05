package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.service.IInfluencerService;
import prsite.spring.influencer.service.InfluencerFashion_BeautyService;
import prsite.spring.influencer.service.InfluencerNewsAllService;
import prsite.spring.influencer.service.InfluencerNewsService;
import prsite.spring.influencer.service.InfluencerProfileService;
import prsite.spring.influencer.service.InfluencerRankingService;
import prsite.spring.influencer.service.InfluencerRcmmService;
import prsite.spring.influencer.service.InfluencerRelCatService;
import prsite.spring.influencer.service.InfluencerSearchService;
import prsite.spring.util.ConstantTemplate;

@Controller
public class InfluencerController {
	//controller class���� ��� Template����(bean���� ����)
	public JdbcTemplate template;	
	IInfluencerService service;//���÷��
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}

	
	//�����ڼ� ��ŷ(DAO���� ���� ��������)
	@RequestMapping("ranking")
	public String inRanking(Model model) {
		
		System.out.println("---------ranking()-----------");
		service = new InfluencerRankingService();//�ν�Ÿ, ����� ��ŷ
		service.execute(model);
		return "ranking";
	}
	
	
	
	//index.jsp(����ȭ��)-----------------------------------------------------------------------------
	//�����ڼ� ��õ
	@RequestMapping("index")
	public String InfluencerRcmm(Model model) {
		
		System.out.println("---------InfluencerRcmm() : /index -----------");
		service = new InfluencerRcmmService();
		service.execute(model);
		
		System.out.println("---------InfluencerNews() : /index -----------");
		service = new InfluencerNewsAllService();
		service.execute(model);
		
		return "index";//����ȭ��
	}
	
	//���÷�� �˻�
	@RequestMapping("InfluencerSearch")
	public String InfluencerSearch(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("---------SearchService()-----------");
		model.addAttribute("request",request);
		service = new InfluencerSearchService();
		service.execute(model);
		return "redirect:profilepage";
	}
	
	//--------------------------------------------------------
	/*
	 * //���÷�� ���� ī�װ� ��õ-InfluencerRelCatService
	 * 
	 * @RequestMapping("/test3") public String InfluencerRel(Model model) {
	 * 
	 * System.out.println("---------InfluencerRel()-----------"); service = new
	 * InfluencerRelCatService();//���� service.execute(model);
	 * 
	 * return "redirect:index";//����ȭ�� }
	 */
	
	//ī�װ��� IN��ư ������ �ش� ID���÷�� ���� ��������  + ���� ���÷�� ��������(�����ؾ���)
	@RequestMapping("/profilepage")
	public String profilepage(HttpServletRequest request, Model model) {
		System.out.println("----profile page----");
		service = new InfluencerProfileService();
		model.addAttribute("request",request);
		service.execute(model);
		return "profile";
	}

	//���÷�� ī�װ��� �ҷ�����
	@RequestMapping("/fashion")
	public String fashion(Model model) {
		
		System.out.println("---------fashion()-----------");
		service = new InfluencerFashion_BeautyService();
		service.execute(model);
		
		return "fashion";//����ȭ��
	}
	
	
}
