package ja.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ja.co.example.dao.GameResultDao;
import ja.co.example.dao.ItemShopDao;
import ja.co.example.dao.UsersDao;
import ja.co.example.entity.ItemShop;
import ja.co.example.entity.Users;
import ja.co.example.form.ItemShopForm;
import ja.co.example.service.AccountService;
import ja.co.example.service.AccounteditService;

@Controller
public class ItemShopController {

	@Autowired
	HttpSession session;

	@Autowired
	private AccounteditService AccounteditService;
	@Autowired
	private ItemShopDao itemShopDao;
	@Autowired
	private GameResultDao gameResultDao;

	@Autowired
	private UsersDao userDao;

	@Autowired
	private AccountService accountservice;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String result(@Validated @ModelAttribute("itemShopForm") ItemShopForm form, BindingResult bindingResult,
			Model model) {
		List<ItemShop> i = new ArrayList<ItemShop>();

		i = itemShopDao.select();
		for (ItemShop item : i) {
			System.out.println(item.getItemId());
			System.out.println(item.getName());
		}
		model.addAttribute("item", i);

		return "item";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String insert(@Validated @ModelAttribute("itemShopForm") ItemShopForm form, BindingResult bindingResult,
			Model model) {
		Users u = (Users) session.getAttribute("user");
		form.getItemId();
		List<ItemShop> i = new ArrayList<ItemShop>();
		for (Integer itemId : form.getItemId()) {

			ItemShop it = itemShopDao.selectPrice(itemId);
			itemShopDao.insert(u.getUserId(), itemId, 1);
			itemShopDao.buyResult(u.getUserId(), it.getPrice(), 3);
			gameResultDao.userGetCoin(u);

		}

		u = userDao.findByLoginIdAndPassword(u.getLoginId(), u.getPass());
		session.setAttribute("user", u);

		return "byResult";

	}

}
