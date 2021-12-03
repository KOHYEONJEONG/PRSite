package prsite.spring.influencer.dao;

import java.util.ArrayList;

import prsite.spring.dto.InfluencerDto;

public interface IInfluencerDao {
	//���÷�� ���
	void InfluencerInsert(InfluencerDto influencer);
	
	//���÷�� ���� ����
	void InfluencerUpdate(InfluencerDto influencer);
	
	//���÷�� ����
	void InfluencerDelete(String id);
	
	//���÷�� ��ŷ �������� - sns�� ������ ����
	ArrayList<InfluencerDto> influencerInstaRanking();
	ArrayList<InfluencerDto> influencerYtbRanking();
	
	//���÷�� �˻�
	InfluencerDto influencerSearch(String search);
	
	//���÷�� ����Ʈ �� �����ڼ� ��õ
	ArrayList<InfluencerDto> influencerRcmm();
	
	//���÷�� �ű� - ī�װ���
	ArrayList<InfluencerDto> influencerNews(String cat);
	
	//���÷�� ���� ī�װ� ��õ
	ArrayList<InfluencerDto> influencerRelCat(String cat);
	
	//���÷�� ������ ��������
	InfluencerDto influencerProfile(String id);

	ArrayList<InfluencerDto> influencerCat(String cat);
}
