package kr.or.ddit.posts.model;

import java.util.Date;

public class PostsVo {
	private int posts_no;
	private String posts_title;
	private String posts_content;
	private Date posts_reg;
	private String posts_yn;
	private int board_no;
	private int posts_no2;
	private int posts_gcode;
	private String mem_id;
	
	
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public PostsVo() {

	}
	
	public int getPosts_no() {
		return posts_no;
	}
	public void setPosts_no(int posts_no) {
		this.posts_no = posts_no;
	}
	public String getPosts_title() {
		return posts_title;
	}
	public void setPosts_title(String posts_title) {
		this.posts_title = posts_title;
	}
	public String getPosts_content() {
		return posts_content;
	}
	public void setPosts_content(String posts_content) {
		this.posts_content = posts_content;
	}

	public Date getPosts_reg() {
		return posts_reg;
	}
	public void setPosts_reg(Date posts_reg) {
		this.posts_reg = posts_reg;
	}
	public String getPosts_yn() {
		return posts_yn;
	}
	public void setPosts_yn(String posts_yn) {
		this.posts_yn = posts_yn;
	}

	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getPosts_no2() {
		return posts_no2;
	}
	public void setPosts_no2(int posts_no2) {
		this.posts_no2 = posts_no2;
	}
	public int getPosts_gcode() {
		return posts_gcode;
	}
	public void setPosts_gcode(int posts_gcode) {
		this.posts_gcode = posts_gcode;
	}


	public PostsVo(int posts_no, String posts_title, String posts_content,
			 Date posts_reg, String posts_yn,
			 int board_no, int posts_no2,
			int posts_gcode, String mem_id) {
		super();
		this.posts_no = posts_no;
		this.posts_title = posts_title;
		this.posts_content = posts_content;

		this.posts_reg = posts_reg;
		this.posts_yn = posts_yn;

		this.board_no = board_no;
		this.posts_no2 = posts_no2;
		this.posts_gcode = posts_gcode;
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "PostsVo [posts_no=" + posts_no + ", posts_title=" + posts_title
				+ ", posts_content=" + posts_content  + ", posts_reg=" + posts_reg + ", posts_yn="
				+ posts_yn 	+ ", board_no=" + board_no
				+ ", posts_no2=" + posts_no2 + ", posts_gcode=" + posts_gcode
				+ ", mem_id=" + mem_id + "]";
	}

	
	
	
	
	
	
}
