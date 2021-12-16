package prsite.spring.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class MemberModifyService implements IMemberService {
	//회원 정보 수정

	@Override
	public void execute(Model model) {
		//map(키,값) , 중복키로는 값을 정의 못함.
		Map<String, Object>map = model.asMap();//model을 map으로 변환하여 객체를 저장.

		HttpServletRequest request = (HttpServletRequest)map.get("request");//key값을 통해 value를 가져옴.
	
		//"update member set pwd=?, influyn=?, name=? where id=?";
		//일반회원정보 수정
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String influyn = request.getParameter("influyn");
		String name = request.getParameter("nickname");
		String filename = request.getParameter("filename");
		
		//Member DB 처리
		MemberDto member =new  MemberDto(id ,pwd,influyn, name,filename);
		MemberDao dao = new MemberDao();
		dao.memberUpdate(member);
		System.out.println("MemberDao UPDATE success");
		
		//인플루언서 정보 수정
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
