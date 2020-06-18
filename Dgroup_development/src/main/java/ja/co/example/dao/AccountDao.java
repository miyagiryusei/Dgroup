package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.Account;

public interface AccountDao {

	public List<Account> findAll();
	public Account select(String id );
	public Account insert(String id ,String pass, String name);

}
