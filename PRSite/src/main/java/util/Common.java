package util;

public class Common {
	 //게시판 별로 페이지 관리를 편하게 하기위해 만든 클래스
		public static class Board{
			//한 페이지당 보여줄 게시물 수
			public final static int BLOCKLIST = 5;
			
			//한 화면에 보여지는 페이지 메뉴 수
			// < 1 2 3 4 5 >
			public final static int BLOCKPAGE=3;
		}
		
		public static class Notice{
			//한페이지당 보여질 갯수
			public final static int BLOCKLIST = 20;
			public final static int BLOCKPAGE= 10;
			
			//게시판이 많아질 경우 편하게 사용하려고 만든 클래스
		}
	}
