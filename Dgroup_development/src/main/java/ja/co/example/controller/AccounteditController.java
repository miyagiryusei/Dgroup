package ja.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ja.co.example.entity.Users;
import ja.co.example.form.AccounteditForm;
import ja.co.example.service.AccounteditService;

@Controller
public class AccounteditController {

	@Autowired
	HttpSession session;

	@Autowired
	private AccounteditService AccounteditService;

	//トップ画面へ
	@RequestMapping("/top")
	public String index(@ModelAttribute("user") AccounteditForm form, Model model) {
		return "account_edit";
	}

	//情報変更
	@RequestMapping(value = "/accounteditA", method = RequestMethod.POST)
	public String result(@Validated @ModelAttribute("user") AccounteditForm form, BindingResult bindingResult,
			Model model) {
		session.setAttribute("name", form.getLoginName());
		session.setAttribute("pass", form.getPass());

		return "check";

	}

	//情報変更
	@RequestMapping(value = "/checkA",params = "update", method = RequestMethod.POST)
	public String result1(@Validated @ModelAttribute("user") AccounteditForm form, BindingResult bindingResult,
			Model model) {

		String old = (String) session.getAttribute("pass");

		String name = form.getLoginName();
		String pass = form.getPass();
		if (old.equals(pass)) {


			Users A = (Users) session.getAttribute("user");

			String logid = A.getLoginId();

			AccounteditService.update(name, pass, logid);

			model.addAttribute("msg", "変更に成功しました。");
			session.invalidate();
			return "result";

		} else {
			model.addAttribute("msg", "パスワードが間違えています。");

			return "check";
		}
	}
	//情報変更
		@RequestMapping(value = "/checkA",params = "insert", method = RequestMethod.POST)
		public String result2(@Validated @ModelAttribute("user") AccounteditForm form, BindingResult bindingResult,
				Model model) {
					return null;

		}


}
