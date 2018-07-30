package kr.or.ddit.attachment.service;

import java.util.List;

import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.dao.AttachmentDaoInf;
import kr.or.ddit.attachment.model.AttachmentVo;

public class AttachmentService implements AttachmentServiceInf{
	AttachmentDaoInf dao = new AttachmentDao();
	
	@Override
	public int insertAttachment(AttachmentVo attachmentVo) {
		return dao.insertAttachment(attachmentVo);
	}

	@Override
	public List<AttachmentVo> selectAttach(int posts_no) {
		return dao.selectAttach(posts_no);
	}

}
