package ja.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.dao.ItemShopDao;
import ja.co.example.dao.UsersDao;
import ja.co.example.entity.ItemShop;
import ja.co.example.entity.Users;
import ja.co.example.form.LoginForm;

@Controller
public class TestControllerTeruya {

//	//ランキング画面表示
//	@RequestMapping("/ranking")
//	public String ranking(Model model) {
//		return "ranking";
//	}
//
//	//全体ランキング遷移
//	@RequestMapping("/overallRanking")
//	public String overallRanking(Model model) {
//		return "overallRanking";
//	}
//
//	//全体ランキング遷移
//	@RequestMapping("/personalRanking")
//	public String personalRanking(Model model) {
//		return "personalRanking";
//	}

	@Autowired
	HttpSession session;

	@Autowired
	UsersDao userDao;

	@Autowired
	ItemShopDao itemShopDao;


	//ログイン画面へ
	@RequestMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		return "login";
	}

	//ルール
		@RequestMapping("/pokerRule")
		public String pokerRole(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
			if(session.getAttribute("user")==null) {
				return "forward:login";
			}
			return "pokerRule";
		}

	//完了画面へ
	@RequestMapping("/result")
	public String result(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		if(session.getAttribute("user")==null) {
			return "forward:login";
		}
		return "result";
	}

	//Myページ画面表示
	@RequestMapping("/myPage")
	public String myPage(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "login";
		}

		Integer userCoin = user.getCoin();
		if(userCoin < 1) {
			userDao.rankFailed(user.getUserId());
			ItemShop itemShop = itemShopDao.selectItem(user.getUserId(), 100);
			if (itemShop == null) {
			itemShopDao.insert(user.getUserId(), 100, 1);
			}
			user = userDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());
			session.setAttribute("user", user);
			return "myPage";
		}
		return "myPage";
	}

	//ポーカー画面
//	@RequestMapping("/poker")
//	public String poker(Model model) {
//		return "poker";
//	}

	//ブラックジャック画面
	@RequestMapping("/blackjack")
	public String blackjack(Model model) {
		return "blackjack";
	}


	//ログアウト画面
	@RequestMapping("/logout")
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}



	//購入確認画面
	@RequestMapping("/byResult")
	public String byResult(Model model) {
		if(session.getAttribute("user")==null) {
			return "forward:login";
		}
		return "byResult";
	}

	//アカウント編集確認画面へ
	@RequestMapping("/account_edit")
	public String account_edit(Model model) {
		if(session.getAttribute("user")==null) {
			return "forward:login";
		}
		return "account_edit";
	}

	//アカウント編集確認画面へ
	@RequestMapping("/insert")
	public String account(Model model) {

		return "account";
	}

//	//アイテムリスト画面へ
//	@RequestMapping("/itemlist")
//	public String itemlist(Model model) {
//		return "itemlist";
//	}

}
