package ja.co.example.form;

import javax.validation.constraints.NotNull;

public class ItemlistForm {

	@NotNull
	private Integer itemId;

	private String userName;

	private Integer coin;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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


}
