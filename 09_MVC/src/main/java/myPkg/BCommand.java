package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
	//public 생략
	//인터페이스 안에 들어가는 모든 변수는 public static final이 기본값
	//수정할 수 없음
}
