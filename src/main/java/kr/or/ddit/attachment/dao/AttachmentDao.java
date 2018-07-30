package kr.or.ddit.attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.mybatis.SqlmapSessionFactory;

public class AttachmentDao implements AttachmentDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlmapSessionFactory.getSqlSessionFactory();
	
	
	@Override
	public int insertAttachment(AttachmentVo attachmentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int resultMap = session.insert("attachment.insertAttachment", attachmentVo);
		session.commit();
		session.close();
		
		return resultMap;
	}
	


	@Override
	public List<AttachmentVo> selectAttach(int posts_no) {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<AttachmentVo> list = session.selectList("attachment.selectAttachment", posts_no);
		session.close();
		
		return list;
	}

}
