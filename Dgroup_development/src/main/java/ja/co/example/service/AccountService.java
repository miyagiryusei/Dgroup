package ja.co.example.service;

import ja.co.example.entity.Account;

public interface AccountService {

	public Account insert(String id,String pass, String name);

	public Account select(String id);
}
