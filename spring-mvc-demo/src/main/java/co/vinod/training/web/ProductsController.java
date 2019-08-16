package co.vinod.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.vinod.training.dao.DaoException;
import co.vinod.training.dao.ProductDao;
import co.vinod.training.entity.Product;

@Controller
public class ProductsController {

	@Autowired
	ProductDao dao;

//	@RequestMapping("/get-all-products")
//	public ModelAndView getAllProducts() throws DaoException {
//		List<Product> list = dao.getAllProducts();
//		return new ModelAndView("/WEB-INF/pages/display-products.jsp", "products", list);
//	}
	
	
	@RequestMapping(path = "/add-product", method=RequestMethod.GET)
	public String addNewProduct(Model model) {
		model.addAttribute("pr", new Product());
		model.addAttribute("title", "Add new product details");
		return "product-form";
	}

	@RequestMapping(path="/edit-product", method=RequestMethod.GET)
	public String editProduct(@RequestParam Integer id, Model model) throws DaoException{
		model.addAttribute("pr", dao.getProductById(id));
		model.addAttribute("title", "Update product details");
		return "product-form";
	}
	
	@RequestMapping(path = "/add-or-update-product", method=RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("pr") Product product, BindingResult errors) throws DaoException {
		
		if(errors.hasErrors()) {
			return "product-form";	
		}

		if (product.getProductId() == null) {
			dao.addNewProduct(product);
		} else {
			dao.updateProduct(product);
		}
		
		return "redirect:success?id=" + product.getProductId();
	}
	
	@RequestMapping(path="/success", method=RequestMethod.GET)
	public String successPage(@RequestParam Integer id, Model model) throws DaoException{
		Product pr = dao.getProductById(id);
		model.addAttribute("pr", pr);
		return "success";
	}


	
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
