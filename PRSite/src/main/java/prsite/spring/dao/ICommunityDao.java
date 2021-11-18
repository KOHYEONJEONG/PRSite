package prsite.spring.dao;

import java.util.ArrayList;

import prsite.spring.dto.CommentsDto;
import prsite.spring.dto.CommunityDto;

public interface ICommunityDao {
	//�Խñ� ����Ʈ ��������
	ArrayList<CommunityDto> communitylist();
	
	//�Խñ� ��� ó��
	void communityInsert(String id, String title, String content);
	
	//�Խñ� ���� ����
	CommunityDto contentView(int bno);
	
	//�Խñ� ���� ó��
	void communityDelete(int bno);
	
	//�Խñ� ���� ó��
	void communityModify(int bno, String title, String content);
	
	//�Խñ� ���� �˻�
	ArrayList<CommunityDto> communitySearch(String search);
	
	
	
}
