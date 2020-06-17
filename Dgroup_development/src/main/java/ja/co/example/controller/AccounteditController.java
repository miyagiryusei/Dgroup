package ja.co.example.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.form.updateForm;

public class AccounteditController {

	//情報変更
		@RequestMapping(value = "/updateA", method = RequestMethod.POST)
		public String result4(@Validated @ModelAttribute("user") updateForm form, BindingResult bindingResult,Model model) {
			if (bindingResult.hasErrors()) {
				return "update";
			}
			String newname = form.getNewuser();
			String oldpass = form.getOldpass();
			String newpass = form.getNewpass();

			Integer a = managementService.update(newname, oldpass, newpass);
			if (a == 1) {
				model.addAttribute("msg1", "変更に成功しました。");
				session.invalidate();
				return "updateResult";
			} else if (a == 0) {
				model.addAttribute("msg", "パスワードが間違えています。");
				return "update";

			} else {
				model.addAttribute("msg", "すでに使用されているユーザ名です。");
				return "update";

			}
		}
}
