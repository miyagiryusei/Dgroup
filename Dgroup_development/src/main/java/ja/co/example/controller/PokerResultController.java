package ja.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/poker")
	public String pokerGame(@ModelAttribute("gameForm") GameForm form, Model model) {
		List<Integer> coin = new ArrayList<Integer>();
		Integer i;
		for (i = 1; i <= 100; i++) {
			coin.add(i);
		}
		session.setAttribute("betCoin", coin);
		return "poker";
	}

	//ポーカー終了時
	@RequestMapping(value = "/pokerResult", method = RequestMethod.GET)
	@ResponseBody
	public Users gameResult(@Validated HttpServletRequest request, Model model) {

		String betmany = request.getParameter("betmaney");
		Integer betMoney = Integer.parseInt(betmany);
		String hands = request.getParameter("hands");
		Integer handscnt = 0;

		System.out.println(betmany);
		System.out.println(hands);

		switch (hands) {
		case "ノーペア":
			handscnt = 1;
			break;
		case "ワンペア":
			handscnt = 2;
			break;
		case "ツーペア":
			handscnt = 3;
			break;
		case "スリーカード":
			handscnt = 4;
			break;
		case "Straight":
			handscnt = 5;
			break;
		case "Flash":
			handscnt = 6;
			break;
		case "FullHouse":
			handscnt = 7;
			break;
		case "FourCard":
			handscnt = 8;
			break;
		case "StraightFlash":
			handscnt = 9;
			break;
		case "RoyalStraightFlash":
			handscnt = 10;
			break;
		case "FiveCard":
			handscnt = 11;
			break;
		}
		System.out.println(handscnt);

		Users user = (Users) session.getAttribute("user");

		//resultインスタンス作成
		Ranking result = new Ranking(user.getUserId(), null, 1,handscnt );

		//所持コインからベットコインマイナス
		//gameResultDao.userBetCoin(form.getBetCoin(),user.getUserId());

		//ゲーム結果入力
		gameResultDao.pokerResultInsert(result,betMoney);

		//獲得コインをDBから取得
		gameResultDao.userGetCoin(user);
		Ranking re = gameResultDao.getCoin(user.getUserId());

		//ユーザーのランク更新
		usersDao.rank(user.getUserId());
		user = usersDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());

		System.out.println(user.getRankName());

		//ポーカーの役取得
		Ranking po = gameResultDao.pokerRoleName(handscnt);

		model.addAttribute("getCoin", re.getCoin());
		model.addAttribute("pokerResult", po.getPokerRoleName());
		session.setAttribute("user", user);



		return user;

	}

}
