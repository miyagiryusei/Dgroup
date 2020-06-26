package ja.co.example.dao;

import ja.co.example.entity.Users;

public interface UsersDao {

	public Users findByLoginIdAndPassword(String loginId, String password);

	public void  rank(Integer userId);

	public void rankFailed(Integer userId);

	public void coinUpdateItem(Integer userId,Integer itemId);

}
