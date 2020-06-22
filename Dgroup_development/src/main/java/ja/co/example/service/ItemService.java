package ja.co.example.service;

import java.util.List;

import ja.co.example.entity.Itemlist;
import ja.co.example.entity.Users;

public interface ItemService {

	public List<Itemlist> Itemlist(Integer id);

	public Integer Goddess(Integer id, Integer userid, Integer itemcoin, Users user);

}
