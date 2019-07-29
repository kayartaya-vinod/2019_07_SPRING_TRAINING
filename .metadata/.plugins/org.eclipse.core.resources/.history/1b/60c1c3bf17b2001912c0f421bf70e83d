package co.vinod.training.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.vinod.training.dao.ProductDao;
import co.vinod.training.dao.impl.DummyProductDao;
import co.vinod.training.dao.impl.JdbcProductDao;

@Configuration
public class AppConfig1 {

	@Bean
	public ProductDao dummy() {
		return new DummyProductDao();
	}

	@Bean
	public ProductDao jdbc() {
		return new JdbcProductDao();
	}

}
