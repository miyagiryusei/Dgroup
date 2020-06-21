package ja.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.entity.Ranking;
import ja.co.example.entity.Users;
import ja.co.example.form.LoginForm;
import ja.co.example.service.RankingService;

@Controller
public class RankingController {

	@Autowired
	HttpSession session;

	@Autowired
	RankingService rankingService;

	//ランキング画面表示
	@RequestMapping("/ranking")
	public String ranking(Model model) {
		return "ranking";
	}

	//全体ランキング遷移
	@RequestMapping("/overallRanking")
	public String overallRanking(Model model) {
		return "overallRanking";
	}

	//個人ランキング遷移
	@RequestMapping("/personalRanking")
	public String personalRanking(@ModelAttribute("loginForm") LoginForm form, Model model) {

		Users user = (Users) session.getAttribute("user");

		if (user == null) {
			return "login";
		}

		String userName = user.getUserName();

		List<Ranking> resultList = rankingService.getPersonalBjSum(userName);
		session.setAttribute("bjSumList", resultList);

		resultList = rankingService.getPersonalPokerOneTimeMaxScore(userName);
		session.setAttribute("pokerOneTimeList", resultList);

		resultList = rankingService.getPersonalPokerRoleCount(userName);
		session.setAttribute("pokerRoleCountList", resultList);

		resultList = rankingService.getPersonalPokerRoleRanking(userName);
		session.setAttribute("pokerRoleRankingList", resultList);

		resultList = rankingService.getPersonalPokerSum(userName);
		session.setAttribute("pokerSumList", resultList);

		resultList = rankingService.getPersonalRanking(userName);
		session.setAttribute("pokerRanking", resultList);

		return "personalRanking";
	}

}
