package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.Itemlist;
import ja.co.example.entity.Users;

public interface ItemDao {

	public List<Itemlist> itemlist(Integer id);

	public Integer Goddess(Integer id, Integer userid, Integer itemcoin,Users user);

	public void itemListDelete(Integer userId,Integer itemId);

	public void backgroundChange(Integer userId , Integer backgroundId , Integer itemId);

}
