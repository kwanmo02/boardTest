package kr.or.ddit.posts.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.AttachmentServiceInf;
import kr.or.ddit.file.FileUtill;
import kr.or.ddit.posts.model.PostsVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostsServiceInf;

/**
 * Servlet implementation class UpdatePost
 */
@WebServlet("/updatePosts")
@MultipartConfig(maxFileSize = 1024 * 1000 * 5, maxRequestSize = 1024 * 1000 * 16)

public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		PostsServiceInf service = new PostService();
		
		int posts_no = Integer.parseInt(request.getParameter("posts_no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file_name = request.getParameter("file");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		PostsVo vo = new PostsVo();
		vo.setPosts_no(posts_no);
		vo.setPosts_title(title);
		vo.setPosts_content(content);
		vo.setBoard_no(board_no);
		
		service.updatePosts(vo);
		
		request.setAttribute("file", file_name);
		
		AttachmentServiceInf attachService = new AttachmentService();
		
		

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
							
					
					attachService.insertAttachment(attachmentVo);
					List<AttachmentVo> list = attachService.selectAttach(posts_no);
					
					System.out.println("하하하하하하핳ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ" + attachService.selectAttach(posts_no));
					uploadFilePart.delete();
					request.setAttribute("updateAttachList", list);
				}
			}
		}
		
		
		
		response.sendRedirect("/postServlet?page=1&pageSize=10&board_no="+vo.getBoard_no());
	}

}
