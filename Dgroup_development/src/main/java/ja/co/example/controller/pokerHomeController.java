package ja.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.form.LoginForm;

@Controller
public class pokerHomeController {

	@Autowired
	HttpSession session;

	@RequestMapping("/pokerHome")
	public String pokerRole(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		return "pokerHome";
	}
}
