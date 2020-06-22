package ja.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.entity.Itemlist;
import ja.co.example.entity.Users;
import ja.co.example.service.ItemService;

@Controller
public class ItemlistController {
	@Autowired
	HttpSession session;
	@Autowired
	ItemService itemservice;



//	//アイテムリスト画面へ
//	@RequestMapping("/itemlist")
//	public String itemlist(Model model) {
//		return "itemlist";
//	}

	@RequestMapping("/itemList")
	public String result1(Model model) {

		Users user=(Users) session.getAttribute("user");

		Integer userid =user.getUserId();


		List<Itemlist> list=itemservice.Itemlist(userid);
		if(list ==null) {
			model.addAttribute("msg","所持アイテムはありません");

		}


		session.setAttribute("list",list);






			return "itemlist";

		}
	}

