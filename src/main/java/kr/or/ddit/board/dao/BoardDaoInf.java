package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {
	
	/**
	 * 
	* Method : selectAllBoard
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 리스트를 가져온다.
	 */
	public List<BoardVo> selectAllBoard();
	
	
	/**
	 * 
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC21
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시판 생성하기
	 */
	int insertBoard(Map<String, String> map);
	
	
	/**
	 * 
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC21
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(BoardVo boardVo);
}
