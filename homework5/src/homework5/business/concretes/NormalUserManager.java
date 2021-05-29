package homework5.business.concretes;


import java.util.List;

import homework5.business.abstracts.UserService;
import homework5.core.abstracts.EmailValidatorService;
import homework5.dataAccess.abstracts.UserDao;

import homework5.entities.concretes.User;

public class NormalUserManager implements UserService {
	
	private UserDao userDao;
	private EmailValidatorService emailValidatorService;


	public NormalUserManager(UserDao userDao, EmailValidatorService emailValidatorService) {
		super();
		this.userDao = userDao;
		this.emailValidatorService = emailValidatorService;
	}
	@Override
	public void add(User user) {
		if (!UserRulers(user)) {
			System.out.println("kayýt baþarýsýz");
		}
		
		else {
			this.userDao.add(user);
			System.out.println("ön kayýt basarýlý");
			System.out.println("Doðrulama kodu gönderildi Epostanýzý onaylayýnýz!");
		}
		
	}
	@Override
	public void update(User user) {
	    if(!this.UserRulers(user)) {
	    	System.out.println("Güncelleme yaparken kurallara uymadýnýz!");
	        return;
		}
		
		this.userDao.update(user);
		
	}
	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}
	@Override
	public List<User> getAll() {
		
		return this.userDao.getAll();
	}
	@Override
	public void login(User user) {
		for (User users : getAll()) {
			if (users.geteMail()==user.geteMail()&& users.getPassword()==user.getPassword()) {
				System.out.println("giriþ baþarýlý");
				return;
			}
			else {
				System.out.println("giriþ baþarýsýz! e-posta veya þifre hatalý");
			}
		}
		
	}

	public boolean register(User user) {
		
		if(this.userDao.getEmail(user.geteMail())!=null) {
			
			return false;
		}
		return true;
	}
	
	private boolean checkNameAndLastName(String name, String lastName) {
		if (name.length()<2||lastName.length()<2) {
			return false;
		}
		return true;
	}
	private boolean checkPassword(String password) {
		if (password.length()<6) {
			return false;
		}
		return true;
	}
	
	
	private boolean UserRulers(User user) {
		if (!checkNameAndLastName(user.getFirstName(), user.getLastName())) {
			System.out.println("Adýnýz ve Soyadýnýz en az 2 karakterden oluþmalýdýr");
			return false;
		}
		if (!checkPassword(user.getPassword())) {
			System.out.println("Þifreniz en az 6 karakterden oluþmalýdýr");
			return false;
		}
		if (!emailValidatorService.isEmailValid(user.geteMail())) {
			System.out.println("E postanýz, e posta formatýnda olmalýdýr.");
			return false;
		}
		if (!register(user)) {
			System.out.println("Email is used. ");
			return false;
		}
		
		return true;
	}

	@Override
	public void verify(User user) {
		User user1 = this.userDao.getId(user.getId());
		System.out.println(user1.geteMail()+" adlý Epostanýz doðrulanmýþtýr");
		user.setUserVerification(true);
		
	}




	





}
