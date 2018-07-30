package kr.or.ddit.posts.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/postServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostsServiceInf postsService = new PostService();
		
//		String board_no = request.getParameter("board_no");
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		String AttachList = request.getParameter("AttachList");
		String updateAttachList = request.getParameter("updateAttachList2");
		
		int page = pageStr==null? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null? 1 : Integer.parseInt(pageSizeStr);
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		System.out.println("board_no= "+board_no);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("board_no", board_no);
		
		//게시글 페이지 리스트, 전체건수 조회
		
		Map<String, Object> resultMap = postsService.getPostsPageList(map);
		
		//게시글 전체 리스트
		List<PostsVo> postsList = (List<PostsVo>)resultMap.get("pageList");
		
		//게시글 전체 건수
		int listSize = (int)resultMap.get("totCnt");
		int pagenationSize = listSize%pageSize==0? listSize/pageSize:listSize/pageSize+1;
		
		
		//jsp로 위임
		String pageNavi = (String)resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		request.setAttribute("PostsList", postsList);
		request.setAttribute("pagenationSize", pagenationSize);
		request.setAttribute("board_no", board_no);
		request.setAttribute("AttachList", AttachList);
		request.setAttribute("updateAttachList2", updateAttachList);
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+ updateAttachList);
		
		request.getRequestDispatcher("/posts/postsList.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
