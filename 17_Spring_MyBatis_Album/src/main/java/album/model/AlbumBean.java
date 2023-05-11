package album.model;

public class AlbumBean {
	
	//mybatis를 위해서는 칼럼 이름과 변수 이름이 똑같아야 한다.
	private int num;
	private String title;
	private String singer;
	private String price; //유효성 검사는 int면 불가
	private String day;
	
	
	public AlbumBean() {
		super();
	}
	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
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
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
