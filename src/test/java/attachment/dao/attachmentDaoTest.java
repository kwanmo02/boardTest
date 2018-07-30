package attachment.dao;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.model.AttachmentVo;

import org.junit.Before;
import org.junit.Test;

public class attachmentDaoTest {
	private AttachmentDao dao;
	
	@Before
	public void setUp(){
		dao = new AttachmentDao();
	}
	
	@Test
	public void AttachmentInsertTest() {
		/***Given***/
		AttachmentVo vo = new AttachmentVo();
		vo.setPic_path("b");
		vo.setPosts_picname("b");
		vo.setUpload_picname("b");
		
		int cnt = dao.insertAttachment(vo);
		/***When***/
		
		/***Then***/
		assertEquals(1, cnt);
	}

}
