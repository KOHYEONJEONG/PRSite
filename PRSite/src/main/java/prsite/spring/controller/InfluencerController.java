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
	//controller class���� ��� Template����(bean���� ����)
	public JdbcTemplate template;	
	IInfluencerService service;//���÷��
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}

	
	@RequestMapping("inProfile")
	public String inProfile(Model model) {
		
		System.out.println("---------inProfile()-----------");
		service = new InfluencerProfileService();
		service.execute(model);
		
		
		return "InfluencerProfile";
	}
	
	//�����ڼ� ��ŷ
	@RequestMapping("inRanking")
	public String inRanking(Model model) {
		
		System.out.println("---------inRanking()-----------");
		service = new InfluencerRankingService();
		service.execute(model);
		
		
		
		return "InfluencerRanking";
	}
	
	//���÷�� �˻�
	@RequestMapping("InfluencerSearch")
	public String InfluencerSearch(Model model, HttpServletRequest Request) {
		
		System.out.println("---------SearchService()-----------");
		service = new InfluencerProfileService();
		service.execute(model);
		
		return "profile";
	}
	
	//�����ڼ� ��õ
	@RequestMapping("/")
	public String InfluencerRcmm(Model model) {
		
		System.out.println("---------InfluencerRcmm()-----------");
		service = new InfluencerRcmmService();
		service.execute(model);
		
		return "redirect:index";//����ȭ��
	}
	
	//���÷�� �ű�
	@RequestMapping("/")
	public String InfluencerNews(Model model) {
		
		System.out.println("---------InfluencerNews()-----------");
		service = new InfluencerNewsService();
		service.execute(model);
		
		return "redirect:index";//����ȭ��
	}
	
	//���÷�� ���� ī�װ� ��õ-InfluencerRelCatService
	
}
