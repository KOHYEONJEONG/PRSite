package prsite.spring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.SubscribeDto;
import prsite.spring.util.ConstantTemplate;

public class SubscribeDao implements ISubscribeDao {
	
	JdbcTemplate template;
	public SubscribeDao() {
		this.template=ConstantTemplate.template; //공유된 Jdbc Template 사용
	}

	@Override
	public void subscribeInsert(final String id, final String influid) {
		String query = "Insert into subscribe (id, influid, subsdate) values (?,?, sysdate)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, influid);
			}
		});
	}

	@Override
	public void subscribeDelete(final String id, final String influid) {
		String query="delete from subscribe where id=? and influid=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
			public void setValues(PreparedStatement preparedStatement) throws
			SQLException {
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, influid);
			}
		});
	}

	@Override
	public ArrayList<SubscribeDto> subscribeList(String id) {
		ArrayList<SubscribeDto>dtos = null;
		String query = "select * from subscribe order by subsdate";
		dtos= (ArrayList<SubscribeDto>)template.query(query, new BeanPropertyRowMapper<SubscribeDto>(SubscribeDto.class));
		return dtos;
	}

}
