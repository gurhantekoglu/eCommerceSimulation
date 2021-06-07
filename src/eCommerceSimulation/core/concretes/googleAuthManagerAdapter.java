package eCommerceSimulation.core.concretes;

import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.core.abstracts.ExternalAuthService;
import eCommerceSimulation.entities.concretes.LoginDto;
import eCommerceSimulation.entities.concretes.User;

public class googleAuthManagerAdapter implements ExternalAuthService {
	private UserService userService;

	public googleAuthManagerAdapter(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void register(String email) {
		if (userExists(email) == false) {
			userService.add(null);
		} else {
			User user = userService.get(email);

			LoginDto dto = new LoginDto();
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());

			login(dto);
		}

	}

	@Override
	public boolean userExists(String email) {
		if (userService.get(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void login(LoginDto dto) {
		if (dto != null && dto.getPassword().equals(dto.getPassword())) {
			System.out.println("Login successful.");
		} else {
			System.out.println("Email address or password is incorrect.");
		}

	}
}
