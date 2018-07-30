package kr.or.ddit.posts.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class deleteCommentServlet
 */
@WebServlet("/deleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		int posts_no = Integer.parseInt(request.getParameter("posts_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		PostsServiceInf service = new PostService();
		
		
			service.deleteComment(comment_no);
		
		
		response.sendRedirect("/postDetail?id="+posts_no+"&board_no="+board_no);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
