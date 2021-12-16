package prsite.spring.member.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import prsite.spring.dto.InfluencerDto;
import prsite.spring.dto.MemberDto;
import prsite.spring.influencer.dao.InfluencerDao;
import prsite.spring.member.dao.MemberDao;

public class MemberJoinService implements IMemberService{
	// 회원가입

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		MultipartHttpServletRequest request = (MultipartHttpServletRequest)map.get("request");
		//Iterator<String> fileNames = request.getFileNames();
		
		String absolutePath = request.getSession().getServletContext().getRealPath("/upload/");
		String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		int max_size = 1024 * 1024 * 100;//최대업로드 용량 100mb
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		/*
		 * while(fileNames.hasNext()) { fileName = fileNames.next(); MultipartFile mFile
		 * = request.getFile(fileName); File Folder = new File(absolutePath);
		 * 
		 * if(mFile.getSize() != 0) {
		 * 
		 * if(!Folder.exists()) { try { Folder.mkdir();
		 * System.out.println("폴더가 생성되었습니다."); }catch (Exception e) {
		 * e.printStackTrace(); } }else { System.out.println("폴더가 이미 생성되어 있습니다."); }
		 * 
		 * }
		 * 
		 * try {
		 * 
		 * mFile.transferTo(Folder);
		 * 
		 * }catch (Exception e) { e.printStackTrace(); } }
		 */
		
		
		//System.out.println( "파일경로" + absolutePath );
//		
//		
//		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
//		try {
//			request.setCharacterEncoding("UTF-8");
//			
//			MultipartRequest mr  = new MultipartRequest( 
//					request, 
//					absolutePath, 
//					max_size, 
//					"UTF-8", 
//					policy);
			
			//Member 테이블에 들어갈 회원 기본 정보 
			String id =  request.getParameter("id");
			System.out.println("등록할id : "+id);
			String pwd = request.getParameter("pwd");
			System.out.println("등록할pwd : "+pwd);
			String influyn = request.getParameter("influyn");
			System.out.println("등록할influyn : "+influyn);
			String name = request.getParameter("nickname");
			System.out.println("등록할nickname : "+name);

			//실제 업로드된 파일의 정보를 가져온다.
			MultipartFile f = request.getFile("photo");
			String originalFileName = f.getOriginalFilename();
			//File f = mr.getFile("photo");
		/*
		 * if( f != null ) { fileName = f.getName();//업로드된 파일명
		 * System.out.println("파일명 : "+fileName); }
		 */
			MemberDto member;
			//Member DB처리
			
			if(originalFileName == null) {
				member =new  MemberDto(id ,pwd,influyn, name, null);
			}else {
				member =new  MemberDto(id ,pwd,influyn, name, originalFileName);
			}


			MemberDao dao = new MemberDao();
			dao.memberInsert(member);
			System.out.println("MemberDao memberInsert success");


			//Influencer 테이블에 들어갈 정보 
			if(influyn.equals("y")) {
				System.out.println("influyn==y");

				String cat = request.getParameter("category");
				String info = request.getParameter("info");
				String instagram = request.getParameter("instagram");
				String youtube = request.getParameter("youtube");
				
				int instsubs = Integer.parseInt(request.getParameter("instsubs"));
				int  ytsubs = Integer.parseInt(request.getParameter("ytsubs"));
				
				if(cat.isEmpty() || cat.equals("")) {
					cat = null;
				}
				if(instagram.isEmpty()|| instagram.equals("")) {
					instagram = null;
				}
				if(youtube.isEmpty()|| youtube.equals("")) {
					youtube = null;
				}
								
			
				InfluencerDto influencerdto =new  InfluencerDto(id, cat, info, instagram, youtube,instsubs, ytsubs);
				InfluencerDao influencerdao = new InfluencerDao();
				influencerdao.InfluencerInsert(influencerdto);
				System.out.println("influencerdao insert success");
			}
		}		

	@Override
	public boolean getResult() {
		// TODO Auto-generated method stub
		return false;
	}

}
