package prsite.spring.community.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.CommunityDto;
import prsite.spring.util.ConstantTemplate;

public class CommunityDao implements ICommunityDao {
	
	DataSource dataSource;
	JdbcTemplate template;
	
	public CommunityDao() {
		
		try {
			Context context = new InitialContext();//was�� ����� context
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/Oracle");//oracle����̹��� ã��.
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		this.template=ConstantTemplate.template; //������ Jdbc Template ���
	}

	@Override
	public ArrayList<CommunityDto> communitylist() {
		ArrayList<CommunityDto> dtos = null;
		String query = "select * from community order by bno desc";
		
		dtos= (ArrayList<CommunityDto>)template.query(query, new BeanPropertyRowMapper<CommunityDto>(CommunityDto.class));
		
		return dtos;
	}

	@Override
	public void communityInsert(final String id, final String title, final String content) {
		String query = "Insert into community(bno, id, title, writedate, content) values (community_bno_seq.nextval,?,?,sysdate,?)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, title);
				preparedStatement.setString(3, content);
			}
		});
	}

	@Override
	public CommunityDto contentView(int bno) {
		String query = "select * from community where bno =" + bno;
		CommunityDto communityDto = this.template.queryForObject(query, new BeanPropertyRowMapper<CommunityDto>(CommunityDto.class));
		return communityDto;
	}

	@Override
	public void communityDelete(final int bno) {
		String query="delete from community where bno=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
			public void setValues(PreparedStatement preparedStatement) throws
			SQLException {
				preparedStatement.setInt(1,bno);
			}
		});
	}

	@Override
	public ArrayList<CommunityDto> communitySearch(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void communityModify(final int bno, final String title, final String content) {
		String query = "update community set title=?, content=?, writedate=sysdate where bno=?";
		this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, bno);
				preparedStatement.setString(2, title);
				preparedStatement.setString(3, content);
			}
		});
	}


}
