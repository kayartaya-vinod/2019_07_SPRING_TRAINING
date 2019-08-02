package co.vinod.training.dao.impl;

import java.util.List;

import co.vinod.training.dao.DaoException;
import co.vinod.training.dao.ProductDao;
import co.vinod.training.entity.Product;

public class DummyProductDao implements ProductDao {

	public DummyProductDao() {
	}

	@Override
	public int count() throws DaoException {
		return 125;
	}

	@Override
	public void addNewProduct(Product product) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public Product getProductById(Integer productId) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public void deleteProduct(Integer productId) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Product> getAllProducts() throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Product> getDiscontinuedProducts() throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

}
