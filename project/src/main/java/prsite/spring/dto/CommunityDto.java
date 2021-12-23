package prsite.spring.dto;

import java.sql.Date;

public class CommunityDto {
	private int bno;
	private String id;
	private String title;
	private Date writedate;
	private String content;
	
	public CommunityDto () {
		
	}
	
	public CommunityDto (int bno, String id, String title, Date writedate, String content) {
		this.bno = bno;
		this.id = id;
		this.title = title;
		this.writedate = writedate;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
