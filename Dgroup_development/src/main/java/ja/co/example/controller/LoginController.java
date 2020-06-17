package ja.co.example.controller;

import java.util.Locale;

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

import ja.co.example.entity.Users;
import ja.co.example.form.LoginForm;
import ja.co.example.service.UsersService;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
			Model model) {

		String errMsg = messageSource.getMessage("login.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			return "login";
		}

		Users user = usersService.authentication(form.getLoginId(), form.getPassword());

		if (user == null) {
			model.addAttribute("errMsg", errMsg);
			return "login";
		} else {

			session.setAttribute("user", user);

			return "myPage";
		}
	}

}
