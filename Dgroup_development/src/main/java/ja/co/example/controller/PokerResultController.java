package ja.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ja.co.example.dao.GameResultDao;
import ja.co.example.dao.UsersDao;
import ja.co.example.entity.Ranking;
import ja.co.example.entity.Users;
import ja.co.example.form.GameForm;

@Controller
public class PokerResultController {
	@Autowired
	HttpSession session;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private GameResultDao gameResultDao;

	@Autowired
	private UsersDao usersDao;

	@RequestMapping("/pokerGame")
	public String pokerGame(@ModelAttribute("gameForm") GameForm form, Model model) {
		List<Integer> coin = new ArrayList<Integer>();
		Integer i;
		for (i = 1; i <= 100; i++) {
			coin.add(i);
		}
		session.setAttribute("betCoin", coin);
		return "pokerGame";
	}

	//ポーカー終了時
	@RequestMapping(value = "/pokerResult", method = RequestMethod.POST)
	public String gameResult(@Validated @ModelAttribute("gameForm") GameForm form, BindingResult bindingResult,
			Model model) {

		double d;
		Integer pokerRole;
		d = (int) (Math.random() * 100);
		if (d == 1) {
			pokerRole = 11;

		} else if (d >= 2 && d <= 5) {
			pokerRole = 10;

		} else if (d >= 6 && d <= 10) {
			pokerRole = 9;

		} else if (d >= 11 && d <= 16) {
			pokerRole = 8;

		} else if (d >= 17 && d <= 23) {
			pokerRole = 7;

		} else if (d >= 24 && d <= 31) {
			pokerRole = 6;

		} else if (d >= 32 && d <= 40) {
			pokerRole = 5;

		} else if (d >= 41 && d <= 61) {
			pokerRole = 4;

		} else if (d >= 62 && d <= 70) {
			pokerRole = 3;

		} else if (d >= 71 && d <= 85) {
			pokerRole = 2;

		} else {
			pokerRole = 1;

		}

		Users user = (Users) session.getAttribute("user");

		//resultインスタンス作成
		Ranking result = new Ranking(user.getUserId(), null, 1, pokerRole);

		//所持コインからベットコインマイナス
		//gameResultDao.userBetCoin(form.getBetCoin(),user.getUserId());


		//ゲーム結果入力
		gameResultDao.pokerResultInsert(result, form.getBetCoin());

		//獲得コインをDBから取得
		gameResultDao.userGetCoin(user);
		Ranking re = gameResultDao.getCoin(user.getUserId());

		//ユーザーのランク更新
		usersDao.rank(user.getUserId());
		user = usersDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());

		//ポーカーの役取得
		Ranking po = gameResultDao.pokerRoleName(pokerRole);

		model.addAttribute("getCoin", re.getCoin());
		model.addAttribute("pokerResult", po.getPokerRoleName());
		session.setAttribute("user", user);

		return "pokerResult";

	}

}
