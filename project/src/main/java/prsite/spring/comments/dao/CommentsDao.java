package prsite.spring.comments.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.CommentsDto;
import prsite.spring.util.ConstantTemplate;

public class CommentsDao implements ICommentsDao {
	
	JdbcTemplate template;
	public CommentsDao() {
		this.template=ConstantTemplate.template; //공유된 Jdbc Template 사용
	}

	@Override
	public ArrayList<CommentsDto> commentslist(int bno) {
		ArrayList<CommentsDto>dtos = null;
		String query = "select * from comments where bno="+ bno +" order by cno desc";
		dtos= (ArrayList<CommentsDto>)template.query(query, new BeanPropertyRowMapper<CommentsDto>(CommentsDto.class));
		return dtos;
	}

	@Override
	public void commentsInsert(final int bno, final String id, final String content) {		
		String query = "Insert into comments (cno, bno, id, content) values (comments_cno_seq.nextval,?,?,?)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, bno);
				preparedStatement.setString(2, id);
				preparedStatement.setString(3, content);
			}
		});
	}

	@Override
	public void commentsDelete(final int cno) {
		String query="delete from comments where cno=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
			public void setValues(PreparedStatement preparedStatement) throws
			SQLException {
				preparedStatement.setInt(1,cno);
			}
		});
	}

}
