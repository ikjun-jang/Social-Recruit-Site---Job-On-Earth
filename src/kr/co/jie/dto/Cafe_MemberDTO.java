package kr.co.jie.dto;

public class Cafe_MemberDTO {
	
	
	 private int cafe_memberno;
	 private String cafe_member_nick;
	 private String cafe_member_date;
	 private int cafe_member_grade;
	 private String cafe_name;
	
	 public Cafe_MemberDTO(){}

	 public Cafe_MemberDTO(int cafe_memberno, String cafe_member_nick,
			String cafe_member_date, int cafe_member_grade, String cafe_name) {
		super();
		this.cafe_memberno = cafe_memberno;
		this.cafe_member_nick = cafe_member_nick;
		this.cafe_member_date = cafe_member_date;
		this.cafe_member_grade = cafe_member_grade;
		this.cafe_name = cafe_name;
	}

	public int getCafe_memberno() {
		return cafe_memberno;
	}

	public String getCafe_member_nick() {
		return cafe_member_nick;
	}

	public String getCafe_member_date() {
		return cafe_member_date;
	}

	public int getCafe_member_grade() {
		return cafe_member_grade;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_memberno(int cafe_memberno) {
		this.cafe_memberno = cafe_memberno;
	}

	public void setCafe_member_nick(String cafe_member_nick) {
		this.cafe_member_nick = cafe_member_nick;
	}

	public void setCafe_member_date(String cafe_member_date) {
		this.cafe_member_date = cafe_member_date;
	}

	public void setCafe_member_grade(int cafe_member_grade) {
		this.cafe_member_grade = cafe_member_grade;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	
	
	 
	 
	 
	 

}
