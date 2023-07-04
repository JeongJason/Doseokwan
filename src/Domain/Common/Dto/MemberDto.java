package Domain.Common.Dto;
//회원가입 dto
public class MemberDto {
	private String id; 	// 회원가입 아이디
	private String pw;	// 회원가입 패스워드
	private String hp;	// 휴대폰번호
	private String addr; // 회원가입 주소
	private String role;
	
	public MemberDto() {
		super();
	}

	public MemberDto(String id, String pw, String pw_check, String hp, String addr, String role) {
		super();
		this.id = id;
		this.pw = pw;
		
		this.hp = hp;
		this.addr = addr;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", hp=" + hp + ", addr=" + addr
				+ ", role=" + role + "]";
	}

	
	
	
	
}
