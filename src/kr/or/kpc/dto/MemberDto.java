package kr.or.kpc.dto;

public class MemberDto {

	private int num;
	private String name;
 
	// (alt shft)
	// 디폴트생성자 (c)
	public MemberDto() { 
		super();
	}  

	// 매개변수생성자 (o)
	public MemberDto(int num, String name) { 
		super();
		this.num = num;
		this.name = name;
	}
	
	 // 세터게터 (r + tap + enter + tap*4 + enter)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
