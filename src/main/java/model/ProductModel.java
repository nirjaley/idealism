package model;

import java.io.File;

import javax.servlet.http.Part;

import util.StringUtils;

public class ProductModel {
	
	private int productID;
	private String productName;
	private int unitprice;
	private String category;
	private int stock;
	private String imagePath;
	
	

//	productIDInt

	public ProductModel(int productIDInt, String productName, int unitPriceInt,
			String category, int stockInt,Part image) {
		super();
		this.productID = productIDInt;
		this.productName = productName;
		this.setUnitprice(unitPriceInt);
		this.setCategory(category);
		this.stock = stockInt;
		this.setImagePath(getImageUrl(image));
	}
	public ProductModel() {
		
		this.productID = 0;
		this.productName = "";
		this.unitprice = 0;
		this.category = "";
		this.stock = 0;
		this.imagePath = "";
	}
	


	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitPriceInt) {
		this.unitprice = unitPriceInt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public static String getImageUrl(Part part) {
		// Define the directory path to store uploaded user images. This path should be configured elsewhere in the application.
	    String savePath = StringUtils.IMAGE_PRODUCT_DIR;

	    // Create a File object representing the directory to store uploaded images.
	    File fileSaveDir = new File(savePath);

	    // Initialize the variable to store the extracted image file name.
	    String imageUrlFromPart = null;

	    // Check if the directory to store uploaded images already exists.
	    if (!fileSaveDir.exists()) {
	        // If the directory doesn't exist, create it.
	    	// user mkdirs() method to create multiple or nested folder
	        fileSaveDir.mkdir();
	    }

	    // Get the Content-Disposition header from the request part. This header contains information about the uploaded file, including its filename.
	    String contentDisp = part.getHeader("content-disposition");

	    // Split the Content-Disposition header into individual parts based on semicolons.
	    String[] items = contentDisp.split(";");

	    // Iterate through each part of the Content-Disposition header.
	    for (String s : items) {
	        // Check if the current part starts with "filename" (case-insensitive trim is used).
	        if (s.trim().startsWith("filename")) {
	            // Extract the filename from the current part.
	            // The filename is assumed to be enclosed in double quotes (").
	            // This part removes everything before the equal sign (=) and the double quotes surrounding the filename.
	            imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
	            break; // Exit the loop after finding the filename
	        }
	    }

	    // If no filename was extracted from the Content-Disposition header, set a default filename.
	    if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
	        imageUrlFromPart = "default_user.jpg";
	    }

	    // Return the extracted or default image file name.
	    return imageUrlFromPart;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}





	
	
}

