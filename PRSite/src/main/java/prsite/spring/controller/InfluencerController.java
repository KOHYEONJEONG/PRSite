package prsite.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import prsite.spring.influencer.service.IInfluencerService;
import prsite.spring.influencer.service.InfluencerProfileService;
import prsite.spring.influencer.service.InfluencerRankingService;
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
	
	@RequestMapping("inRanking")
	public String inRanking(Model model) {
		
		System.out.println("---------inRanking()-----------");
		service = new InfluencerRankingService();
		service.execute(model);
		
		return "InfluencerRanking";
	}
	
	//�����ڼ� ��õ-InfluencerRcmmService
	//���÷�� �ű�-InfluencerNewsService
	//���÷�� ���� ī�װ� ��õ-InfluencerRelCatService
	//���÷�� �˻�-InfluencerSearchService
}
