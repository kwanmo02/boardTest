package board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

import org.junit.Test;

public class insertTest {

	@Test
	public void test() {
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("board_name", "되나용");
		map.put("board_yn", "true");
		
		BoardServiceInf service = new BoardService();
		
		int re = service.insertBoard(map);
		
		/***When***/

		/***Then***/
		assertEquals(1, re);
	}

}
