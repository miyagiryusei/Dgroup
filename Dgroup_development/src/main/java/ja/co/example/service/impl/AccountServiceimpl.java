package ja.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.co.example.dao.AccountDao;
import ja.co.example.entity.Account;
import ja.co.example.service.AccountService;

@Service
public class AccountServiceimpl implements AccountService{

	@Autowired
	private AccountDao accountdao;
	public Account insert(String id,String pass, String name) {
		return accountdao.insert(id ,pass, name);
	}


		public Account select(String id) {
			return accountdao.select(id);
	}
}
