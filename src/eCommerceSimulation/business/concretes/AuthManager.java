package eCommerceSimulation.business.concretes;

import eCommerceSimulation.business.abstracts.AuthService;
import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.core.utils.Utils;
import eCommerceSimulation.entities.concretes.LoginDto;
import eCommerceSimulation.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.getEmail()) == false
				&& Utils.emailValidate(user.getEmail())) {
			userService.add(user);
		} else {
			System.out.println("Registration failed.");
		}

	}

	@Override
	public void verify(User user, String token) {
		if (user != null && token.length() > 20) {
			User existsUser = userService.get(user.getEmail());
			existsUser.setVerify(true);

			userService.update(existsUser);
			System.out.println("Account verified.");
		} else {
			System.out.println("Account could not be verified.");
		}

	}

	@Override
	public boolean userExists(String email) {
		User user = userService.get(email);

		if (user == null) {
			return false;
		} else {
			System.out.println("The e-mail address is already registered: " + email);
			return true;
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());

		if (user != null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Login successful.");
		} else {
			System.out.println("Email address or password is incorrect.");
		}

	}

	public boolean userValidate(User user) {
		if (user != null && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
		} else {
			System.out.println("Password must be at least 6 characters.");
			return false;
		}
	}

}
