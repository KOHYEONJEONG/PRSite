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
	// ȸ������

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		MultipartHttpServletRequest request = (MultipartHttpServletRequest)map.get("request");
		//Iterator<String> fileNames = request.getFileNames();
		
		String absolutePath = request.getSession().getServletContext().getRealPath("/upload/");
		String fileName = null;  // �⺻ ��ο� ������ �ۼ��Ǵ� ��� + �����̸�
		int max_size = 1024 * 1024 * 100;//�ִ���ε� �뷮 100mb
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		/*
		 * while(fileNames.hasNext()) { fileName = fileNames.next(); MultipartFile mFile
		 * = request.getFile(fileName); File Folder = new File(absolutePath);
		 * 
		 * if(mFile.getSize() != 0) {
		 * 
		 * if(!Folder.exists()) { try { Folder.mkdir();
		 * System.out.println("������ �����Ǿ����ϴ�."); }catch (Exception e) {
		 * e.printStackTrace(); } }else { System.out.println("������ �̹� �����Ǿ� �ֽ��ϴ�."); }
		 * 
		 * }
		 * 
		 * try {
		 * 
		 * mFile.transferTo(Folder);
		 * 
		 * }catch (Exception e) { e.printStackTrace(); } }
		 */
		
		
		//System.out.println( "���ϰ��" + absolutePath );
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
			
			//Member ���̺� �� ȸ�� �⺻ ���� 
			String id =  request.getParameter("id");
			System.out.println("�����id : "+id);
			String pwd = request.getParameter("pwd");
			System.out.println("�����pwd : "+pwd);
			String influyn = request.getParameter("influyn");
			System.out.println("�����influyn : "+influyn);
			String name = request.getParameter("nickname");
			System.out.println("�����nickname : "+name);

			//���� ���ε�� ������ ������ �����´�.
			MultipartFile f = request.getFile("photo");
			String originalFileName = f.getOriginalFilename();
			//File f = mr.getFile("photo");
		/*
		 * if( f != null ) { fileName = f.getName();//���ε�� ���ϸ�
		 * System.out.println("���ϸ� : "+fileName); }
		 */
			MemberDto member;
			//Member DBó��
			
			if(originalFileName == null) {
				member =new  MemberDto(id ,pwd,influyn, name, null);
			}else {
				member =new  MemberDto(id ,pwd,influyn, name, originalFileName);
			}


			MemberDao dao = new MemberDao();
			dao.memberInsert(member);
			System.out.println("MemberDao memberInsert success");


			//Influencer ���̺� �� ���� 
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
