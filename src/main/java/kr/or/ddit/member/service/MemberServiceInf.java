package kr.or.ddit.member.service;

import kr.or.ddit.member.model.MemberVo;

public interface MemberServiceInf {
	

	/**
	 * 
	* Method : getMember
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC21
	* 변경이력 :
	* @param memId
	* @return
	* Method 설명 : 사용자를 상세조회
	 */
	public MemberVo getMember(String memId);

}
