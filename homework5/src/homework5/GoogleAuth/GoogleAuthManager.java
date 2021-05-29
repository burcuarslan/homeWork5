package homework5.GoogleAuth;

import homework5.entities.concretes.User;

public class GoogleAuthManager {
	public void signUp(User user) {
		System.out.println(user.geteMail()+" Google hesabýnýz ile kaydoldunuz");
	}
	public void loginWithGoogle(User user) {
		System.out.println(user.geteMail()+"Google hesabýnýz ile giriþ yaptýnýz");
	}
	public void update(User user) {
		System.out.println(user.geteMail()+" Google hesabýna sahip kullanýcýnýn bilgileri güncellenmiþtir");
	}
	public void delete(User user) {
		System.out.println(user.geteMail()+" Google hesabýna sahip kullanýcý silinmiþtir.");
	}
	
}
