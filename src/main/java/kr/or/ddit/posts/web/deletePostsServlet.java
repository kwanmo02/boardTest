package kr.or.ddit.posts.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class deletePostsServlet
 */
@WebServlet("/deletePosts")
public class deletePostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int posts_no = Integer.parseInt(request.getParameter("posts_no"));
		
		PostsVo vo = new PostsVo();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		/*MemberVo memVo = new MemberVo();*/
		
	/*	MemberVo mem = (MemberVo) request.getSession().getAttribute("memberVo");
		String mem_id = mem.getMem_id();*/
		
		vo.setBoard_no(board_no);
		
		
		PostsServiceInf service = new PostService();
		
		service.deletePosts(posts_no);
		
		
/*		request.getRequestDispatcher("/postServlet?page=1&pageSize=10&board_no="+vo.getBoard_no()).forward(request, response);
*/		response.sendRedirect("/postServlet?page=1&pageSize=10&board_no="+vo.getBoard_no());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
