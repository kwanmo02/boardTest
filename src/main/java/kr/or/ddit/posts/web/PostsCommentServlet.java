package kr.or.ddit.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.posts.model.PostsContentVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostsCommentServlet
 */
@WebServlet("/postsComment")
public class PostsCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostsServiceInf service = new PostService();
		
		request.setCharacterEncoding("utf-8");
		
		int post_no = Integer.parseInt(request.getParameter("posts_no"));
		String content = request.getParameter("reposts");
		
		MemberVo mem = (MemberVo) request.getSession().getAttribute("memberVo");
		String mem_id = mem.getMem_id();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		
		PostsContentVo vo = new PostsContentVo();
		vo.setPosts_no(post_no);
		vo.setComment_content(content);
		vo.setComment_del_yn("false");
		vo.setMem_id(mem_id);
		
		service.insertPostsContent(vo);
		List<PostsContentVo> list = service.selectPostsContent(post_no);
		
		request.setAttribute("content", vo.getComment_content());
		request.setAttribute("list", list);
		request.setAttribute("board_no", board_no);
		
		response.sendRedirect("/postDetail?id="+post_no +"&board_no="+board_no);
//		request.getRequestDispatcher("/posts/postDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
