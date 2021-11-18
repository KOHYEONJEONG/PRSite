package prsite.spring.dao;

import prsite.spring.dto.MemberDto;

public interface IMemberDao {
	//ȸ�� ����
	void memberInsert(MemberDto member);
	
	//ȸ�� ���� ����
	void memberUpdate(MemberDto member);
	
	//ȸ�� ������ ��������
	MemberDto memberProfile(String id);
	
	//ȸ�� �α���
	boolean memberLogin(String id, String pwd);
	
}
