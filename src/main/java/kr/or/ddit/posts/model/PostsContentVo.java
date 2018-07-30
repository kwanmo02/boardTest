package kr.or.ddit.posts.model;

import java.util.Date;


public class PostsContentVo {
	private int comment_no;
	private int posts_no;
	private Date comment_reg;
	private String comment_del_yn;
	private String comment_content;
	private String mem_id;
	
	
	public PostsContentVo() {
		
	}
	
	
	
	
	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getPosts_no() {
		return posts_no;
	}
	public void setPosts_no(int posts_no) {
		this.posts_no = posts_no;
	}
	public Date getComment_reg() {
		return comment_reg;
	}
	public void setComment_reg(Date comment_reg) {
		this.comment_reg = comment_reg;
	}
	public String getComment_del_yn() {
		return comment_del_yn;
	}
	public void setComment_del_yn(String comment_del_yn) {
		this.comment_del_yn = comment_del_yn;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public PostsContentVo(int posts_no, Date comment_reg,
			String comment_del_yn, String comment_content, String mem_id) {
		super();
		this.posts_no = posts_no;
		this.comment_reg = comment_reg;
		this.comment_del_yn = comment_del_yn;
		this.comment_content = comment_content;
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "PostsContentVo [posts_no=" + posts_no + ", comment_reg="
				+ comment_reg + ", comment_del_yn=" + comment_del_yn
				+ ", comment_content=" + comment_content + ", mem_id=" + mem_id
				+ "]";
	}
	
	
	
}
