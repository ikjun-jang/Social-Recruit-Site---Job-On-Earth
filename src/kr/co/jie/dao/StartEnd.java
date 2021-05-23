package kr.co.jie.dao;

public class StartEnd {
	private int start;
	private int end;
	private int job_no;
	private String keyword;
	
	public StartEnd() {

	}
	
	public StartEnd(String keyword) {
		this.keyword = keyword;
	}

	public StartEnd(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public StartEnd(int start, int end, String keyword) {
		this.start = start;
		this.end = end;
		this.keyword = keyword;
	}
	
	public StartEnd(int start, int end, int job_no) {
		super();
		this.start = start;
		this.end = end;
		this.job_no = job_no;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getJob_no() {
		return job_no;
	}

	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}
	
	
}
