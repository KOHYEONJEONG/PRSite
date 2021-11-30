package prsite.spring.influencer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.util.ConstantTemplate;

public class InfluencerDao implements IInfluencerDao {
	
	DataSource dataSource;
	JdbcTemplate template;
	
	public InfluencerDao() {
		
		try {
			Context context = new InitialContext();//was와 연결된 context
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/Oracle");//oracle드라이버를 찾음.
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		this.template=ConstantTemplate.template; //공유된 Jdbc Template 사용
	}
	
	@Override
	public void InfluencerInsert(final InfluencerDto influencer) {
		String query = "Insert into influencer(id, cat, info, instagram, youtube, subscnt, instsubs, ytbsubs, memsince) values (?,?,?,?,?,?,?,?,sysdate)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, influencer.getId());
				preparedStatement.setString(2, influencer.getCat());
				preparedStatement.setString(3, influencer.getInfo());
				preparedStatement.setString(4, influencer.getInstagram());
				preparedStatement.setString(5, influencer.getYoutube());
				preparedStatement.setInt(6, influencer.getSubscnt());
				preparedStatement.setInt(7, influencer.getInstsubs());
				preparedStatement.setInt(8, influencer.getYtbsubs());
			}
		});
	}

	@Override
	public void InfluencerUpdate(final InfluencerDto influencer) {
		String query = "update influencer set id=?, cat=?, info=?, instagram=? youtube=?, subscnt=?, instsubs=?, ytbsubs=? where id=?";
		this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, influencer.getId());
				preparedStatement.setString(2, influencer.getCat());
				preparedStatement.setString(3, influencer.getInfo());
				preparedStatement.setString(4, influencer.getInstagram());
				preparedStatement.setString(5, influencer.getYoutube());
				preparedStatement.setInt(6, influencer.getSubscnt());
				preparedStatement.setInt(7, influencer.getInstsubs());
				preparedStatement.setInt(8, influencer.getYtbsubs());
				preparedStatement.setString(9, influencer.getId());
			}
		});
	}

	@Override
	public void InfluencerDelete(final String id) {
		String query="delete from influencer where id=? and influid=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
			public void setValues(PreparedStatement preparedStatement) throws
			SQLException {
				preparedStatement.setString(1, id);
			}
		});
	}

	@Override
	public ArrayList<InfluencerDto> influencerInstaRanking() {
		// 인스타그램 구독자수 기준
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by instsubs desc) where rownum<=10"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}
	
	@Override
	public ArrayList<InfluencerDto> influencerYtbRanking() {
		// 유튜브 구독자수 기준
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by ytbsubs desc) where rownum<=10"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerSearch(String search) {
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from influencer where id like '%" + search + "%'";
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerRcmm() { //SUBCNT
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by subcnt desc) where rownum<=10"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerNews(String cat) { //카테고리별
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat +"' order by memsince desc) where rownum<=10"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerRelCat(String cat) {
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat + "' order by DBMS_RANDOM.RANDOM) where rownum<=10"; // 랜덤 정렬
		return dtos;
	}

	@Override
	public InfluencerDto influencerProfile(String id) {
		String query = "select * from influencer where id =" + id;
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}

}
