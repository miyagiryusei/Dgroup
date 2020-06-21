package ja.co.example.entity;

public class ItemShop {

	//userテーブル
	private Integer userId;
	private String userName;
	private Integer coin;

	//itemテーブル
	private Integer itemId;
	private Integer typeName;
	private String name;
	private Integer price;
	private String effect;
	private Integer deathblowCost;
	private Integer divissionId;

	//item_listテーブル
	private Integer item_count;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getTypeName() {
		return typeName;
	}
	public void setTypeName(Integer typeName) {
		this.typeName = typeName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Integer getDeathblowCost() {
		return deathblowCost;
	}
	public void setDeathblowCost(Integer deathblowCost) {
		this.deathblowCost = deathblowCost;
	}

	public Integer getDivissionId() {
		return divissionId;
	}
	public void setDivissionId(Integer divissionId) {
		this.divissionId = divissionId;
	}
	public Integer getItem_count() {
		return item_count;
	}
	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}

}
