package prsite.spring.comments.dao;

import java.util.ArrayList;

import prsite.spring.dto.CommentsDto;

public interface ICommentsDao {
	//��� ��������
	ArrayList<CommentsDto> commentslist(int bno);
	
	//��� ��� ó��
	void commentsInsert(int bno, String id, String content);
	
	//��� ���� ó��
	void commentsDelete(int cno);
}
