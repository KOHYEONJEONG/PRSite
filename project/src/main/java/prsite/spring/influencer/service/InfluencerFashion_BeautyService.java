package prsite.spring.influencer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class InfluencerFashion_BeautyService implements IInfluencerService {
	//�м�&��Ƽ ī�װ� ������ ��.

	@Override
	public void execute(Model model) {
			
		ArrayList<HashMap<String, String>> hashlist = new ArrayList<HashMap<String, String>>();
		
		InfluencerDao influencerDao =  new InfluencerDao();
		
		ArrayList<InfluencerDto> dtos = influencerDao.influencerCat("fashion_beauty");
		
		MemberDao dao = new MemberDao();
		for (InfluencerDto influencerDto : dtos) {
			HashMap<String, String> hash = new HashMap<String, String>();
			hash.put("id",influencerDto.getId());
			hash.put("info",influencerDto.getInfo());
			hash.put("name",dao.memberName(influencerDto.getId()));//Member���̺��� �̸��� ��������.
			hashlist.add(hash);
		}
		
		model.addAttribute("catAlllist", hashlist);

	}

}
