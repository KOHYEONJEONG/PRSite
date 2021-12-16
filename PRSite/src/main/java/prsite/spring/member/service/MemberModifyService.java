package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class MemberModifyService implements IMemberService {
	//ȸ�� ���� ����

	@Override
	public void execute(Model model) {
		//map(Ű,��) , �ߺ�Ű�δ� ���� ���� ����.
		Map<String, Object>map = model.asMap();//model�� map���� ��ȯ�Ͽ� ��ü�� ����.

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key���� ���� value�� ������.
	
		//"update member set pwd=?, influyn=?, name=? where id=?";
		//�Ϲ�ȸ������ ����
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String influyn = request.getParameter("influyn");
		String name = request.getParameter("nickname");
		String filename = request.getParameter("filename");
		
		//Member DB ó��
		MemberDto member =new  MemberDto(id ,pwd,influyn, name,filename);
		MemberDao dao = new MemberDao();
		dao.memberUpdate(member);
		System.out.println("MemberDao UPDATE success");
		
		//���÷�� ���� ����
		//"update influencer set cat=?, info=?, instagram=? youtube=?, instsubs=?, ytbsubs=? where id=?";
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
			
			
			influencerdao.InfluencerUpdate(influencerdto);
			System.out.println("influencerdao UPDATE success");
		}
		
		
	}

	@Override
	public boolean getResult() {
		// TODO Auto-generated method stub
		return false;
	}

}
