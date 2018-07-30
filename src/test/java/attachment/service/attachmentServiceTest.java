package attachment.service;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;

import org.junit.Before;
import org.junit.Test;

public class attachmentServiceTest {
	private AttachmentServiceInf service;
	
	@Before
	public void setUp(){
		service = new AttachmentService();
	}
	
	@Test
	public void test() {
		
			/***Given***/
			AttachmentVo vo = new AttachmentVo();
			vo.setPosts_no(21);
			vo.setPic_path("b");
			vo.setPosts_picname("b");
			vo.setUpload_picname("b");
			
			int cnt = service.insertAttachment(vo);
			/***When***/
			
			/***Then***/
			assertEquals(1, cnt);
		}
	}


