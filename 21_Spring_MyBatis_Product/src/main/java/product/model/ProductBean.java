package product.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private int num;
	
	@NotBlank(message = "��ǰ���� �ʼ� �Է�")
	@Length(min=3,max=10,message = "3~10�ڸ� ���� �Է�")
	private String name;
	private String company;
	
	@NotBlank(message = "�̹����� �ʼ� ����")
	private String image;
	private int stock;
	
	@NotBlank(message = "������ �ʼ� �Է�")
	@Range(min = 3000, message = "������ �ּ� 3000�� �̻��Դϴ�.")
	private int price;
	private String category;
	
	@NotBlank(message = "������ �ʼ� �Է�")
	private String contents;
	private int point;
	private String inputdate;
	
	private MultipartFile upload;
	//setter getter �߰�
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		System.out.println("setupload");
		this.upload = upload;
		
		System.out.println("upload : "+upload);
		String filename = upload.getOriginalFilename();
		System.out.println("filename : "+filename);//���ϸ� ���
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
