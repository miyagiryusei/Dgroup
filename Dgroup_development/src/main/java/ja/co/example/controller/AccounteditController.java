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

import ja.co.example.entity.Accountedit;
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
			return "accountedit";
		}


	//情報変更
		@RequestMapping(value = "/accounteditA", method = RequestMethod.POST)
		public String result4(@Validated @ModelAttribute("user")Accountedit form, BindingResult bindingResult,Model model) {
			if (bindingResult.hasErrors()) {
				return "accountedit";
			}
			String id = form.getLoginId();
			String pass = form.getPass();


			Integer a = AccounteditService.update(id, pass);
			if (a == 1) {
				model.addAttribute("msg1", "変更に成功しました。");
				session.invalidate();
				return "updateResult";
			} else if (a == 0) {
				model.addAttribute("msg", "パスワードが間違えています。");
				return "update";

			} else {
				model.addAttribute("msg", "すでに使用されているユーザーidです。");
				return "update";

			}
		}
}
