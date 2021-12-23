package prsite.spring.comments.dao;

import java.util.ArrayList;

import prsite.spring.dto.CommentsDto;

public interface ICommentsDao {
	//´ñ±Û °¡Á®¿À±â
	ArrayList<CommentsDto> commentslist(int bno);
	
	//´ñ±Û µî·Ï Ã³¸®
	void commentsInsert(int bno, String id, String content);
	
	//´ñ±Û »èÁ¦ Ã³¸®
	void commentsDelete(int cno);
}
