package ja.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ja.co.example.dao.UsersDao;
import ja.co.example.entity.Users;
import ja.co.example.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public Users authentication(String loginId, String pass) {
		return usersDao.findByLoginIdAndPassword(loginId, pass);

	}

}
