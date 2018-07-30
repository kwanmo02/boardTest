package kr.or.ddit.attachment.dao;

import java.util.List;

import kr.or.ddit.attachment.model.AttachmentVo;

public interface AttachmentDaoInf {
	
	public int insertAttachment(AttachmentVo attachmentVo);
	
	public List<AttachmentVo> selectAttach(int posts_no);
}
