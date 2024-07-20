package model;

public class Product {
	private int product_id;
	private String product_name;
	private int unit_price;

    public Product() {	
    }


	public Product(int product_id, String product_name, int unit_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.unit_price = unit_price;
		
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
	

	public int getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}


	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", unit_price=" + unit_price + "]";
	}

	

}
