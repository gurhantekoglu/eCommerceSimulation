package eCommerceSimulation.dataAccess.abstracts;

import java.util.List;

import eCommerceSimulation.entities.concretes.User;

public interface UserDao {
	void add(User user);

	void update(User user);

	void delete(int userId);

	User get(String email);

	List<User> getAll();
}
