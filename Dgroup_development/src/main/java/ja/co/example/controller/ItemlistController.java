package ja.co.example.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ja.co.example.dao.ItemDao;
import ja.co.example.dao.UsersDao;
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

	@Autowired
	ItemDao itemDao;

	@Autowired
	UsersDao userDao;




//	//アイテムリスト画面へ
//	@RequestMapping("/itemlist")
//	public String itemlist(Model model) {
//		return "itemlist";
//	}

	@RequestMapping("/itemList")
	public String result1(@ModelAttribute("use") ItemlistForm form,Model model) {
		//所持アイテムの表示
		Users user=(Users) session.getAttribute("user");

		Integer userid =user.getUserId();



		List<Itemlist> list=itemservice.Itemlist(userid);
		if(list ==null) {
			model.addAttribute("msg","所持アイテムはありません");

		}

		Users u = userDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());
		System.out.println(u.getUserName());
		session.setAttribute("user", u);
		session.setAttribute("list",list);
			return "itemlist";
	}


	@RequestMapping("/itemuse")
	public String result(@ModelAttribute("use") ItemlistForm form,Model model) {
		Integer itemid=form.getItemId();
		Users user=(Users) session.getAttribute("user");
		Integer userid = user.getUserId();



		if(itemid==1) {
			//ランダム生成
			Random random = new Random();
			Integer itemcoin;
			int rate =random.nextInt(10);

			if(rate<=8) {
				itemcoin = random.nextInt(10000);
				//生成値の保存

			}else {

				itemcoin = random.nextInt(90000)+10000;
			}
			//生成値の保存
			model.addAttribute("itemcoin",itemcoin);



			itemservice.Goddess(itemid, userid,itemcoin, user);
		}
		List<Itemlist> list=itemservice.Itemlist(userid);



		if (list.get(0).getItemCount() == 0) {
			itemDao.itemListDelete(userid,itemid);
			model.addAttribute("msg","所持アイテムはありません");
		}

		userDao.rank(user.getUserId());
		session.setAttribute("list",list);
		Users u = userDao.findByLoginIdAndPassword(user.getLoginId(), user.getPass());
		session.setAttribute("user", u);




		return "itemlist";

	}
	}




