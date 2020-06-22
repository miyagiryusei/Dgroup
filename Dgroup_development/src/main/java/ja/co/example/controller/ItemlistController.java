package ja.co.example.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.entity.Itemlist;
import ja.co.example.entity.Users;
import ja.co.example.form.ItemlistForm;
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
	public String result1(@ModelAttribute("user") ItemlistForm form,Model model) {
		//所持アイテムの表示
		Users user=(Users) session.getAttribute("user");

		Integer userid =user.getUserId();


		List<Itemlist> list=itemservice.Itemlist(userid);
		if(list ==null) {
			model.addAttribute("msg","所持アイテムはありません");

		}


		session.setAttribute("list",list);
			return "itemlist";
	}


	@RequestMapping("/itemuse")
	public String result(@ModelAttribute("user") ItemlistForm form,Model model) {
		Integer itemid=form.getItemId();
		Users user=(Users) session.getAttribute("user");
		Integer userid = user.getUserId();



		if(itemid==1) {
			//ランダム生成
			Random random = new Random();
			Integer itemcoin = random.nextInt(100);
			//生成値の保存
			model.addAttribute("itemcoin",itemcoin);



			itemservice.Goddess(itemid, userid,itemcoin, user);
		}
		List<Itemlist> list=itemservice.Itemlist(userid);

		session.setAttribute("list",list);



		return "itemlist";

	}
	}




