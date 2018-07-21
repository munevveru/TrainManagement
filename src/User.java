//This class contains the information about all existing users.
//Methods :
// getUsername() method gives us the name of the User.
// getPassword() method gives the password.
//Set methods gives access us to change the properties of User.
// setUsername() sets the name of user.
// setPassword() sets password.
// toString() gives us the string version.
public class User {
	private String username;
	private String password;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.username = password;
	}
	
}
