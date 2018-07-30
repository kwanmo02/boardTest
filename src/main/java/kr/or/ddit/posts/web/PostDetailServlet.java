package kr.or.ddit.posts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.posts.model.PostsContentVo;
import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("id"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String updateAttachList = request.getParameter("updateAttachList");
		
		PostsServiceInf service = new PostService();
		AttachmentServiceInf attachService = new AttachmentService();
		
		PostsVo vo = service.selectNoPosts(no);
		request.setAttribute("posts", vo);
		
		List<PostsContentVo> list = service.selectPostsContent(no);
		List<AttachmentVo> attachList = attachService.selectAttach(no);
		List<AttachmentVo> addAttachList = attachService.selectAttach(no);
		
		request.setAttribute("list", list);
		request.setAttribute("board_no", board_no);
		request.setAttribute("AttachList", attachList);
		request.setAttribute("updateAttachList", addAttachList);
		System.out.println("나와라!!!!!!!!!!:" + addAttachList);
		
		request.getRequestDispatcher("/posts/postDetail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
