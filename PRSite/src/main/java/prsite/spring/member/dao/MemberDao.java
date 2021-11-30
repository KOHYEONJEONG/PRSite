package prsite.spring.member.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.MemberDto;
import prsite.spring.util.ConstantTemplate;

public class MemberDao implements IMemberDao {
	
	JdbcTemplate template;
	DataSource dataSource;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();//was와 연결된 context
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/Oracle");//oracle드라이버를 찾음.
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		this.template=ConstantTemplate.template; //공유된 Jdbc Template 사용
	}

	@Override
	public void memberInsert(final MemberDto member) {
		String query = "Insert into member(id, pwd, influyn, name) values (?,?,?,?)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, member.getId());
				preparedStatement.setString(2, member.getPwd());
				preparedStatement.setString(3, member.getInfluyn());
				preparedStatement.setString(4, member.getName());
			}
		});

	}

	@Override
	public void memberUpdate(final MemberDto member) {//회원정보수정
		String query = "update member set pwd=?, influyn=?, name=? where id=?";
		this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, member.getId());
				preparedStatement.setString(2, member.getPwd());
				preparedStatement.setString(3, member.getInfluyn());
				preparedStatement.setString(4, member.getName());
				preparedStatement.setString(5, member.getId());
			}
		});
	}

	@Override
	public MemberDto memberProfile(String id) {//회원정보 가져오기
		String query = "select * from member where id =" + id;
		MemberDto memberdto = this.template.queryForObject(query, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));
		
		return memberdto;
	}

	@Override
	public boolean memberLogin(String id, String pwd) {
		String query = "select pwd from member where id =" + id;
		String password = this.template.queryForObject(query, String.class);
		
		if (password.equals(password) ) return true;
		else return false;
	}
	
	

}
