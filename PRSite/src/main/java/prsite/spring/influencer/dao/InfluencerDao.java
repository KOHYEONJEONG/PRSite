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
			Context context = new InitialContext();//was�� ����� context
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/Oracle");//oracle����̹��� ã��.
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		this.template=ConstantTemplate.template; //������ Jdbc Template ���
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
		//�̽� : ������ id�� ȫ������Ʈ ������ ���� ������ �� �ְ� �Ǿ ������!
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
		//���÷�� PRSite ������ �� ����.
		
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
		//���÷�� ������ �� ����( ���� ��� �ؼ� )
		String query="delete from influencer set SUBSCNT = SUBSCNT-1 where id=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
			public void setValues(PreparedStatement preparedStatement) throws
			SQLException {
				preparedStatement.setString(1, id);
			}
		});
	}

	//��ŷȭ��-------------------------------------------
	@Override
	public ArrayList<InfluencerDto> influencerInstaRanking() {
		// �ν�Ÿ�׷� �����ڼ� ����
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by instsubs desc) where rownum<=10"; //���� 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}
	
	@Override
	public ArrayList<InfluencerDto> influencerYtbRanking() {
		// ��Ʃ�� �����ڼ� ����
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by ytbsubs desc) where rownum<=10"; //���� 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}
	//---------------------------------------------
	
	//�˻�-------------------------------------------
	@Override
	public InfluencerDto influencerSearch(String search) {
		String query = "select * from influencer where id like '" + search + "'";
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}
	//---------------------------------------------
	
	@Override
	public ArrayList<InfluencerDto> influencerRcmm() { //����Ʈ �� ������ ���� =>index
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer order by subscnt desc) where rownum<=4"; //���� 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("influencerRcmm() : "+dtos.size()); 
		System.out.println("influencerRcmm() : "+dtos.get(0).getId()); 
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerNews(String cat) { //ī�װ��� �ű� (: �ֽ� 5�� )��õ => ī�װ��� ������ ��
		//memsince : ���Գ�¥
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat +"' order by memsince desc) where rownum<=5"; //���� 10
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("����(hot):influencerNews() : "+dtos.size());
		System.out.println("���� :influencerNews() : "+dtos.get(0).getId());
		return dtos;
	}
	
	public ArrayList<InfluencerDto> influencerNewsAll() { //ī�װ��� �ű� (: �ֽ� 5�� )��õ => index : ���� ������
		//memsince : ���Գ�¥
		ArrayList<InfluencerDto>dtos = null;
		String query = "select * from ( select * from influencer order by memsince desc) where rownum<=5";//���� 5
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		System.out.println("����(today):influencerNewsAll() : "+dtos.size()); 
		System.out.println("���� :influencerNewsAll() : "+dtos.get(0).getId()); 
		return dtos;
	}

	@Override
	public ArrayList<InfluencerDto> influencerCat(String cat) {//���� ����. ī�װ����� �ش��ϴ� ���÷�𼭸� ��ü
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from influencer where cat Like '"+ cat +"'";
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return dtos;
	}
	
	@Override
	public ArrayList<InfluencerDto> influencerRelCat(String cat) {//profile.jsp�� ���� ī�װ� ���÷�𼭵� ������  
		ArrayList<InfluencerDto> dtos = null;
		String query = "select * from ( select * from influencer where cat like '" + cat + "' order by DBMS_RANDOM.VALUE(1, (select count(*) from influencer))) where rownum<=5"; // ���� ����
		dtos= (ArrayList<InfluencerDto>)template.query(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		
		return dtos;
	}

	@Override
	public InfluencerDto influencerProfile(String id) {//���������� + profile.jsp�� ��.
		String query = "select * from influencer where id ='" + id + "'";
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}

}
