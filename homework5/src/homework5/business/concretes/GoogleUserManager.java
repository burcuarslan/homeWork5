package homework5.business.concretes;

import java.util.List;

import homework5.business.abstracts.UserService;
import homework5.core.abstracts.EmailValidatorService;
import homework5.core.abstracts.GoogleAuthService;
import homework5.dataAccess.abstracts.UserDao;
import homework5.entities.concretes.User;

public class GoogleUserManager implements UserService {
	private UserDao userDao;
	private GoogleAuthService authService;
	private EmailValidatorService emailValidatorService;

	public GoogleUserManager(UserDao userDao, GoogleAuthService authService,
			EmailValidatorService emailValidatorService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
		this.emailValidatorService = emailValidatorService;
	}

	@Override
	public void login(User user) {
		
		authService.login(user);
		
	}

	@Override
	public void add(User user) {
		if (register(user)) {
			System.out.println("Bu eposta zaten kullanýmda");
		}
		else if (!emailValidatorService.isEmailValid(user.geteMail())) {
			System.out.println("Geçersiz eposta");
		}
		else if( user.geteMail().length()<=0 && user.getPassword().length()<=0) {
			System.out.println("Bu alanlar boþ býrakýlamaz");
    		
    	}
		else {
			authService.signUp(user);
			user.setUserVerification(true);
			
		}
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

	
	@Override
	public void verify(User user) {
		User user1 = this.userDao.getId(user.getId());
		System.out.println(user1.geteMail()+"adlý Epostanýz doðrulanmýþtýr");
		user.setUserVerification(true);
		
	}

	
	public boolean register(User user) {
		if(this.userDao.getEmail(user.geteMail())!=null) {
			
			return true;
		}
		return false;
	}
	

}


