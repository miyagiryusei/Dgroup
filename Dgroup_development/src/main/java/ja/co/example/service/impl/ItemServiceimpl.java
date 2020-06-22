package ja.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.co.example.dao.ItemDao;
import ja.co.example.entity.Itemlist;
import ja.co.example.service.ItemService;

@Service
public class ItemServiceimpl implements ItemService{

	@Autowired
	private ItemDao itemDao;


	public List<Itemlist> Itemlist(Integer id) {
		return itemDao.itemlist(id);

	}
}
