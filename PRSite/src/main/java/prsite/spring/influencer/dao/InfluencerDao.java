package prsite.spring.influencer.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.util.ConstantTemplate;

public class InfluencerDao implements IInfluencerDao {
	
	JdbcTemplate template;
	public InfluencerDao() {
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
	public ArrayList<InfluencerDto> influencerRanking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InfluencerDto> influencerSearch(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InfluencerDto> influencerRcmm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InfluencerDto> influencerNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InfluencerDto> influencerRelCat(String cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfluencerDto influencerProfile(String id) {
		String query = "select * from influencer where id =" + id;
		InfluencerDto influencerDto = this.template.queryForObject(query, new BeanPropertyRowMapper<InfluencerDto>(InfluencerDto.class));
		return influencerDto;
	}

}
