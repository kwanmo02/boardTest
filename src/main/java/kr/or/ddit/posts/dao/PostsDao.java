package kr.or.ddit.posts.dao;

import java.util.List;
import java.util.Map;

       
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlmapSessionFactory;
import kr.or.ddit.posts.model.PostsContentVo;
import kr.or.ddit.posts.model.PostsVo;

public class PostsDao implements PostsDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlmapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<PostsVo> selectGetPosts() {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<PostsVo> postsList = session.selectList("posts.selectGetPosts"); 
		session.close();
		
		return postsList;
	}

	@Override
	public List<PostsVo> getPostsPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostsVo> postsList = session.selectList("posts.getPostsPageList", map);
		session.close();
		
		
		return postsList;
	}

	@Override
	public int getPostsTotCnt(int board) {
		SqlSession session = sqlSessionFactory.openSession();
		int postsTotCntList = session.selectOne("posts.getPostsTotCnt", board);
		session.close();
		
		return postsTotCntList;
	}

	@Override
	public List<PostsVo> getAllPost() {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<PostsVo> list = session.selectList("posts.getAllPost");
		session.close();
		
		return list;
	}

	@Override
	public int insertPosts(PostsVo postsVo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int resultMap = session.insert("posts.insertPost", postsVo);
		
		session.commit();
		session.close();
		
		
		return resultMap;
	}

	@Override
	public PostsVo selectNoPosts(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession();
		PostsVo vo = session.selectOne("posts.selectNoPosts", posts_no);
		
		session.commit();
		session.close();
		
		return vo;
	}

	@Override
	public int updatePosts(PostsVo postsVo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int resultMap = session.update("posts.updatePosts", postsVo);
		
		session.commit();
		session.close();
		
		return resultMap;
	}

	@Override
	public int deletePosts(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int resultMap= session.update("posts.deletePosts", posts_no);
		
		session.commit();
		session.close();
		
		return resultMap;
	}

	@Override
	public int insertPostsContent(PostsContentVo postsContentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int result = session.insert("postsContent.insertPostContent", postsContentVo);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public List<PostsContentVo> selectPostsContent(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostsContentVo> list =  session.selectList("postsContent.selectComment", posts_no);
		session.commit();
		session.close();
		
		return list;
	}

	@Override
	public PostsVo selectTitlePosts(String posts_title) {
		SqlSession session = sqlSessionFactory.openSession();
		
		PostsVo vo = session.selectOne("posts.selectTitlePost", posts_title);
		session.close();
		
		return vo;
	}

	@Override
	public int deleteComment(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int result = session.delete("postsContent.deleteComment",posts_no);
		session.commit();
		session.close();
		
		return result;
	}

	
	

	
	

}
