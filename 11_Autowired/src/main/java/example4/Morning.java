package example4;

import org.springframework.stereotype.Component;

//Morning myMorning = new Morning();
@Component("myMorning")
public class Morning implements Car{

	public Morning() {
		System.out.println("Morning()");
	}
	
	public String drive() {
		return "Morning-drive";
	}

}
