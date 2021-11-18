package prsite.spring.dto;

import java.sql.Date;

public class CommentsDto {
	private int cno;
	private int bno;
	private String id;
	private Date writedate;
	private String content;
	
	public CommentsDto () {
		
	}
	
public CommentsDto (int cno, int bno, String id, Date writedate, String content) {
		
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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
