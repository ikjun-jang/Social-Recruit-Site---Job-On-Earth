package kr.co.jie.dto;

public class FriendlistDTO {
	private int friendlist_no;
	private int jobseeker_no;
	private int friendlist_subno;
	private String friendlist_date;
	private String friendlist_type;
	private String friendlist_name;
	private String friendlist_email;
	
	
	
	public FriendlistDTO(int friendlist_no, int jobseeker_no,
			int friendlist_subno, String friendlist_date,
			String friendlist_type, String friendlist_name,
			String friendlist_email) {
		super();
		this.friendlist_no = friendlist_no;
		this.jobseeker_no = jobseeker_no;
		this.friendlist_subno = friendlist_subno;
		this.friendlist_date = friendlist_date;
		this.friendlist_type = friendlist_type;
		this.friendlist_name = friendlist_name;
		this.friendlist_email = friendlist_email;
	}



	public int getFriendlist_no() {
		return friendlist_no;
	}



	public void setFriendlist_no(int friendlist_no) {
		this.friendlist_no = friendlist_no;
	}



	public int getJobseeker_no() {
		return jobseeker_no;
	}



	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}



	public int getFriendlist_subno() {
		return friendlist_subno;
	}



	public void setFriendlist_subno(int friendlist_subno) {
		this.friendlist_subno = friendlist_subno;
	}



	public String getFriendlist_date() {
		return friendlist_date;
	}



	public void setFriendlist_date(String friendlist_date) {
		this.friendlist_date = friendlist_date;
	}



	public String getFriendlist_type() {
		return friendlist_type;
	}



	public void setFriendlist_type(String friendlist_type) {
		this.friendlist_type = friendlist_type;
	}



	public String getFriendlist_name() {
		return friendlist_name;
	}



	public void setFriendlist_name(String friendlist_name) {
		this.friendlist_name = friendlist_name;
	}



	public String getFriendlist_email() {
		return friendlist_email;
	}



	public void setFriendlist_email(String friendlist_email) {
		this.friendlist_email = friendlist_email;
	}



	public FriendlistDTO() {
		super();
	}
	
	
	
	
	
}
