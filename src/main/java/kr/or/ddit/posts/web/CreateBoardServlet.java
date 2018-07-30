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

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class CreatePosts
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardServiceInf boardService = new BoardService();
		
		String boardTitle = request.getParameter("board_name");
		String boardyn = request.getParameter("newboardedit");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("board_name", boardTitle);
		map.put("board_yn", boardyn);
		
		boardService.insertBoard(map);
		
		List<BoardVo> boardList = boardService.selectAllBoard();
		request.getServletContext().setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
