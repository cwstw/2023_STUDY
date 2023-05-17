package movie.model;

import org.hibernate.validator.constraints.NotBlank;

public class MovieBean {
	private final String msg = "필수 입력 사항입니다.";
	
	private int num;
	
	@NotBlank(message = msg)
	private String title;
	
	//notnull 불가
	@NotBlank(message = "대륙은 "+msg)
	private String continent;

	@NotBlank(message = "나라는 "+msg)
	private String nation;

	@NotBlank(message = "최소 한 개 이상 선택하세요")
	private String genre;

	@NotBlank(message = msg)
	private String grade;

	@NotBlank(message = msg)
	private String actor;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public MovieBean(int num, String title, String continent, String nation, String genre, String grade, String actor) {
		super();
		this.num = num;
		this.title = title;
		this.continent = continent;
		this.nation = nation;
		this.genre = genre;
		this.grade = grade;
		this.actor = actor;
	}
	public MovieBean() {
		super();
	}
	
	
	
}
