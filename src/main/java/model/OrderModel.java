package model;

public class OrderModel {
	private int order_Id;
	private int product_id;
	private String product_name;
	private int quantity;
	private int unit_price;
	private int total_price;
	
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public OrderModel(int order_Id, int product_id, String product_name, int quantity, int unit_price,
			int total_price) {
		super();
		this.order_Id = order_Id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.total_price = total_price;
	}
	public OrderModel() {
	this.order_Id=0;
	this.product_id=0;
	this.product_name="";
	this.quantity=0;
	this.unit_price=0;
	this.total_price=0;
		// TODO Auto-generated constructor stub
	}

}
