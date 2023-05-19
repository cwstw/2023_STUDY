package product.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private int num;
	
	@NotBlank(message = "상품명은 필수 입력")
	@Length(min=3,max=10,message = "3~10자리 사이 입력")
	private String name;
	private String company;
	
	@NotBlank(message = "이미지는 필수 선택")
	private String image;
	private int stock;
	
	@NotBlank(message = "가격은 필수 입력")
	@Range(min = 3000, message = "가격은 최소 3000원 이상입니다.")
	private int price;
	private String category;
	
	@NotBlank(message = "내용은 필수 입력")
	private String contents;
	private int point;
	private String inputdate;
	
	private MultipartFile upload;
	//setter getter 추가
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		System.out.println("setupload");
		this.upload = upload;
		
		System.out.println("upload : "+upload);
		String filename = upload.getOriginalFilename();
		System.out.println("filename : "+filename);//파일명 출력
		this.image = filename;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public ProductBean(int num, String name, String company, String image, int stock, int price, String category,
			String contents, int point, String inputdate) {
		super();
		this.num = num;
		this.name = name;
		this.company = company;
		this.image = image;
		this.stock = stock;
		this.price = price;
		this.category = category;
		this.contents = contents;
		this.point = point;
		this.inputdate = inputdate;
	}
	public ProductBean() {
		super();
	}
	
	
}
