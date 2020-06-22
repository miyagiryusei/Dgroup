package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.ItemShop;

public interface ItemShopDao {

	public List<ItemShop> select();

	public ItemShop selectPrice(Integer itemId);

	public ItemShop insert(Integer id, Integer itemId, Integer itemCount);

	public void buyResult(Integer user_id, Integer coin, Integer division_id);

	public void update(Integer user_id, Integer item_id);

	public ItemShop selectItem (Integer user_id, Integer item_id);
}
