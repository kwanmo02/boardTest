package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private Logger logger =  LoggerFactory.getLogger(LoginServlet.class);
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("mem_id");
		String password = request.getParameter("password");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("mem_id");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + request.getParameter("mem_id"));
		System.out.println("password: " + request.getParameter("password"));
		
		BoardServiceInf boardService = new BoardService();
		PostsServiceInf postsService = new PostService();
		
		MemberServiceInf memberService = new MemberService();
		MemberVo memberVo = memberService.getMember(userId);
		
		
		
		
		
		
		
		if (memberVo.validateUser(userId, password)) {
			memberVo.setMem_id(userId);
			memberVo.setPass(password);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("memberVo", memberVo);
			
			List<BoardVo> boardList = boardService.selectAllBoard();
			List<PostsVo> postsList = postsService.getAllPost();
			request.getServletContext().setAttribute("boardList", boardList);
			request.getServletContext().setAttribute("postsList", postsList);
			
			
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
			
			
			
		}else {
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);;
		}
		
		
		
	}

}
