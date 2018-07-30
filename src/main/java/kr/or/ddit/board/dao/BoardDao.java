package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlmapSessionFactory;

public class BoardDao implements BoardDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlmapSessionFactory.getSqlSessionFactory();
	
	
	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession session =  sqlSessionFactory.openSession();
		
		List<BoardVo> boardList = session.selectList("board.selectAllboard");
		session.close();
		
		return boardList;
	}


	@Override
	public int insertBoard(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int resultMap = session.insert("board.insertBoard", map);
		
		session.commit();
		session.close();
		
		return resultMap;
		
	}


	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int resultMap = session.update("board.updateBoard", boardVo);
		
		session.commit();
		session.close();
		
		
		return resultMap;
	}

}
