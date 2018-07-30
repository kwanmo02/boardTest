package kr.or.ddit.attachment.model;

public class AttachmentVo {
	private String id;
	private int posts_no;
	private String posts_picname;
	private String pic_path;
	private String upload_picname;
	
	
	public AttachmentVo() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPosts_no() {
		return posts_no;
	}
	public void setPosts_no(int posts_no) {
		this.posts_no = posts_no;
	}
	public String getPosts_picname() {
		return posts_picname;
	}
	public void setPosts_picname(String posts_picname) {
		this.posts_picname = posts_picname;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	public String getUpload_picname() {
		return upload_picname;
	}
	public void setUpload_picname(String upload_picname) {
		this.upload_picname = upload_picname;
	}
	

	@Override
	public String toString() {
		return "AttachmentVo [id=" + id + ", posts_no=" + posts_no
				+ ", posts_picname=" + posts_picname + ", pic_path=" + pic_path
				+ ", upload_picname=" + upload_picname + "]";
	}


	public AttachmentVo(String id, int posts_no, String posts_picname,
			String pic_path, String upload_picname) {
		super();
		this.id = id;
		this.posts_no = posts_no;
		this.posts_picname = posts_picname;
		this.pic_path = pic_path;
		this.upload_picname = upload_picname;
	}
	
	
	
	
}
