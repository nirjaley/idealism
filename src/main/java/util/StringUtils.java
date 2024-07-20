package util;

public class StringUtils {


	public static final String SELECT_PRODUCT = "SELECT product_id, product_name, unit_price FROM product WHERE product_id = ?";
	public static final String SEARCH_PRODUCT = "SELECT product_id, product_name, unit_price FROM product WHERE product_name LIKE ?";
	public static final String INSERT_ORDERS = "INSERT INTO orders (product_id, product_name, quantity, unit_price, total_price) VALUES (?, ?, ?, ?, ?)";
	public static final String UPDATE_PRODUCT = "UPDATE product SET stock = stock - ? WHERE product_id = ?";
	
	// Start: DB Connection
		public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/idealism";
		public static final String LOCALHOST_USERNAME = "root";
		public static final String LOCALHOST_PASSWORD = "";
		// End: DB Connection

		// Start: Queries
		public static final String QUERY_REGISTER_USER= "INSERT INTO user (" + "first_name, last_name, phone_number, address, email, password)" + "VALUES (?, ?, ?, ?, ?, ?)";
		public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM user WHERE email = ?";
		public static final String QUERY_GET_ALL_STUDENTS = "SELECT * FROM student_info";
		public static final String QUERY_GET_USER_ID = "SELECT id FROM student_info WHERE user_name = ?";
		public static final String QUERY_DELETE_USER = "DELETE FROM student_info WHERE user_name = ?";
		public static final String QUERY_ROLE = "SELECT role FROM user WHERE email = ?";
		// End: Queries

		// Start: Parameter names
		public static final String FIRST_NAME = "first_name";
		public static final String LAST_NAME = "last_name";
		public static final String PHONE_NUMBER = "phone_number";
		public static final String ADDRESS = "address";
		public static final String EMAIL = "email";
		public static final String PASSWORD = "password";

		// End: Parameter names

		// Start: Validation Messages
		// Register Page Messages
		public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
		public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
		public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
		public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
		public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
		public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
		public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";

		// Login Page Messages
		public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
		public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
		public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

		// Other Messages
		public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
		public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
		public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";

		public static final String MESSAGE_SUCCESS = "successMessage";
		public static final String MESSAGE_ERROR = "errorMessage";
		// End: Validation Messages

		// Start: JSP Route
		public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
		public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
		public static final String PAGE_URL_HOME = "/pages/home.jsp";
		public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
		public static final String PAGE_URL_HEADER = "pages/header.jsp";
		public static final String PAGE_URL_USER_PROFILE = "pages/userProfile.jsp";
		public static final String URL_LOGIN = "/login.jsp";
		public static final String URL_INDEX = "/index.jsp";
		// End: JSP Route

		// Start: Servlet Route
		public static final String SERVLET_URL_LOGIN = "/Login";
		public static final String SERVLET_URL_REGISTER = "/registerstudent";
		public static final String SERVLET_URL_LOGOUT = "/logout";
		public static final String SERVLET_URL_HOME = "/home";
		public static final String SERVLET_URL_MODIFY_USER = "/modifyUser";
		public static final String SERVLET_URL_USER_PROFILE_USER = "/UserProfileServlet";
		// End: Servlet Route

		// Start: Normal Text
		public static final String USER = "user";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		public static final String STUDENT_MODEL = "studentModel";
		public static final String STUDENT_LISTS = "studentLists";
		public static final String SLASH= "/";
		public static final String DELETE_ID= "deleteId";
		//public static final String UPDATE_ID= "updateId";
		
		
		public static final String INSERT_PRODUCT = "INSERT INTO `product`(`product_id`, `product_name`, `unit_price`, `category`, `stock`, `image`) VALUES (?,?,?,?,?,?)";
		public static final String GET_ALL_PRODUCTS ="SELECT * FROM product";
		
		public static final String IMAGE_ROOT_PATH = "/Users/abhi/eclipse-workspace/idealism/src/main/webapp/resources/images/";
		public static final String IMAGE_PRODUCT_DIR = IMAGE_ROOT_PATH + "product";
		
		public static final String PAGE_ADD_PRODUCT = "pages/addproduct.jsp";
		
		public static final String DELETE_PRODUCT = "DELETE FROM `product` WHERE `product_id` = ? ";
		
		public static final String UPDATE_PRODUCT1 = "UPDATE `product` SET `product_name`=?,`unit_price`=?,`category`= ?,`stock`= ?,`image`=? WHERE `product_id` = ?";
		public static final String UPDATE_PRODUCT_NO_IMG = "UPDATE `product` SET `product_name`=?,`unit_price`=?,`category`= ?,`stock`= ? WHERE `product_id` = ?";
		public static final String GET_ORDER = "SELECT `order_id`, `product_id`, `product_name`, `quantity`, `unit_price`, `total_price` FROM `orders` WHERE 1";

		
		// Start: Attribute name
		public static final String USER_PROFILE_ATTRIBUTE = "userProfile";
		// End: Attribute name
		
		//new weejan
		public static final String UPDATE_ID = "update_id";
	    public static final String SERVLET_URL_PRODUCT_UPDATE ="/ModifyProductServlet";
	    public static final String PAGE_URL_UPDATE_PRODUCT = "/pages/UpdateProduct.jsp";


}