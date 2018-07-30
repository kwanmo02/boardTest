package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class newBoardServlet
 */
@WebServlet("/newBoard")
public class NewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf boardService = new BoardService();
		
		List<BoardVo> boardList = boardService.selectAllBoard();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/board/newBoard.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// boardService 객체를 생성, 게시판 전체 리스트를 조회
		// 게시판 전체 리스트 request 객체에 속성으로 설정
		// newBoard.jps로 forward
		
		
	}

}
