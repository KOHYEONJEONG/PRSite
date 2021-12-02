package prsite.spring.dto;

import java.sql.Date;

public class InfluencerDto {
	private String id;
	private String cat;
	private String info;
	private String instagram;
	private String youtube;
	private int subscnt;
	private int instsubs;
	private int ytbsubs;
	private Date memsince;
	
	public InfluencerDto() {
		
	}
	
	//∞°¿‘
	public InfluencerDto(String id, String cat, String info, String instagram, String youtube, int instsubs,
			int ytbsubs) {
		super();
		this.id = id;
		this.cat = cat;
		this.info = info;
		this.instagram = instagram;
		this.youtube = youtube;
		this.instsubs = instsubs;
		this.ytbsubs = ytbsubs;
	}

	public InfluencerDto(String id, String cat, String info, String instagram, String youtube, int subscnt,
			int instsubs, int ytbsubs, Date memsince) {
		super();
		this.id = id;
		this.cat = cat;
		this.info = info;
		this.instagram = instagram;
		this.youtube = youtube;
		this.subscnt = subscnt;
		this.instsubs = instsubs;
		this.ytbsubs = ytbsubs;
		this.memsince = memsince;
	}
	
	public InfluencerDto(String id, String info) {
		super();
		this.id = id;
		this.info = info;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public int getSubscnt() {
		return subscnt;
	}

	public void setSubscnt(int subscnt) {
		this.subscnt = subscnt;
	}

	public int getInstsubs() {
		return instsubs;
	}

	public void setInstsubs(int instsubs) {
		this.instsubs = instsubs;
	}

	public int getYtbsubs() {
		return ytbsubs;
	}

	public void setYtbsubs(int ytbsubs) {
		this.ytbsubs = ytbsubs;
	}

	public Date getMemsince() {
		return memsince;
	}

	public void setMemsince(Date memsince) {
		this.memsince = memsince;
	}
	
	
}
