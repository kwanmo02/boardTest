package kr.or.ddit.file;

public class FileUtill {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.Jspspring\\fileUpload";
	
	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC21
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part와 Content-Disposition header로 부터 업로드 파일명을 리턴한다.
	* 
	* 
	* ex :	//form-data; name="uploadFile"; filename="moon.png"
	* return : moon.png
	* 

	*/
	public static String getFileName(String contentDisposition){
		String[] files = contentDisposition.split("; ");
		String fileResult = "";
		
		for (int i = 0; i < files.length; i++) {
			String fileStr = files[i+1];
			String[] fileNameValue = fileStr.split("=");
			
			String fileName = fileNameValue[0];
			String fileValue = fileNameValue[1];
			
			if (fileName.equals("filename")) {
				fileResult = fileValue.replaceAll("\"", "");
				break;
			}
			
		}
		
		
		
		/*for(String fileStr : files){
			String[] fileNameValue = fileStr.split("=");
			
			String fileName = fileNameValue[0];
			String filevalue = fileNameValue[1];
			
			if (fileName.equals("moon.png")) {
				fileResult = filevalue;
				break;
			}
		}*/
		
		
		return fileResult;
		
		
		
	}
}
