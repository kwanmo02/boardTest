package login;

import static org.junit.Assert.*;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Test;

public class loginTest {

	@Test
	public void test() {
		/***Given***/
		MemberVo vo = new MemberVo();
		
		
		String memId = "black";
		String pass = "1234";
		
		MemberServiceInf service = new MemberService();

		if (vo.validateUser(memId, pass)) {
			vo.setMem_id(memId);
			vo.setPass(pass);
		}
	
		/***When***/

		/***Then***/
		assertEquals("black", vo.getMem_id());
	}
}
