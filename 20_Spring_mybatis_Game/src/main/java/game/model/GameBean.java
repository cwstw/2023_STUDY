package game.model;

import org.hibernate.validator.constraints.NotBlank;

public class GameBean {
	
	private int num;

	private String title;
	private String genre;
	private String difficulty;
	
	public GameBean(int num, String title, String genre, String difficulty) {
		super();
		this.num = num;
		this.title = title;
		this.genre = genre;
		this.difficulty = difficulty;
	}


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


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public GameBean() {
		super();
	}
	
	
}
