package prsite.spring.influencer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
		String query = "Insert into influencer(id, cat, info, instagram, youtube, instsubs, ytbsubs, memsince) values (?,?,?,?,?,?,?,sysdate)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, influencer.getId());
				preparedStatement.setString(2, influencer.getCat());
				preparedStatement.setString(3, influencer.getInfo());
				preparedStatement.setString(4, influencer.getInstagram());
				preparedStatement.setString(5, influencer.getYoutube());
				preparedStatement.setInt(6, influencer.getInstsubs());
				preparedStatement.setInt(7, influencer.getYtbsubs());
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
	public InfluencerDto influencerSearch(String search) {
		String query = "select * from influencer where id like '" + search + "'";
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}

	@Override
	public ArrayList<InfluencerDto> influencerRcmm() { //사이트 내 구독자 순위 =>index
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by subscnt desc) where rownum<=4"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("influencerRcmm() : "+dtos.size()); 
		System.out.println("influencerRcmm() : "+dtos.get(0).getId()); 
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerNews(String cat) { //카테고리별 신규 (: 최신 5인 )추천 => 카테고리별 페이지 내
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat +"' order by memsince desc) where rownum<=5"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("influencerNews() : "+dtos.size());
		System.out.println("influencerNews() : "+dtos.get(0).getId());
		return dtos;
	}
	
	public ArrayList<InfluencerDto> influencerNewsAll() { //카테고리별 신규 (: 최신 5인 )추천 => index : 메인 페이지
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer order by memsince desc) where rownum<=5"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("influencerNewsAll() : "+dtos.size()); 
		System.out.println("influencerNewsAll() : "+dtos.get(0).getId()); 
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerCat(String cat) {//현정 만듬. 카테고리별로 해당하는 인플루언서만 전체
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from influencer where cat = '"+ cat +"'"; // 랜덤 정렬
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
	public InfluencerDto influencerProfile(String id) {//마이페이지 + profile.jsp에 들어감.
		String query = "select * from influencer where id ='" + id + "'";
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}

}
