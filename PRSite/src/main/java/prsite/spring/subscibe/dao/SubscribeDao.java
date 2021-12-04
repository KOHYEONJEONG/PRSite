package prsite.spring.subscibe.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.SubscribeDto;
import prsite.spring.util.ConstantTemplate;

public class SubscribeDao implements ISubscribeDao {
	
	JdbcTemplate template;
	DataSource dataSource;
	
	public SubscribeDao() {
		
		try {
			Context context = new InitialContext();//was�� ����� context
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/Oracle");//oracle����̹��� ã��.
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		this.template=ConstantTemplate.template; //������ Jdbc Template ���
	}

	@Override
	public void subscribeInsert(final String id, final String influid) {//������ �߰�
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
	public void subscribeDelete(final String id, final String influid) {//���� ���
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
	public ArrayList<SubscribeDto> subscribeList(String Userid) {//������ ����Ʈ ��������
		ArrayList<SubscribeDto>dtos = null;
		String query = "select * from subscribe where id = '"+Userid+"' order by subsdate";
		dtos= (ArrayList<SubscribeDto>)template.query(query, new BeanPropertyRowMapper<SubscribeDto>(SubscribeDto.class));
		return dtos;
	}

}
