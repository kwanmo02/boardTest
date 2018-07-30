package kr.or.ddit.posts.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.file.FileUtill;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class CreateRepostsServlet
 */
@WebServlet("/createReposts")
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)
public class CreateRepostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVo vo =  (MemberVo) session.getAttribute("memberVo");
		String mem_id = vo.getMem_id();
		
		
		PostsServiceInf postsService = new PostService();
		PostsVo postVo = new PostsVo();
		
		String posts_title = request.getParameter("posts_title");
		System.out.println(posts_title);
		String posts_content = request.getParameter("content");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int posts_no2 = Integer.parseInt(request.getParameter("posts_no2"));
		postVo.setPosts_title(posts_title);
		postVo.setPosts_content(posts_content);
		postVo.setMem_id(mem_id);
		postVo.setBoard_no(board_no);
		postVo.setPosts_no2(posts_no2);
		postVo.setPosts_gcode(0);
		
		postsService.insertPosts(postVo);
		
		
		

		
		Collection<Part> parts = request.getParts();
		
		for (Part uploadFilePart : parts) {
//			Part uploadFilePart = request.getPart("file");
			
			String contentType = uploadFilePart.getContentType();
			if( contentType != null ){
				//fileSize가 정상적인 경우에만 업로드를 수행한다
				if( uploadFilePart.getSize() > 0 ) {
					
					String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
					
					String fileName = FileUtill.getFileName(contentDisposition);
					//고정된 영역으로 배포
					String path = FileUtill.fileUploadPath;			
					String var = UUID.randomUUID().toString();
					uploadFilePart.write(path + File.separator + var);			
					String attach_upload_name = fileName;
					String attach_path = path;
					String attach_name = var;
					
					AttachmentVo attachmentVo = new AttachmentVo();
					attachmentVo.setUpload_picname(attach_upload_name);
					attachmentVo.setPic_path(attach_path);
					attachmentVo.setPosts_picname(attach_name);
							
					AttachmentServiceInf service = new AttachmentService();
					
					service.insertAttachment(attachmentVo);
					
					uploadFilePart.delete();
		
				}
			}
		}
		
		
		
		
		response.sendRedirect("/postServlet?&size=1&pageSize=10&board_no=" + board_no);
	}

}
