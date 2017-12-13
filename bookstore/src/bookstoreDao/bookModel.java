package bookstoreDao;

public class bookModel {
	private String type;
	private int id;
	private String	title;
	private String	writer;
	private double	discount;
	private double	price;
	private int		amount;
	private String	synopsis;
	
	public bookModel(){}
	public bookModel(String title, String writer, double discount, double price, int amount, String synopsis,String type) {
		this.title = title;
		this.writer = writer;
		this.discount = discount;
		this.price = price;
		this.amount = amount;
		this.synopsis = synopsis;
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	@Override
	public String toString() {
		return "bookmodel [title=" + title + ", writer=" + writer + ", discount=" + discount + ", price=" + price
				+ ", amount=" + amount + ", synopsis=" + synopsis + "]";
	}
	
}
