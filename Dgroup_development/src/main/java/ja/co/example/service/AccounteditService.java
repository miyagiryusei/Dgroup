package ja.co.example.service;

import org.springframework.stereotype.Service;

@Service
public interface AccounteditService {

	public int  update(String loginid, String pass);

}