package homework5.core.abstracts;

import homework5.entities.concretes.User;

public interface GoogleAuthService {
	void signUp(User user);
	void login(User user);
	void update(User user);
	void delete(User user);
}
