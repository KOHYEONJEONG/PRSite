package prsite.spring.dao;

import java.util.ArrayList;

import prsite.spring.dto.SubscribeDto;

public interface ISubscribeDao {
	//���� �߰�
	void subscribeInsert(String id, String influid);
	
	//���� ���
	void subscribeDelete(String id, String influid);
	
	//���� ����Ʈ ��������
	ArrayList<SubscribeDto> subscribeList (String id);
}
