package kr.or.ddit.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String boardName = request.getParameter("board");
		String boardYn = request.getParameter("boardEdit");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoard_name(boardName);
		boardVo.setBoard_yn(boardYn);
		boardVo.setBoard_no(boardNo);
		
		BoardService boardService = new BoardService();
		boardService.updateBoard(boardVo);
		
		List<BoardVo> boardList = boardService.selectAllBoard();
		request.getServletContext().setAttribute("boardList", boardList);
		
		
		
		request.getRequestDispatcher("/board/newBoard.jsp").forward(request, response);
	}

}
