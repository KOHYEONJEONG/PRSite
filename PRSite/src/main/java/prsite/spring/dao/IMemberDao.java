package prsite.spring.dao;

import prsite.spring.dto.MemberDto;

public interface IMemberDao {
	//회원 가입
	void memberInsert(MemberDto member);
	
	//회원 정보 수정
	void memberUpdate(MemberDto member);
	
	//회원 프로필 가져오기
	MemberDto memberProfile(String id);
	
	//회원 로그인
	boolean memberLogin(String id, String pwd);
	
}
