package ja.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.dao.UsersDao;
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


	//ログイン画面へ
	@RequestMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		return "login";
	}

	//完了画面へ
	@RequestMapping("/result")
	public String result(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		return "result";
	}

	//Myページ画面表示
	@RequestMapping("/myPage")
	public String myPage(Model model) {
//		Users user = (Users) session.getAttribute("user");
//		Users u = userDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());
//		session.setAttribute("user", u);
		return "myPage";
	}

	//ポーカー画面
	@RequestMapping("/poker")
	public String poker(Model model) {
		return "poker";
	}

	//ブラックジャック画面
	@RequestMapping("/blackjack")
	public String blackjack(Model model) {
		return "blackjack";
	}

	//確認画面へ
	@RequestMapping("/check")
	public String check(@ModelAttribute("checkForm") LoginForm loginForm, Model model) {
		return "check";
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
		return "byResult";
	}

	//アカウント編集確認画面へ
	@RequestMapping("/account_edit")
	public String account_edit(Model model) {
		return "account_edit";
	}

	//アカウント編集確認画面へ
	@RequestMapping("/account")
	public String account(Model model) {
		return "account";
	}

//	//アイテムリスト画面へ
//	@RequestMapping("/itemlist")
//	public String itemlist(Model model) {
//		return "itemlist";
//	}

}
