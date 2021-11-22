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
	//controller class에서 명시 Template선언(bean으로 설정)
	public JdbcTemplate template;
	ISubscribeService subService;//구독자
	IInfluencerService inService;//인플루언서
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;

		//모든 클래스에서 사용.
		ConstantTemplate.template = this.template;// static
	}


	
	

}
