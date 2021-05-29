package homework5;

import homework5.GoogleAuth.GoogleAuthManager;
import homework5.business.abstracts.UserService;
import homework5.business.concretes.GoogleUserManager;
import homework5.business.concretes.NormalUserManager;
import homework5.core.concretes.EmailValidator;
import homework5.core.concretes.GoogleAuthManagerAdapter;
import homework5.dataAccess.concretes.AbcUserDao;
import homework5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user=new User(10,"burcu","arslan","burcuarslan@outlook.com","1234567");
		User user1=new User(6,"eren","dilli","erendilli@gmail.com","123456");
		User user3=new User(8,"burcu","arslan","burcuarslan","1234567");
		User user4=new User(8,"b","a","burcuarslan","1234567");
		//UserService service=new UserManager(new AbcUserDao(), new GoogleAuthManager());
		//service.add(user);
		//service.add(user1);
		
		  UserService service=new NormalUserManager(new AbcUserDao(),new EmailValidator());
		  service.add(user); 
		  service.verify(user);
		  System.out.println("**************");

		  UserService service1=new GoogleUserManager(new AbcUserDao(), new
		  GoogleAuthManagerAdapter(),new EmailValidator() ); service1.add(user1);
		  System.out.println("**************");
		  
		  service.add(user3); 
		  System.out.println("**************");
		  
		  service.add(user4); 
		  

	}

}
