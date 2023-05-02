package example1;

public class Board {
	
	public void board() {
		String msg="게시물 등록";
		Login.login(msg);
		System.out.println(msg+"하기");
		System.out.println(msg+"을 DB에 저장");
		Logout.logout(msg);
	}
}
