package prsite.spring.community.dao;

import java.util.ArrayList;
import java.util.Map;

import prsite.spring.dto.CommunityDto;

public interface ICommunityDao {
	//게시글 리스트 가져오기
	//ArrayList<CommunityDto> communitylist();
	//ArrayList<CommunityDto> communitylist(Map<String, Integer> map );
	
	//게시글 등록 처리
	void communityInsert(String id, String title, String content);
	
	//게시글 내용 보기
	CommunityDto contentView(int bno);
	
	//게시글 삭제 처리
	void communityDelete(int bno);
	
	//게시글 수정 처리
	void communityModify(int bno, String title, String content);
	
	//게시글 제목 검색
	ArrayList<CommunityDto> communitySearch(String search);

	ArrayList<CommunityDto> communitylist(Map<String, Object> map);
	
	
	
}
