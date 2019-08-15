package co.vinod.training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.vinod.training.entity.Product;

// Step #3 for tx management - add @Transactional for any of the methods you 
// want transaction to be enabled
@Transactional(readOnly = true)
public interface ProductDao {

	// CRUD operations
	@Transactional(rollbackFor = { DaoException.class }, readOnly = false)
	public void addNewProduct(Product product) throws DaoException;

	public Product getProductById(Integer productId) throws DaoException;

	@Transactional(rollbackFor = { DaoException.class }, readOnly = false)
	public void updateProduct(Product product) throws DaoException;

	@Transactional(rollbackFor = { DaoException.class }, readOnly = false)
	public void deleteProduct(Integer productId) throws DaoException;

	// QUERIES
	public int count() throws DaoException;

	public List<Product> getAllProducts() throws DaoException;

	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException;

	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException;

	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public List<Product> getDiscontinuedProducts() throws DaoException;

	public List<Product> getOutOfStockProducts() throws DaoException;

}
