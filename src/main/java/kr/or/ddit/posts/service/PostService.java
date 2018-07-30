package kr.or.ddit.posts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.posts.dao.PostsDao;
import kr.or.ddit.posts.dao.PostsDaoInf;
import kr.or.ddit.posts.model.PostsContentVo;
import kr.or.ddit.posts.model.PostsVo;

public class PostService implements PostsServiceInf{
	PostsDaoInf dao = new PostsDao();
	
	@Override
	public List<PostsVo> selectGetPosts() {
		
		return dao.selectGetPosts();
	}

	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC21
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자열 생성
	*/
	private String makePageNavi(int page, int pageSize1, int totCnt, int board_no){
		// 페이지 네이게이션 html 생성
				int activePage = page;
				int pageSize = pageSize1;

				int pagingnationSize = totCnt % pageSize == 0 ? totCnt / pageSize
						: totCnt / pageSize + 1;

				StringBuilder pageNavi = new StringBuilder();
				
				pageNavi.append("<li><a href=\"postServlet?board_no="+board_no+"&page=1"
						+ "&pageSize=10\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
				
				pageNavi.append("<li><a href=\"postServlet?board_no="+board_no+"&page="
						+ (activePage > 1 ? activePage - 1 : 1)
						+ "&pageSize=10\" aria-label=\"Previous\"><span aria-hidden=\"true\">&lt;</span></a></li>");
			
				//페이지 1,2,3,...,출력
				for (int i = 1; i <= pagingnationSize; i++) {
					String activeClass = "";
					if (i == activePage)
						activeClass = " class=\"active\"";

					pageNavi.append("<li" + activeClass
							+ "><a href=\"/postServlet?board_no="+board_no+"&page=" + i + "&pageSize=10\">"
							+ i + "</a></li>");
				}
				
				pageNavi.append("<li><a href=\"/postServlet?board_no="+board_no+"&page="
						+ (activePage < pagingnationSize ? activePage + 1
								: pagingnationSize)
						+ "&pageSize=10\" aria-label=\"Next\"><span aria-hidden=\"true\">&gt;</span></a></li>");
				
				pageNavi.append("<li><a href=\"/postServlet?board_no="+board_no+"&page="+pagingnationSize
						+ "&pageSize=10\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
				
				return pageNavi.toString();
	}
	
	
	@Override
	public Map<String, Object> getPostsPageList(Map<String, Integer> map) {
		PostsDao postsDao = new PostsDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//게시글 페이지 리스트 조회
		List<PostsVo> pageList = postsDao.getPostsPageList(map);
		resultMap.put("pageList", pageList);
		
		//게시글 전체 건수 조회
		
		int totCnt = postsDao.getPostsTotCnt((int)map.get("board_no"));
		resultMap.put("totCnt", totCnt);
		
		//페이지 네비게이션 html생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		int board_no = map.get("board_no");
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt, board_no));
		
		return resultMap;
		
	}

	@Override
	public List<PostsVo> getAllPost() {
		return dao.getAllPost();
	}

	@Override
	public int insertPosts(PostsVo postsVo) {
		return dao.insertPosts(postsVo);
	}

	@Override
	public PostsVo selectNoPosts(int posts_no) {
		return dao.selectNoPosts(posts_no);
	}

	@Override
	public int updatePosts(PostsVo postsVo) {
		return dao.updatePosts(postsVo);
	}

	@Override
	public int deletePosts(int posts_no) {
		return dao.deletePosts(posts_no);
	}

	@Override
	public int insertPostsContent(PostsContentVo postsContentVo) {
		return dao.insertPostsContent(postsContentVo);
	}

	@Override
	public List<PostsContentVo> selectPostsContent(int posts_no) {
		return dao.selectPostsContent(posts_no);
	}

	@Override
	public PostsVo selectTitlePosts(String posts_title) {
		return dao.selectTitlePosts(posts_title);
	}

	@Override
	public int deleteComment(int posts_no) {
		return dao.deleteComment(posts_no);
	}
	
	
	

}
