package constant;

public class Constant {
	
	public static final String CONFIG_FILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	//Constant variable in caps.
	//to get the local path automatically, use "System.getProperty("user.dir")". user.dir means user directory
	
	public static final String TEST_DATA = System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryAppData.xlsx";
	
	public static final String VALID_CREDENTIAL_ERROR = "User Is Unable To Login With Valid Credentials";

	public static final String INVALID_CREDENTIAL_ERROR =  "User is able to login with invalid credentials";

	public static final String VALIDUSERNAME_INVALIDPASSWORD = "User is able to login with valid username and invalid password";

	public static final String INVALIDUSERNAME_VALIDPASSWORD = "User is able to login with invalid username and valid password";

	public static final String LOGOUT = "User is unable to logout";

	public static final String ADD_NEW_ADMINUSERS = "New user hasn't created";

	public static final String SEARCH_ADMINUSERS = "User is unable to search admin user";
	
	public static final String ADD_DELIVERYBOY = "New delivery boy hasn't created";
	
	public static final String SEARCH_DELIVERYBOY = "User is unable to search delivery boy";
	
	public static final String MANAGE_PAGES = "New page hasn't created";
	
	public static final String SEARCH_PAGES = "User is unable to search page";

}


//"C:\Users\arjun\eclipse-workspace\GroceryApplication\src\main\resources\config.properties"
//"C:\Users\arjun\eclipse-workspace\GroceryApplication --- local path 
//\src\main\resources\config.properties" --- 

//"C:\\Users\\arjun\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\GroceryAppData.xlsx" -----from excel 