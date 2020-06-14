package ja.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllerTaiga {

	//Myページ画面表示
    @RequestMapping("/item")
	public String item(Model model) {
	    return "item";
	}

    @RequestMapping("/itemShop")
	public String itemShop(Model model) {
	    return "itemShop";
	}

    @RequestMapping("/itemList")
	public String itemList(Model model) {
	    return "itemList";
	}


}
