package prsite.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import prsite.spring.influencer.dao.IInfluencerDao;
import prsite.spring.influencer.service.IInfluencerService;
import prsite.spring.member.service.MemberloginService;
import prsite.spring.subscribe.service.ISubscribeService;
import prsite.spring.util.ConstantTemplate;

@Controller
public class InfluencerController {
	//controller class���� ��� Template����(bean���� ����)
	public JdbcTemplate template;
	ISubscribeService subService;//������
	IInfluencerService inService;//���÷��
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//��� Ŭ�������� ���.
		ConstantTemplate.template = this.template;// static
	}


	
	

}
