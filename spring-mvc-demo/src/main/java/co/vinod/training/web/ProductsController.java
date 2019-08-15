package co.vinod.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.vinod.training.dao.DaoException;
import co.vinod.training.dao.ProductDao;

@Controller
public class ProductsController {

	@Autowired
	ProductDao dao;

//	@RequestMapping("/get-all-products")
//	public ModelAndView getAllProducts() throws DaoException {
//		List<Product> list = dao.getAllProducts();
//		return new ModelAndView("/WEB-INF/pages/display-products.jsp", "products", list);
//	}

	@RequestMapping("/get-all-products")
	public String getAllProducts(Model model) throws DaoException {
		// the parameter "model" is a container to collect the model data
		// from here. These model data are made available to the view by spring.
		model.addAttribute("products", dao.getAllProducts());
		return "display-products";
	}

	@GetMapping("/get-discontinued-products")
	public String getDiscontinuedProducts(Model model) throws DaoException {
		model.addAttribute("products", dao.getDiscontinuedProducts());
		return "display-products";
	}

	@GetMapping("/get-out-of-stock-products")
	public String getOutOfStockProducts(Model model) throws DaoException {
		model.addAttribute("products", dao.getOutOfStockProducts());
		return "display-products";
	}
}
