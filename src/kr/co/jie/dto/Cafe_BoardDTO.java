package kr.co.jie.dto;

public class Cafe_BoardDTO {
	
	private int b_no;
	private String b_writer;
	private String b_title;
	private String b_content;
	private String b_image;
	private String b_date;
	private int b_hit;
	private int b_status;
	private int b_recom;
	private int permission;
	private String cafe_name;
	private int cafe_b_no;
	
	public Cafe_BoardDTO(){}

	public Cafe_BoardDTO(int b_no, String b_writer, String b_title,
			String b_content, String b_image, String b_date, int b_hit,
			int b_status, int b_recom, int permission, String cafe_name,
			int cafe_b_no) {
		super();
		this.b_no = b_no;
		this.b_writer = b_writer;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_image = b_image;
		this.b_date = b_date;
		this.b_hit = b_hit;
		this.b_status = b_status;
		this.b_recom = b_recom;
		this.permission = permission;
		this.cafe_name = cafe_name;
		this.cafe_b_no = cafe_b_no;
	}

	public int getB_no() {
		return b_no;
	}

	public String getB_writer() {
		return b_writer;
	}

	public String getB_title() {
		return b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public String getB_image() {
		return b_image;
	}

	public String getB_date() {
		return b_date;
	}

	public int getB_hit() {
		return b_hit;
	}

	public int getB_status() {
		return b_status;
	}

	public int getB_recom() {
		return b_recom;
	}

	public int getPermission() {
		return permission;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public int getCafe_b_no() {
		return cafe_b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public void setB_image(String b_image) {
		this.b_image = b_image;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}

	public void setB_status(int b_status) {
		this.b_status = b_status;
	}

	public void setB_recom(int b_recom) {
		this.b_recom = b_recom;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public void setCafe_b_no(int cafe_b_no) {
		this.cafe_b_no = cafe_b_no;
	}

	
	
	


	
	
	
	
	
	

}
