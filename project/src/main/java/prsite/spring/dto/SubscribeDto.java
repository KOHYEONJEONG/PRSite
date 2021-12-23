package prsite.spring.dto;

import java.sql.Date;

public class SubscribeDto {
	private String id;
	private String influid;
	private Date subsdate;
	
	public SubscribeDto() {
		
	}
	
	public SubscribeDto(String id, String influid, Date subsdate) {
		this.id = id;
		this.influid = influid;
		this.subsdate = subsdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInfluid() {
		return influid;
	}

	public void setInfluid(String influid) {
		this.influid = influid;
	}

	public Date getSubsdate() {
		return subsdate;
	}

	public void setSubsdate(Date subsdate) {
		this.subsdate = subsdate;
	}
	
	
}
