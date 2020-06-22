package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.Itemlist;

public interface ItemDao {

	public List<Itemlist> itemlist(Integer id);

}
