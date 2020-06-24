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

import ja.co.example.dao.UsersDao;
import ja.co.example.entity.Account;
import ja.co.example.entity.Users;
import ja.co.example.form.AccountForm;
import ja.co.example.form.AccounteditForm;
import ja.co.example.form.CheckForm;
import ja.co.example.service.AccountService;
import ja.co.example.service.AccounteditService;

@Controller
public class AccounteditController {

	@Autowired
	HttpSession session;

	@Autowired
	private AccounteditService AccounteditService;

	@Autowired
	private AccountService accountservice;

	@Autowired
	private UsersDao userDao;



	//トップ画面へ
	@RequestMapping("/top")
	public String index(@ModelAttribute("user") AccounteditForm form, Model model) {
		return "account_edit";
	}

	//新規登録画面へ
	@RequestMapping("/insert")
	public String account(@ModelAttribute("user") AccountForm form, Model model) {
		return "account";
	}

	//情報変更
	@RequestMapping(value = "/accounteditA", method = RequestMethod.POST)
	public String result(@Validated @ModelAttribute("user") AccounteditForm form, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "account_edit";
		}

		session.setAttribute("name", form.getUserName());
		session.setAttribute("pass", form.getPass());
		session.setAttribute("flg", 1);

		return "check";

	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("user") AccountForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "account";
		}

		String id = form.getLoginId();
		String pass = form.getPass();
		String name = form.getUserName();
		session.setAttribute("name", name);
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);
		Account select = accountservice.select(id);
		if (select == null) {
			return "check";
		} else {

			model.addAttribute("massage", "IDが重複しています");

			return "account";
		}
	}

	//情報変更
	@RequestMapping(value = "/checkA", params = "update", method = RequestMethod.POST)
	public String result1(@Validated @ModelAttribute("user") CheckForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "check";
		}

		String old = (String) session.getAttribute("pass");

		String name = form.getUserName();
		System.out.println(form.getUserName());
		String pass = form.getPass();
		if (old.equals(pass)) {

			Users A = (Users) session.getAttribute("user");

			String logid = A.getLoginId();

			AccounteditService.update(name, pass, logid);
			Users user = userDao.findByLoginIdAndPassword(A.getLoginId(), A.getPass());
			session.setAttribute("user", user);

			model.addAttribute("msg", "変更に成功しました。");
//			session.invalidate();
			return "result";

		} else {
			model.addAttribute("msg", "パスワードが間違えています。");

			return "check";
		}
	}

	//情報変更
	@RequestMapping(value = "/checkA", params = "insert", method = RequestMethod.POST)
	public String result2(@Validated @ModelAttribute("user") CheckForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "check";
		}

		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		String pass = (String) session.getAttribute("pass");
		String pass1 = form.getPass();

		if (pass.equals(pass1)) {

			accountservice.insert(id, pass, name);
			return "result";
		} else {
			model.addAttribute("msg", "パスワードが間違えています");
			return "check";
		}
	}

}
