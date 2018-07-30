package posts.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import kr.or.ddit.posts.dao.PostsDao;
import kr.or.ddit.posts.dao.PostsDaoInf;
import kr.or.ddit.posts.model.PostsContentVo;
import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

import org.junit.Before;
import org.junit.Test;

public class postsDaoTest {
	private PostsDaoInf dao;
	
	@Before
	public void setUp(){
		dao = new PostsDao();
	}
	
/*	@Test
	public void insertPostsTest() {
		*//***Given***//*
		PostsVo vo = new PostsVo();
		
		vo.setPosts_title("ㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇ");
		vo.setPosts_content("내용");
		vo.setMem_id("black");
		vo.setPosts_gcode(1);
//		vo.setPosts_no2();
		vo.setPosts_reg(new Date());
		vo.setBoard_no(7);
		vo.setPosts_yn("1");
//		vo.setPosts_re_seq(2);
		
		*//***When***//*
		int cnt = dao.insertPosts(vo);
		*//***Then***//*
		
		assertEquals(1, cnt);
	}
	
	*/
	
	/*@Test
	public void updatePostsTest(){
		
		*//***Given***//*
		PostsVo vo = new PostsVo();
		vo.setPosts_no(27);
		vo.setPosts_title("여름엔수박");
		vo.setPosts_content("수박씨발라먹자");
		
		int cnt = dao.updatePosts(vo);
		
		*//***When***//*
		
		
		*//***Then***//*
		assertEquals(1, cnt);
	}
	
	
	@Test
	public void deletePostsTest(){
		*//***Given***//*
		int cnt = dao.deletePosts(26);
		*//***When***//*

		*//***Then***//*
		assertEquals(1, cnt);
		
	}*/
	
	@Test
	public void insertPostContentTest(){
		/***Given***/
		/*private int posts_no;
		private Date comment_reg;
		private String comment_del_yn;
		private String comment_content;
		private String mem_id;*/
		
		PostsContentVo vo = new PostsContentVo();
		
		vo.setPosts_no(21);
		vo.setComment_del_yn("false");
		vo.setMem_id("pink");
		vo.setComment_content("집가고싶다");
		
		
		int cnt = dao.insertPostsContent(vo);
		
		/***When***/

		/***Then***/
		assertEquals(1, cnt);
	}
	

	

}
