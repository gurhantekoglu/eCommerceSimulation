package eCommerceSimulation.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSimulation.dataAccess.abstracts.UserDao;
import eCommerceSimulation.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();

	public InMemoryUserDao() {

	}

	@Override
	public void add(User user) {
		System.out.println("Email address verified and user registered: " + user.getEmail());
		users.add(user);
	}

	@Override
	public void update(User user) {
		User userUpdate = users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
		userUpdate.setEmail(user.getEmail());
		userUpdate.setFirstName(user.getFirstName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setVerify(user.isVerify());

	}

	@Override
	public void delete(int userId) {
		User userDelete = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
		users.remove(userDelete);

	}

	@Override
	public User get(String email) {
		User user = users.stream().filter(u -> u.getEmail() == email).findFirst().orElse(null);
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
