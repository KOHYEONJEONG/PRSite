package prsite.spring.community.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.community.dao.CommunityDao;
import prsite.spring.dto.CommunityDto;
import util.Common;
import util.Paging;

public class CommunityListService implements ICommunityService {
	//�Խ��� ����Ʈ ��������

	@Override
	public void execute(Model model) {

		//����¡
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");

		int nowPage =1; //�ƹ��͵� �ȳѾ���� ��. //�⺻��
		
		String page = request.getParameter("page"); 
		if( page != null &&
		 !page.isEmpty()) { nowPage = Integer.parseInt( page ); }
		
		System.out.println("nowPage= "+nowPage+"/ page = "+page); 
		

		//�� �������� ǥ�õǴ� �Խù��� ���۰� ����ȣ�� ���(����)
		int start = (nowPage -1)*Common.Board.BLOCKLIST +1; 
		System.out.println("statr = "+start);
		int end = start + Common.Board.BLOCKLIST -1;
		System.out.println("end = "+end);
		
		//start�� end�� map���� ����
		Map<String, Integer> map2= new HashMap<String, Integer>();
		map2.put("start", start);
		map2.put("end", end);

		CommunityDao comunityDao = new CommunityDao();


		//��ü�Խù� �� ���ϱ�
		int row_total = comunityDao.getRowTotal();


		//���� ������ �޴� ����
		String pageMenu = Paging.getPaging("community",nowPage, row_total,Common.Board.BLOCKLIST,Common.Board.BLOCKPAGE);
		model.addAttribute("pageMenu", pageMenu);

		//����---------------------------------------------		
		//CommunityDao comunityDao = new CommunityDao();

		ArrayList<CommunityDto> dtos = comunityDao.communitylist(map2);

		model.addAttribute("list", dtos);

	}

}
