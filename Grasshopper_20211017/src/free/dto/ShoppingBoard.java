package free.dto;

public class ShoppingBoard {
	private int shopping_product_no;
	private String shopping_category;
	private String shopping_product_title;
	private int shopping_product_price;
	private String shopping_product_content;
	private String shopping_product_link;
	private String shopping_img_link;
	@Override
	public String toString() {
		return "ShoppingBoard [shopping_product_no=" + shopping_product_no + ", shopping_category=" + shopping_category
				+ ", shopping_product_title=" + shopping_product_title + ", shopping_product_price="
				+ shopping_product_price + ", shopping_product_content=" + shopping_product_content
				+ ", shopping_product_link=" + shopping_product_link + ", shopping_img_link=" + shopping_img_link + "]";
	}
	public int getShopping_product_no() {
		return shopping_product_no;
	}
	public void setShopping_product_no(int shopping_product_no) {
		this.shopping_product_no = shopping_product_no;
	}
	public String getShopping_category() {
		return shopping_category;
	}
	public void setShopping_category(String shopping_category) {
		this.shopping_category = shopping_category;
	}
	public String getShopping_product_title() {
		return shopping_product_title;
	}
	public void setShopping_product_title(String shopping_product_title) {
		this.shopping_product_title = shopping_product_title;
	}
	public int getShopping_product_price() {
		return shopping_product_price;
	}
	public void setShopping_product_price(int shopping_product_price) {
		this.shopping_product_price = shopping_product_price;
	}
	public String getShopping_product_content() {
		return shopping_product_content;
	}
	public void setShopping_product_content(String shopping_product_content) {
		this.shopping_product_content = shopping_product_content;
	}
	public String getShopping_product_link() {
		return shopping_product_link;
	}
	public void setShopping_product_link(String shopping_product_link) {
		this.shopping_product_link = shopping_product_link;
	}
	public String getShopping_img_link() {
		return shopping_img_link;
	}
	public void setShopping_img_link(String shopping_img_link) {
		this.shopping_img_link = shopping_img_link;
	}
	
}
