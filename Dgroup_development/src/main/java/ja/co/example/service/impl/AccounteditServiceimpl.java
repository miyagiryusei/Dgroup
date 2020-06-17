package ja.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ja.co.example.dao.AccounteditDao;
import ja.co.example.service.AccounteditService;

@Service
@Transactional
public class AccounteditServiceimpl implements AccounteditService{

	@Autowired
	private AccounteditDao accounteditDao;

	@Override
	public int  update(String name, String pass,String logid) {
		return accounteditDao.update(name, pass, logid);
	}

}
