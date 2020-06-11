package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.ProductForm;
import jp.co.example.entity.Product;
import jp.co.example.service.ProductService;
import jp.co.example.util.ParamUtil;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	//トップ画面へ
	@RequestMapping("/top")
	public String index(@ModelAttribute("search") ProductForm form, Model model) {
		return "top";
	}

	//結果画面へ
	 @RequestMapping(value = "/searchR", /*params = "param1",*/ method = RequestMethod.POST)
	    public String result1(@ModelAttribute("search") ProductForm form, Model model) {
		 String id = form.getId();
		 Integer idInteger = ParamUtil.checkAndParseInt(id);
		 Product product = productService.findById(idInteger);

		 if(product != null) {

		 	model.addAttribute("msg", "データを取得しました");
		 	model.addAttribute("result","<br>product_id:" + product.getProductId() + "<br>product_name:"+ product.getProductName() + "<br>price" + product.getPrice());
	        return "searchResult";
		 }else {
			model.addAttribute("msg", "対象のデータはありません");
			return "top";
		 }
	    }

}


//if (ParamUtil.isNumber(id)) {
//
//	Integer idInteger = ParamUtil.checkAndParseInt(id);
//	ProductService productService = new ProductService();
//	Product product = productService.authentication(idInteger);
//
//	if (product != null) {
//		// メッセージ設定
//		request.setAttribute("msg", "データを取得しました");
//		request.setAttribute("result", "<br>product_id:" + product.getProductId() + "<br>product_name:"
//				+ product.getProductName() + "<br>price" + product.getPrice());
//
//		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
//	} else {
//		// メッセージ設定
//		request.setAttribute("msg", "対象のデータはありません");
//
//		// 次画面指定
//		request.getRequestDispatcher("top.jsp").forward(request, response);
//	}