package homework5.GoogleAuth;

import homework5.entities.concretes.User;

public class GoogleAuthManager {
	public void signUp(User user) {
		System.out.println(user.geteMail()+" Google hesab�n�z ile kaydoldunuz");
	}
	public void loginWithGoogle(User user) {
		System.out.println(user.geteMail()+"Google hesab�n�z ile giri� yapt�n�z");
	}
	public void update(User user) {
		System.out.println(user.geteMail()+" Google hesab�na sahip kullan�c�n�n bilgileri g�ncellenmi�tir");
	}
	public void delete(User user) {
		System.out.println(user.geteMail()+" Google hesab�na sahip kullan�c� silinmi�tir.");
	}
	
}
