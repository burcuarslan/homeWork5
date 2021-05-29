package homework5.business.abstracts;

import java.util.List;

import homework5.entities.concretes.User;

public interface UserService {
	void login(User user);
	void add(User user);
	void update(User user);
	void delete(User user);
	void verify(User user);
	
	List<User> getAll();
	
}
