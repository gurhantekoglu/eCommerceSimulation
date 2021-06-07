package eCommerceSimulation;

import eCommerceSimulation.business.concretes.AuthManager;
import eCommerceSimulation.business.concretes.UserManager;
import eCommerceSimulation.core.adapter.GoogleManagerAdapter;
import eCommerceSimulation.dataAccess.concretes.InMemoryUserDao;
import eCommerceSimulation.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		AuthManager authManager = new AuthManager(new UserManager(inMemoryUserDao, new GoogleManagerAdapter()));

		User user = new User(1, "Gürhan", "Tekoðlu", "gurhantekoglu@gmail.com", "123456", true);

		UserManager userManager = new UserManager(new InMemoryUserDao(), new GoogleManagerAdapter());
		userManager.add(user);
	}

}
