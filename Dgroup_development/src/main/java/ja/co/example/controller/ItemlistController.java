package ja.co.example.controller;

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
public class ItemlistController {


//	//アイテムリスト画面へ
//	@RequestMapping("/itemlist")
//	public String itemlist(Model model) {
//		return "itemlist";
//	}

	@RequestMapping(value = "/itemlistA",params = "update", method = RequestMethod.POST)
	public String result1(@Validated @ModelAttribute("user") AccounteditForm form, BindingResult bindingResult,
			Model model) {



			return "check";
		}
	}

