package eCommerceSimulation.business.abstracts;

import eCommerceSimulation.entities.concretes.LoginDto;
import eCommerceSimulation.entities.concretes.User;

public interface AuthService {
	void register(User user);

	void verify(User user, String token);

	boolean userExists(String email);

	void login(LoginDto dto);
}
