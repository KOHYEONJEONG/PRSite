package prsite.spring.dao;

import java.util.ArrayList;

import prsite.spring.dto.InfluencerDto;

public interface IInfluencerDao {
	//���÷�� ���
	void InfluencerInsert(InfluencerDto influencer);
	
	//���÷�� ���� ����
	void InfluencerUpdate(InfluencerDto influencer);
	
	//���÷�� ����
	void InfluencerDelete(String id);
	
	//���÷�� ��ŷ ��������
	ArrayList<InfluencerDto> influencerRanking();
	
	//���÷�� �˻�
	ArrayList<InfluencerDto> influencerSearch(String search);
	
	//���÷�� �����ڼ� ��õ
	ArrayList<InfluencerDto> influencerRcmm();
	
	//���÷�� �ű�
	ArrayList<InfluencerDto> influencerNews();
	
	//���÷�� ���� ī�װ� ��õ
	ArrayList<InfluencerDto> influencerRelCat(String cat);
	
	//���÷�� ������ ��������
	InfluencerDto influencerProfile(String id);
}
