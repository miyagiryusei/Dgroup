package ja.co.example.dao;

import ja.co.example.entity.Users;

public interface UsersDao {

	public Users findByLoginIdAndPassword(String loginId, String password);

}
