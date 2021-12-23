package prsite.spring.dto;

public class MemberDto {
	private String id;
	private String pwd;
	private String influyn;
	private String name;
	private String filename;
	
	public MemberDto() {
	
	}
	
	public MemberDto(String id, String pwd, String influyn, String name) {
		this.id = id;
		this.pwd = pwd;
		this.influyn = influyn;
		this.name = name;
	}
	
	public MemberDto(String id, String pwd, String influyn, String name, String filename) {
		this.id = id;
		this.pwd = pwd;
		this.influyn = influyn;
		this.name = name;
		this.filename = filename;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getInfluyn() {
		return influyn;
	}
	public void setInfluyn(String influyn) {
		this.influyn = influyn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
