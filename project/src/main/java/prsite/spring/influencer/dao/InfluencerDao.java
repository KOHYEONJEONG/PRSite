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
		//이슈 : 기존에 id랑 홍보사이트 구독자 수도 변경할 수 있게 되어서 지웠음!
		String query = "update influencer set cat=?, info=?, instagram=?, youtube=?, instsubs=?, ytbsubs=? where id=?";
		this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, influencer.getCat());
				preparedStatement.setString(2, influencer.getInfo());
				preparedStatement.setString(3, influencer.getInstagram());
				preparedStatement.setString(4, influencer.getYoutube());
				preparedStatement.setInt(5, influencer.getInstsubs());
				preparedStatement.setInt(6, influencer.getYtbsubs());
				preparedStatement.setString(7, influencer.getId());
			}
		});
	}
	
	@Override
	public void InfluencerSubUpdate(final String Iid) {
		//인플루언서 PRSite 구독자 수 증가.
		
		String query = "update influencer set SUBSCNT = SUBSCNT+1 where id=?";
		this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, Iid);
			}
		});
	}
	

	@Override
	public void InfluencerDelete(final String id) {
		//인플루언서 구독자 수 감소( 구독 취소 해서 )
		String query="delete from influencer set SUBSCNT = SUBSCNT-1 where id=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
			public void setValues(PreparedStatement preparedStatement) throws
			SQLException {
				preparedStatement.setString(1, id);
			}
		});
	}

	//랭킹화면-------------------------------------------
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
	//---------------------------------------------
	
	//검색-------------------------------------------
	@Override
	public InfluencerDto influencerSearch(String search) {
		String query = "select * from influencer where id like '" + search + "'";
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}
	//---------------------------------------------
	
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
		//memsince : 가입날짜
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat +"' order by memsince desc) where rownum<=5"; //상위 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("메인(hot):influencerNews() : "+dtos.size());
		System.out.println("메인 :influencerNews() : "+dtos.get(0).getId());
		return dtos;
	}
	
	public ArrayList<InfluencerDto> influencerNewsAll() { //카테고리별 신규 (: 최신 5인 )추천 => index : 메인 페이지
		//memsince : 가입날짜
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer order by memsince desc) where rownum<=5";//상위 5
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("메인(today):influencerNewsAll() : "+dtos.size()); 
		System.out.println("메인 :influencerNewsAll() : "+dtos.get(0).getId()); 
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerCat(String cat) {//현정 만듬. 카테고리별로 해당하는 인플루언서만 전체
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from influencer where cat Like '"+ cat +"'";
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}
	
	@Override
	public ArrayList<InfluencerDto> influencerRelCat(String cat) {//profile.jsp에 동일 카테고리 인플루언서도 나오게  
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat + "' order by DBMS_RANDOM.VALUE(1, (select count(*) from influencer))) where rownum<=5"; // 랜덤 정렬
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		
		return dtos;
	}

	@Override
	public InfluencerDto influencerProfile(String id) {//마이페이지 + profile.jsp에 들어감.
		String query = "select * from influencer where id ='" + id + "'";
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}

}
