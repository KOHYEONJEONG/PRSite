package prsite.spring.influencer.dao;

import java.util.ArrayList;

import prsite.spring.dto.InfluencerDto;

public interface IInfluencerDao {
	//인플루언서 등록
	void InfluencerInsert(InfluencerDto influencer);
	
	//인플루언서 정보 수정
	void InfluencerUpdate(InfluencerDto influencer);
	
	//인플루언서 삭제
	void InfluencerDelete(String id);
	
	//인플루언서 랭킹 가져오기 - sns별 구독자 순위
	ArrayList<InfluencerDto> influencerInstaRanking();
	ArrayList<InfluencerDto> influencerYtbRanking();
	
	//인플루언서 검색
	InfluencerDto influencerSearch(String search);
	
	//인플루언서 사이트 내 구독자수 추천
	ArrayList<InfluencerDto> influencerRcmm();
	
	//인플루언서 신규 - 카테고리별
	ArrayList<InfluencerDto> influencerNews(String cat);
	
	//인플루언서 연관 카테고리 추천
	ArrayList<InfluencerDto> influencerRelCat(String cat);
	
	//인플루언서 프로필 가져오기
	InfluencerDto influencerProfile(String id);

	ArrayList<InfluencerDto> influencerCat(String cat);
}
