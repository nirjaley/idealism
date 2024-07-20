package controller.database;

import java.sql.Connection;
import util.StringUtils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginModel;
import model.OrderModel;
import model.PasswordEncryptionWithAes;
import model.Product;
import model.ProductModel;
import model.UserModel;

public class DatabaseController {

		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/idealism"; 
			String user = "root";
			String pass = "";
			return DriverManager.getConnection(url, user, pass);
		}
		
		 public static List<Product> searchProducts(String query) throws SQLException {
		        List<Product> searchResults = new ArrayList<>();
		        Connection connection = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;

		        try {
		            connection = getConnection();

		            // Build prepared statement with LIKE operator for search term
		            String sql = StringUtils.SEARCH_PRODUCT;
		            ps = connection.prepareStatement(sql);
		            ps.setString(1, "%" + query + "%"); // Add wildcards for partial matches

		            rs = ps.executeQuery();

		            // Iterate through results and populate Product objects
		            while (rs.next()) {
		                int product_id = rs.getInt("product_id");
		                String name = rs.getString("product_name");
		                int price = rs.getInt("unit_price");

		                Product product = new Product(product_id, name, price);
		                searchResults.add(product);
		            }
		        } catch (SQLException | ClassNotFoundException e) {
		            e.printStackTrace();
		            // Handle database errors (log or throw exception)
		        } finally {
		            // Close resources properly
		            if (rs != null) {
		                rs.close();
		            }
		            if (ps != null) {
		                ps.close();
		            }
		            if (connection != null) {
		                connection.close();
		            }
		        }

		        return searchResults;
		    }
		 
		 public static Connection getConnection1() throws SQLException, ClassNotFoundException {

				// Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
				Class.forName(StringUtils.DRIVER_NAME);

				// Create a connection to the database using the provided credentials
				return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
						StringUtils.LOCALHOST_PASSWORD);
			}

			public int registerUser(UserModel user) {

				try {
					// Prepare a statement using the predefined query for student registration
					PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_USER);

					// Set the student information in the prepared statement
					stmt.setString(1, user.getFirstName());
					stmt.setString(2, user.getLastName());
					stmt.setString(3, user.getPhoneNumber());
					stmt.setString(4, user.getAddress());
					stmt.setString(5, user.getEmail());
					stmt.setString(6, PasswordEncryptionWithAes.encrypt(user.getEmail(), user.getPassword()));

					// Execute the update statement and store the number of affected rows
					int result = stmt.executeUpdate();

					// Check if the update was successful (i.e., at least one row affected)
					if (result > 0) {
						return 1; // Registration successful
					} else {
						return 0; // Registration failed (no rows affected)
					}
				} catch (ClassNotFoundException | SQLException ex) {
					// Print the stack trace for debugging purposes
					ex.printStackTrace();
					return -1; // Internal error
				}
			}

			public int getStudentLoginInfo(LoginModel loginModel) {
				// Try-catch block to handle potential SQL or ClassNotFound exceptions
				try {
					// Prepare a statement using the predefined query for login check
					PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_USER_CHECK);

					// Set the username in the first parameter of the prepared statement
					st.setString(1, loginModel.getEmail());

					// Execute the query and store the result set
					ResultSet result = st.executeQuery();

					// Check if there's a record returned from the query
					if (result.next()) {
						// Get the username from the database
						String userEmail = result.getString(StringUtils.EMAIL);

						// Get the password from the database
						String encryptedPwd = result.getString(StringUtils.PASSWORD);

						String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userEmail);
						// Check if the username and password match the credentials from the database
						if (userEmail.equals(loginModel.getEmail()) && decryptedPwd.equals(loginModel.getPassword())) {
							return 1;
						} else {
							return 0;
						}
					} else {
						return -1;
					}

					// Catch SQLException and ClassNotFoundException if they occur
				} catch (SQLException | ClassNotFoundException ex) {
					// Print the stack trace for debugging purposes
					ex.printStackTrace();
					// Return -2 to indicate an internal error
					return -2;
				}
			}
			
			
			  public int addProduct(ProductModel product) {
			    	try {
						Connection con = DatabaseController.getConnection();
						PreparedStatement ps = con.prepareStatement(StringUtils.INSERT_PRODUCT);
						ps.setInt(1,product.getProductID());
						ps.setString(2,product.getProductName());
						ps.setInt(3,product.getUnitprice());
						ps.setString(4,product.getCategory());
						ps.setInt(5,product.getStock());
						ps.setString(6,product.getImagePath());
						
						int result = ps.executeUpdate();
						if(result > 0) {
					  		return 1;
//							response.sendRedirect("pages/productManagement.jsp?msg=done");
						}
						else {
							return 0;
//							response.sendRedirect("pages/productManagement.jsp?msg=wrong");
						}
						
					}
					catch(Exception e) {
//						e.printStackTrace();
//						System.out.print("Exception");
						return -1;
//						response.sendRedirect("pages/productManagement.jsp?msg=exception");
					}	
			    }
			    public int ProductInfoDelete(int productID) {
					try (Connection con = getConnection()) {
						PreparedStatement st = con.prepareStatement(StringUtils.DELETE_PRODUCT);
						st.setInt(1, productID);
						return st.executeUpdate();
					} catch (SQLException | ClassNotFoundException ex) {
						ex.printStackTrace(); // Log the exception for debugging
						return -1;
					}
				}
			    public ArrayList<ProductModel> getProductInfo(){
			    	try {
						Connection con = DatabaseController.getConnection();
						PreparedStatement st = con.prepareStatement(StringUtils.GET_ALL_PRODUCTS);
						ResultSet rs = st.executeQuery();
						
						ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
						
						while(rs.next()) {
							
							ProductModel product = new ProductModel();
							product.setProductID(rs.getInt("product_id"));
							product.setProductName(rs.getString("product_name"));
							product.setUnitprice(rs.getInt("unit_price"));
							product.setCategory(rs.getString("category"));
							product.setStock(rs.getInt("stock"));
							product.setImagePath(rs.getString("image"));
				            productList.add(product);
				             
						}
						return productList;
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
			    }
			    
			    
			    public ProductModel updateProduct(String product_id) throws SQLException, ClassNotFoundException {
			        Connection con = DatabaseController.getConnection();

//			        PreparedStatement statement = conn.prepareStatement("Update FROM product WHERE product_id = ?");
			        PreparedStatement st = con.prepareStatement("select * from product where product_id=?");
			        st.setString(1, product_id);
			        ResultSet rs = st.executeQuery();
			        ProductModel product =new ProductModel();
			        if(rs.next())
			        {
			            product.setProductID(rs.getInt("product_id"));
			            product.setProductName(rs.getString("product_name"));
			            product.setUnitprice(rs.getInt("unit_price"));

			            product.setStock(rs.getInt("stock"));
			            product.setCategory(rs.getString("category"));
			        }
			        return product;
			    }
			    
			    public int updateprd(ProductModel product) {
			        int result = 0;
			        try(Connection con = getConnection()) {
			        PreparedStatement st = con.prepareStatement(StringUtils.UPDATE_PRODUCT_NO_IMG);
					st.setInt(1, product.getProductID());
			        st.setString(2, product.getProductName());
					st.setInt(3, product.getUnitprice());
					st.setString(4, product.getCategory());
					st.setInt(5, product.getStock());
//					st.setString(6, product.getImagePath());
			        result = st.executeUpdate();

			        if (result > 0) {
			        return 1;
			        } else {
			        // Not found
			        return 0;
			        }
			        } catch (ClassNotFoundException | SQLException ex) {
			        ex.printStackTrace();
			        return -1;
			        }
			        }
			    	public ArrayList<OrderModel> getOrder() throws ClassNotFoundException, SQLException{
			    		try(Connection con = getConnection()){
			    			PreparedStatement st = con.prepareStatement(StringUtils.GET_ORDER);
			    			ResultSet rs = st.executeQuery();
			    			
			    			ArrayList<OrderModel> orders = new ArrayList<>();
			    			while(rs.next()) {
			    				OrderModel order = new OrderModel();
			    				order.setOrder_Id(rs.getInt("order_Id"));
			    				order.setProduct_id(rs.getInt("product_id"));
			    				order.setProduct_name(rs.getString("product_name"));
			    				order.setQuantity(rs.getInt("quantity"));
			    				order.setUnit_price(rs.getInt("unit_price"));
			    				order.setTotal_price(rs.getInt("total_price"));
			    				orders.add(order);
			    			}
			    			return orders;
			    			}catch(SQLException | ClassNotFoundException ex) {
			    				ex.printStackTrace();
			    				return null;
			    			}
			    							
			    	}
			    	public UserModel getUserProfile(String email) {
			    		UserModel user = new UserModel();
			    		try {
			    			Connection conn = getConnection();
			    			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE email = ?");
			    			stmt.setString(1, email);
			    			ResultSet result = stmt.executeQuery();
			    			if (result.next()) {
			    				
			    				// Get  user details from the database
			    				String firstname = result.getString(StringUtils.FIRST_NAME);
			    				String lastname = result.getString(StringUtils.LAST_NAME);
			    				String address = result.getString(StringUtils.ADDRESS);
			    				String phonenumber = result.getString(StringUtils.PHONE_NUMBER);
			    				String password = result.getString(StringUtils.PASSWORD);
			    				
			    				//Update user details 
			    				user.setFirstName(firstname);
			    	            user.setLastName(lastname);
			    	            user.setPhoneNumber(phonenumber);
			    	            user.setAddress(address);
			    	            user.setPassword(password);
			    	            return user;
			    			}
			    	      
			    		}
			    		catch  (ClassNotFoundException | SQLException ex) {
			    			ex.printStackTrace();
			    		}
			    			return null;
			    	}
			    	
			    	// For updated details by the user
			    	public boolean updateUserProfile(UserModel user) {
			    		try {
			    			Connection conn = getConnection();
			    			PreparedStatement stmt = conn.prepareStatement("UPDATE user SET address = ?, phone_number = ?, password = ? WHERE email = ?");
			    			stmt.setString(1, user.getAddress());
			    			stmt.setString(2, user.getPhoneNumber());
			    			stmt.setString(3, user.getPassword());
			    			stmt.setString(4, user.getEmail());
			    			
			    			int rowUpdated = stmt.executeUpdate();
			    			return rowUpdated > 0;
			    		}
			    		catch(ClassNotFoundException | SQLException ex) {
			    			ex.printStackTrace();
			    			return false;
			    		}
			    	}
			    	
			    	public static boolean isAdmin(String email) {
			    		try {
			    			Connection conn = getConnection();
			    			PreparedStatement stmt = conn.prepareStatement(StringUtils.QUERY_ROLE);
			    			stmt.setString(1, email);
			    			ResultSet rs = stmt.executeQuery();
			    			if (rs.next()) {
			    				String role = rs.getString("role");
			    				return role != null && role.equals("admin");
			    			}
			    		} catch (SQLException | ClassNotFoundException e) {
			    			e.printStackTrace();
			    		}
			    		return false;
			    	}
			    	
			    	public int updateProductAct(ProductModel upProductModel) {
			            try (Connection con = getConnection()) {
			                PreparedStatement st = con.prepareStatement("UPDATE product SET product_name=?,unit_price=?,category= ?,stock= ? WHERE product_id = ?");
			                st.setString(1, upProductModel.getProductName());
			                st.setInt(2, upProductModel.getUnitprice());
			                st.setString(3, upProductModel.getCategory());
			                st.setInt(4, upProductModel.getStock());
			                st.setInt(5, upProductModel.getProductID());


			                return st.executeUpdate();
			            } catch (SQLException | ClassNotFoundException ex) {
			                ex.printStackTrace(); // Log the exception for debugging
			                return -1;
			            }
			        }
			    	
			    	
			    	public ProductModel getProductInfoUp(int product_id){
			            try {
			                Connection con = DatabaseController.getConnection();
			                PreparedStatement st = con.prepareStatement("SELECT * FROM product WHERE product_id = ?");
			                st.setInt(1,product_id);
			                ResultSet rs = st.executeQuery();

			                ProductModel product = new ProductModel();

			                while(rs.next()) {


			                    product.setProductID(rs.getInt("product_id"));
			                    product.setProductName(rs.getString("product_name"));
			                    product.setUnitprice(rs.getInt("unit_price"));
			                    product.setCategory(rs.getString("category"));
			                    product.setStock(rs.getInt("stock"));
			                    product.setImagePath(rs.getString("image"));
			                    return product;

			                }

			            } catch (ClassNotFoundException | SQLException e) {
			                // TODO Auto-generated catch block
			                e.printStackTrace();
			            }
			            return null;}

			    }



