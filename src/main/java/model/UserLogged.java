package model;

import java.util.ArrayList;
import java.util.List;

/*
 * UserLogged class
 */
public class UserLogged
{
	public final static int CUSTOMER = 0;
	public final static int PROVIDER = 1;
	public final static int ADMINISTRATOR = 2;
	
	public static int userId = 0;
	public static int userRole = -1;
	public static int userAccepted = -1;
	public static int userLocation = -1;
	public static int idProvider = -1;
	
	public static List<Provider> providers = new ArrayList<>();
	
	public static List<Dates> dates = new ArrayList<>();
	
	public static List<Admin> adminAcceptProviders = new ArrayList<>();
}
