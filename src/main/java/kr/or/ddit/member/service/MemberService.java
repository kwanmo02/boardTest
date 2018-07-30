package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVo;

public class MemberService implements MemberServiceInf{

	@Override
	public MemberVo getMember(String memId) {
		MemberDaoInf memDao = new MemberDao();
		return memDao.getMember(memId);
	}

}
