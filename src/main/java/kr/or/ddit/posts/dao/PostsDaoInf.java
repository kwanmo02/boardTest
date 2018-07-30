package kr.or.ddit.posts.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.posts.model.PostsContentVo;
import kr.or.ddit.posts.model.PostsVo;

public interface PostsDaoInf {
	
	
	/**
	 * 
	* Method : getAllPost
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시글을 가져온다.
	 */
	public List<PostsVo> getAllPost();
	
	/**
	 * 
	* Method : selectGetPosts
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 해당 회원의 게시글을 가져온다.
	 */
	public List<PostsVo> selectGetPosts();
	
	
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 :	게시글 페이지 리스트 조회
	*/
	List<PostsVo> getPostsPageList(Map<String, Integer>map);
	
	
	int getPostsTotCnt(int board_no);
	
	/**
	 * 
	* Method : insertPosts
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC21
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 등록하기
	 */
	public int insertPosts(PostsVo postsVo);
	
	
	/**
	 * 
	* Method : selectNoPosts
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC21
	* 변경이력 :
	* @param posts_no
	* @return
	* Method 설명 : 해당 게시글 번호의 글을 가져온다.
	 */
	public PostsVo selectNoPosts(int posts_no);
	
	
	/**
	 * 
	* Method : updatePOsts
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC21
	* 변경이력 :
	* @param postsVo
	* @return
	* Method 설명 : 해당 게시물 게시글 수정
	 */
	public int updatePosts(PostsVo postsVo);
	
	
	/**
	 * 
	* Method : deletePosts
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC21
	* 변경이력 :
	* @param posts_no
	* @return
	* Method 설명 : 해당 게시물 삭제
	 */
	public int deletePosts(int posts_no);
	
	
	
	/**
	 * 
	* Method : insertPostsContent
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC21
	* 변경이력 :
	* @param postsContentVo
	* @return
	* Method 설명 : 댓글 저장
	 */
	public int insertPostsContent(PostsContentVo postsContentVo);
	
	
	/**
	 * 
	* Method : selectPostsContent
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC21
	* 변경이력 :
	* @param posts_no
	* @return
	* Method 설명 : 해당 게시글의 모든 댓글을 가져온다.
	 */
	public List<PostsContentVo> selectPostsContent(int posts_no);
	
	
	/**
	 * 
	* Method : selectTitlePosts
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC21
	* 변경이력 :
	* @param posts_title
	* @return
	* Method 설명 : 해당 게시글의 제목으로 글을 가져온다.
	 */
	public PostsVo selectTitlePosts(String posts_title); 
	
	
	/**
	 * 
	* Method : deletePosts
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC21
	* 변경이력 :
	* @param posts_no
	* @return
	* Method 설명 : 해당 게시물 댓글삭제
	 */
	public int deleteComment(int posts_no);
}
