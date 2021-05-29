package homework5.core.concretes;

import homework5.GoogleAuth.GoogleAuthManager;
import homework5.core.abstracts.GoogleAuthService;
import homework5.entities.concretes.User;

public class GoogleAuthManagerAdapter implements GoogleAuthService {
	
	@Override
	public void signUp(User user) {
		GoogleAuthManager authManager=new GoogleAuthManager();
		authManager.signUp(user);
		
	}

	@Override
	public void login(User user) {
		GoogleAuthManager authManager=new GoogleAuthManager();
		authManager.loginWithGoogle(user);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
