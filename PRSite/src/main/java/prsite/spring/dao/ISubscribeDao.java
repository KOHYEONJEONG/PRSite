package prsite.spring.dao;

import java.util.ArrayList;

import prsite.spring.dto.SubscribeDto;

public interface ISubscribeDao {
	//구독 추가
	void subscribeInsert(String id, String influid);
	
	//구독 취소
	void subscribeDelete(String id, String influid);
	
	//구독 리스트 가져오기
	ArrayList<SubscribeDto> subscribeList (String id);
}
