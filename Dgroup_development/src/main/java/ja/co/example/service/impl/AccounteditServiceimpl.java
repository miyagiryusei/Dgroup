package ja.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.co.example.dao.AccounteditDao;

@Service
public class AccounteditServiceimpl implements AccounteditDao{

	@Autowired
	private AccounteditDao AccounteditDao;

	public int  update(String loginid, String pass) {
		return AccounteditDao.update(loginid, pass);
	}

}
