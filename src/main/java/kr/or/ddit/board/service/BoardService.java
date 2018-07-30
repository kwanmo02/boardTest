package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf{
	BoardDaoInf boardDao = new BoardDao();
	
	
	@Override
	public List<BoardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}


	@Override
	public int insertBoard(Map<String, String> map) {
		return boardDao.insertBoard(map);
	}


	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}




}
