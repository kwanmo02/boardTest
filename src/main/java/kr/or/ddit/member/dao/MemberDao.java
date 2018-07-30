package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.mybatis.SqlmapSessionFactory;


public class MemberDao implements MemberDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlmapSessionFactory.getSqlSessionFactory();
	
	
	@Override
	public MemberVo getMember(String memId) {
		SqlSession session = sqlSessionFactory.openSession();
		
		MemberVo memberVo = session.selectOne("member.selectMember", memId);
		
		session.close();
		
		return memberVo;
	}
	
}
