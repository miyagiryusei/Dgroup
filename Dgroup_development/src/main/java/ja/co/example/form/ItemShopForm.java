package ja.co.example.form;

import java.util.List;

import ja.co.example.entity.ItemShop;

public class ItemShopForm {

	private List<Integer> itemId;
	private List<ItemShop> item;

	public List<Integer> getItemId() {
		return itemId;
	}

	public void setItemId(List<Integer> itemId) {
		this.itemId = itemId;
	}

	public List<ItemShop> getItem() {
		return item;
	}

	public void setItem(List<ItemShop> item) {
		this.item = item;
	}



}
