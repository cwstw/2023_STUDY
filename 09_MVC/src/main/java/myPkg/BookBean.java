package myPkg;

public class BookBean {
	private int no;
	private String title;
	private String author;
	private int price;
	
	
	public BookBean() {
		super();
	}
	public BookBean(int no, String title, String author, int price) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
