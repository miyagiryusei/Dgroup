package ja.co.example.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.dao.ItemDao;
import ja.co.example.dao.UsersDao;
import ja.co.example.entity.Itemlist;
import ja.co.example.entity.Users;
import ja.co.example.form.ItemlistForm;
import ja.co.example.service.ItemService;

@Controller
public class ItemlistController {
	@Autowired
	HttpSession session;
	@Autowired
	ItemService itemservice;

	@Autowired
	ItemDao itemDao;

	@Autowired
	UsersDao userDao;

	//	//アイテムリスト画面へ
	//	@RequestMapping("/itemlist")
	//	public String itemlist(Model model) {
	//		return "itemlist";
	//	}

	@RequestMapping("/itemList")
	public String result1(@ModelAttribute("use") ItemlistForm form, Model model) {
		//所持アイテムの表示
		Users user = (Users) session.getAttribute("user");

		Integer userid = user.getUserId();

		List<Itemlist> list = itemservice.Itemlist(userid);

		if (list == null) {
			model.addAttribute("msg", "所持アイテムはありません");

		}

		Users u = userDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());
		session.setAttribute("user", u);
		session.setAttribute("list", list);
		return "itemlist";
	}

	@RequestMapping("/itemuse")
	public String result(@Validated @ModelAttribute("use") ItemlistForm form, BindingResult bindingResult,
			Model model) {
		Integer itemid = form.getItemId();
		Users user = (Users) session.getAttribute("user");
		Integer userid = user.getUserId();
		List<Itemlist> list = itemservice.Itemlist(userid);
		Random random = new Random();
		Integer itemcoin;

		if (bindingResult.hasErrors()) {
			model.addAttribute("msgg", "アイテムを選択してください");
			return "forward:itemList";
		}

		if (list == null) {
			model.addAttribute("msg", "所持アイテムはありません");
		}

		if (itemid == 1) {
			//ランダム生成
			int rate = random.nextInt(10);

			if (rate <= 8) {
				itemcoin = random.nextInt(10000);
				//生成値の保存

			} else {

				itemcoin = random.nextInt(90000) + 10000;
			}
			//生成値の保存
			model.addAttribute("itemcoin", itemcoin);

			itemservice.Goddess(itemid, userid, itemcoin, user);
			userDao.rank(user.getUserId());

		}
		if (itemid == 2) {
			int rate = random.nextInt(100);

			if (rate <= 94) {
				itemcoin = random.nextInt(10000);

			} else {
				itemcoin = random.nextInt(9000000) + 1000000;

			}
			model.addAttribute("itemcoin", itemcoin);

			itemservice.Goddess(itemid, userid, itemcoin, user);
			userDao.rank(user.getUserId());

		}
		if (itemid == 3) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, 1 , 3);
		}

		if (itemid == 4) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, 2 , 4);
		}

		if (itemid == 5) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, 3 , 5);
		}

		if (itemid == 6) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, 4 , 6);
		}

		if (itemid == 7) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, 5 , 7);
		}

		if (itemid == 8) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, null , 8);
		}

		if (itemid == 9) {
			model.addAttribute("background" , "背景を変更しました");

			itemservice.backgroundChange(userid, 6 , 9);
		}

		list = itemservice.Itemlist(userid);

		if (list.get(0).getItemCount() == 0) {
			itemDao.itemListDelete(userid, itemid);
		}

		list = itemservice.Itemlist(userid);

		if (list == null) {
			model.addAttribute("msg", "所持アイテムはありません");
		}

//		userDao.rank(user.getUserId());
		session.setAttribute("list", list);
		Users u = userDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());
		session.setAttribute("user", u);

		return "itemlist";

	}
}
