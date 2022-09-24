/**
 * @author Corentin D'haeyere
 */
public class LoginInfo {
   
 	private String login;
	
	public LoginInfo(String login)throws IllegalArgumentException{
		if(login==null || login.length() != 7 ||!login.substring(0,4).equals("info"))
			throw new IllegalArgumentException("login incorrect");
		this.login = login;
	}

	public String toString(){
		return "/n"+login +"   "+login;
	}

	// renvoie un entier >= 0
	// cet entier represente de fa�on unique le login courant
	// info001 --> 0 	info002 --> 1	...	info137 --> 136
	public int hashCode(){
		return Integer.parseInt(login.substring(4, 7))-1;
	}
	
}

