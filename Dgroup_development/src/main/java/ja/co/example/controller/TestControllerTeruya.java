package ja.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllerTeruya {

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

	//全体ランキング遷移
		@RequestMapping("/personalRanking")
	    public String personalRanking(Model model) {
	        return "personalRanking";
	    }

	//ログイン画面へ
		@RequestMapping("/login")
	    public String login(Model model) {
	        return "login";
	    }

}
