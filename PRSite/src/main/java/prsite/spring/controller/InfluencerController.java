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
	//controller class���� ��� Template����(bean���� ����)
	public JdbcTemplate template;	
	IInfluencerService service;//���÷��
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}

	
	//�����ڼ� ��ŷ
	@RequestMapping("inRanking")
	public String inRanking(Model model) {
		
		System.out.println("---------inRanking()-----------");
		service = new InfluencerRankingService();
		service.execute(model);
		
		
		
		return "InfluencerRanking";
	}
	
	
	//index.jsp(����ȭ��)-----------------------------------------------------------------------------
	//�����ڼ� ��õ
	@RequestMapping("index")
	public String InfluencerRcmm(Model model) {
		
		System.out.println("---------InfluencerRcmm() : /index -----------");
		service = new InfluencerRcmmService();//����
		service.execute(model);
		
		System.out.println("---------InfluencerNews() : /index -----------");
		service = new InfluencerNewsAllService();//����
		service.execute(model);
		
		return "index";//����ȭ��
	}
	
	//���÷�� �˻�
	@RequestMapping("InfluencerSearch")
	public String InfluencerSearch(Model model, HttpServletRequest Request) {
		
		System.out.println("---------SearchService()-----------");
		service = new InfluencerProfileService();
		service.execute(model);
		
		return "profile";
	}
	
	//--------------------------------------------------------
	//���÷�� ���� ī�װ� ��õ-InfluencerRelCatService
	@RequestMapping("/test3")
	public String InfluencerRel(Model model) {
		
		System.out.println("---------InfluencerRel()-----------");
		service = new InfluencerRelCatService();//����
		service.execute(model);
		
		return "redirect:index";//����ȭ��
	}
	
	//ī�װ��� IN��ư ������ �ش� ID���÷�� ���� ��������
	@RequestMapping("/profile")
	public String profile(Model model, HttpServletRequest request) {
		//ID ��������
		service = new InfluencerProfileService();
		System.out.println("----profile page----");
		return "profile";
	}
	
	//���÷�� ī�װ��� �ҷ�����
	@RequestMapping("/fashion")
	public String fashion(Model model) {
		
		System.out.println("---------fashion()-----------");
		service = new InfluencerFashion_BeautyService();//����
		service.execute(model);
		
		return "fashion";//����ȭ��
	}
	
	
}
