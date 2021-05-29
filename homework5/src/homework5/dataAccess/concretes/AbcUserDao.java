package homework5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import homework5.dataAccess.abstracts.UserDao;
import homework5.entities.concretes.User;

public class AbcUserDao implements UserDao{
	List<User> users=new ArrayList<User>();
	
	public AbcUserDao() {
		User user = new User(1,"Burcu","Arslan","burcu@gmail.com","1234567");
		User user1= new User(2,"Eren","Dilli","eren@gmail.com","123");
		User user2 = new User(3,"Ayþe","Çaðlar","ayse@gmail.com","123245");
		User user3= new User(4,"Salih","Salur","salih@gmail.com","1324");
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}
	
	@Override
	public void add(User user) {
		this.users.add(user);
		//System.out.println(user.geteMail()+" e mail adresli kullanýcý üyeliði baþlatýldý" );
		
	}

	@Override
	public void update(User user) {
		//System.out.println(user.geteMail()+" e mail adresli kullanýcý güncellendi" );
		
	}

	@Override
	public void delete(User user) {
		
		//System.out.println(user.geteMail()+" e mail adresli kullanýcý üyeliði sonlandý" );
		
	}

	@Override
	public List<User> getAll() {
	
		return this.users;
	}

	@Override
	public User getEmail(String email) {
		User userEmail = this.users.stream().filter(user-> user.geteMail().equals(email)).findFirst().orElse(null);
		return userEmail;
	}

	@Override
	public User getId(int id) {
		User selectedUser= this.users.stream().filter((u) -> u.getId() == id).findFirst().get();
		return selectedUser;
	}

}
