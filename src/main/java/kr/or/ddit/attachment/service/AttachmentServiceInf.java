package kr.or.ddit.attachment.service;

import java.util.List;

import kr.or.ddit.attachment.model.AttachmentVo;

public interface AttachmentServiceInf {

	public int insertAttachment(AttachmentVo attachmentVo);
	
	
	public List<AttachmentVo> selectAttach(int posts_no);
	
}
