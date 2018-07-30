package board;

import static org.junit.Assert.*;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

import org.junit.Test;

public class updateTest {

	@Test
	public void test() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoard_name("업데이트가 되나요~?");
		boardVo.setBoard_yn("false");
		boardVo.setBoard_no(7);
		
		
		BoardServiceInf boardSerivce = new BoardService();
		int cnt = boardSerivce.updateBoard(boardVo);
		
		
		/***When***/

		/***Then***/
		assertEquals(1, cnt);
	}

}
