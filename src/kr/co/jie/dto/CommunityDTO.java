package kr.co.jie.dto;

public class CommunityDTO {
	
	private String cafe_name;
	private String cafe_addr;
	private String cafe_nick;
	private String cafe_sort1;
	private String cafe_sort2;
	private String cafe_keyword;
	private String cafe_img;
	private String cafe_born_date;
	private int jobseeker_no;
	private int member_count;
	/*private int cafe_member_count; 
	private String cafe_member_nick;
	private String cafe_member_date; 
	private int cafe_member_grade;*/
	
	
	
	public CommunityDTO(){}
	
	public CommunityDTO(String cafe_name, String cafe_addr, String cafe_nick,
			String cafe_sort1, String cafe_sort2, String cafe_keyword,
			String cafe_img, String cafe_born_date, int jobseeker_no,
			int member_count) {
		super();
		this.cafe_name = cafe_name;
		this.cafe_addr = cafe_addr;
		this.cafe_nick = cafe_nick;
		this.cafe_sort1 = cafe_sort1;
		this.cafe_sort2 = cafe_sort2;
		this.cafe_keyword = cafe_keyword;
		this.cafe_img = cafe_img;
		this.cafe_born_date = cafe_born_date;
		this.jobseeker_no = jobseeker_no;
		this.member_count = member_count;
	}
	
	
	public String getCafe_name() {
		return cafe_name;
	}
	public String getCafe_addr() {
		return cafe_addr;
	}
	public String getCafe_nick() {
		return cafe_nick;
	}
	public String getCafe_sort1() {
		return cafe_sort1;
	}
	public String getCafe_sort2() {
		return cafe_sort2;
	}
	public String getCafe_keyword() {
		return cafe_keyword;
	}
	public String getCafe_img() {
		return cafe_img;
	}
	public String getCafe_born_date() {
		return cafe_born_date;
	}
	public int getJobseeker_no() {
		return jobseeker_no;
	}
	public int getMember_count() {
		return member_count;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public void setCafe_addr(String cafe_addr) {
		this.cafe_addr = cafe_addr;
	}
	public void setCafe_nick(String cafe_nick) {
		this.cafe_nick = cafe_nick;
	}
	public void setCafe_sort1(String cafe_sort1) {
		this.cafe_sort1 = cafe_sort1;
	}
	public void setCafe_sort2(String cafe_sort2) {
		this.cafe_sort2 = cafe_sort2;
	}
	public void setCafe_keyword(String cafe_keyword) {
		this.cafe_keyword = cafe_keyword;
	}
	public void setCafe_img(String cafe_img) {
		this.cafe_img = cafe_img;
	}
	public void setCafe_born_date(String cafe_born_date) {
		this.cafe_born_date = cafe_born_date;
	}
	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}
	public void setMember_count(int member_count) {
		this.member_count = member_count;
	}
	
	
	
	
	

	
	

}
