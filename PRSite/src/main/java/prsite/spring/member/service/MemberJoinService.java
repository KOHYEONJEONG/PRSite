package prsite.spring.member.service;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class MemberJoinService implements IMemberService {
// ȸ������
	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		//Member ���̺� �� ȸ�� �⺻ ���� 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String influyn = request.getParameter("influyn");
		String name = request.getParameter("nickname");
		//Member DBó��
		MemberDto member =new  MemberDto(id ,pwd,influyn, name);
		MemberDao dao = new MemberDao();
		dao.memberInsert(member);
		System.out.println("MemberDao memberInsert success");
		
		//Influencer ���̺� �� ���� 
		if(influyn.equals("y")) {
			System.out.println("influyn==y");
			
			String cat = request.getParameter("category");
			String info = request.getParameter("info");
			String instagram = request.getParameter("instagram");
			String youtube = request.getParameter("youtube");
			int instsubs = Integer.parseInt(request.getParameter("instsubs"));
			int ytsubs = Integer.parseInt(request.getParameter("ytsubs"));

			InfluencerDto influencerdto =new  InfluencerDto(id, cat, info, instagram, youtube,instsubs, ytsubs);
			InfluencerDao influencerdao = new InfluencerDao();
			influencerdao.InfluencerInsert(influencerdto);
			System.out.println("influencerdao insert success");
		}
				
	}

	@Override
	public boolean getResult() {
		// TODO Auto-generated method stub
		return false;
	}

}
