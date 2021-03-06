package co.vinod.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import co.vinod.training.dao.ProductDao;
import co.vinod.training.dao.impl.JdbcProductDao;

@Configuration
@PropertySource({ "classpath:jdbc.properties" })
public class AppConfig3 {
	@Value("${jdbc.driver}")
	String driver;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;

	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);
		bds.setPassword(password);
		bds.setUsername(username);
		
		bds.setInitialSize(10);
		bds.setMaxTotal(100);
		bds.setMaxIdle(50);
		bds.setMinIdle(10);
		
		return bds;
	}

	@Bean(name = "jdbc")
	public ProductDao dao() {
		return new JdbcProductDao();
	}

}
