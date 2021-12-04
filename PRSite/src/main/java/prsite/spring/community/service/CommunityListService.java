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
	//게시판 리스트 가져오기

	@Override
	public void execute(Model model) {

		//페이징
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");

		int nowPage =1; //아무것도 안넘어왔을 때. //기본값
		
		String page = request.getParameter("page"); 
		if( page != null &&
		 !page.isEmpty()) { nowPage = Integer.parseInt( page ); }
		
		System.out.println("nowPage= "+nowPage+"/ page = "+page); 
		

		//한 페이지에 표시되는 게시물의 시작과 끝번호를 계산(공식)
		int start = (nowPage -1)*Common.Board.BLOCKLIST +1; 
		System.out.println("statr = "+start);
		int end = start + Common.Board.BLOCKLIST -1;
		System.out.println("end = "+end);
		
		//start와 end를 map으로 묶음
		Map<String, Integer> map2= new HashMap<String, Integer>();
		map2.put("start", start);
		map2.put("end", end);

		CommunityDao comunityDao = new CommunityDao();


		//전체게시물 수 구하기
		int row_total = comunityDao.getRowTotal();


		//현재 페이지 메뉴 생성
		String pageMenu = Paging.getPaging("community",nowPage, row_total,Common.Board.BLOCKLIST,Common.Board.BLOCKPAGE);
		model.addAttribute("pageMenu", pageMenu);

		//기존---------------------------------------------		
		//CommunityDao comunityDao = new CommunityDao();

		ArrayList<CommunityDto> dtos = comunityDao.communitylist(map2);

		model.addAttribute("list", dtos);

	}

}
