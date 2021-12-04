package prsite.spring.community.dao;

import java.util.ArrayList;
import java.util.Map;

import prsite.spring.dto.CommunityDto;

public interface ICommunityDao {
	//�Խñ� ����Ʈ ��������
	//ArrayList<CommunityDto> communitylist();
	//ArrayList<CommunityDto> communitylist(Map<String, Integer> map );
	
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

	ArrayList<CommunityDto> communitylist(Map<String, Object> map);
	
	
	
}
