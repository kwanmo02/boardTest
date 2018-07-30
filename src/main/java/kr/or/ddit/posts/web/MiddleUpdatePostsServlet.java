package kr.or.ddit.posts.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePostsServlet
 */
@WebServlet("/middleUpdatePosts")
public class MiddleUpdatePostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int postsNo = Integer.parseInt(request.getParameter("posts_no"));
		String title = request.getParameter("postsTitle");
		String content = request.getParameter("postsContent");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String upload_picname = request.getParameter("upload_picname");
		
		request.setAttribute("posts_no", postsNo);
		request.setAttribute("postsTitle", title);
		request.setAttribute("postsContent", content);
		request.setAttribute("board_no", board_no);
		request.setAttribute("upload_picname", upload_picname);
		
		System.out.println("postsContent: " + content);
		
		request.getRequestDispatcher("/posts/updatePosts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
