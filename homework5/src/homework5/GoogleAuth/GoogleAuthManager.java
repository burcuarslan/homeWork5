package homework5.GoogleAuth;

import homework5.entities.concretes.User;

public class GoogleAuthManager {
	public void signUp(User user) {
		System.out.println(user.geteMail()+" Google hesabınız ile kaydoldunuz");
	}
	public void loginWithGoogle(User user) {
		System.out.println(user.geteMail()+"Google hesabınız ile giriş yaptınız");
	}
	public void update(User user) {
		System.out.println(user.geteMail()+" Google hesabına sahip kullanıcının bilgileri güncellenmiştir");
	}
	public void delete(User user) {
		System.out.println(user.geteMail()+" Google hesabına sahip kullanıcı silinmiştir.");
	}
	
}
