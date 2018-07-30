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
 * Servlet implementation class CreatePostsServlet
 */
@WebServlet("/createPosts")
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)
public class CreatePostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVo vo =  (MemberVo) session.getAttribute("memberVo");
		String name = vo.getMem_id();
		
		
		PostsServiceInf postsService = new PostService();
		PostsVo postVo = new PostsVo();
		PostsVo newPostsVo = new PostsVo();
		
		String PostsTitle = request.getParameter("title");
		String PostsContent = request.getParameter("content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		postVo.setPosts_title(PostsTitle);
		postVo.setPosts_content(PostsContent);
		postVo.setMem_id(name);
		postVo.setBoard_no(board_no);
		postVo.setPosts_no2(0);
		postVo.setPosts_gcode(0);
		
		int result = postsService.insertPosts(postVo);
		
		/*if(result>0){
			newPostsVo = postsService.selectTitlePosts(PostsTitle);
			request.setAttribute("content", newPostsVo);
		}
		*/
		
		
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
