

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import util.Utility;


/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productIdStr = request.getParameter("product_id");




		if(Utility.isNullOrEmpty(productIdStr)) {
			request.setAttribute("msg","product_idを入力して下さい");
			request.getRequestDispatcher("top.jsp").forward(request, response);
			return;

		}

		ProductService productService = new ProductService();
		Integer productId = Utility.checkAndParseInt(productIdStr);

		Product product = productService.find(productId);

		if (product != null) {
			request.setAttribute("productList", product);

			request.setAttribute("msg","データを取得しました");
			request.getRequestDispatcher("searchResult.jsp").forward(request, response);

		}else {
			request.setAttribute("msg", "対象のデータはありません");
			request.getRequestDispatcher("top.jsp").forward(request, response);
			return;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
