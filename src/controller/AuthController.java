package controller;
import view.authView;


public class AuthController {

	private authView vista;
	
	public AuthController(){
		
		vista = new authView();
		
	}
	
	public void login()
	{
		vista.login();
	}
	
}
