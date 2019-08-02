package co.vinod.training.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import co.vinod.training.dao.ProductDao;
import co.vinod.training.dao.impl.JdbcProductDao;

@Configuration
@PropertySource({ "classpath:jdbc.properties" })
public class AppConfig2 {

	@Value("${jdbc.driver}")
	String driver;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;

	@Bean(name = {"conn"})
	public Connection connection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	@Bean(name = "jdbc_1")
	public ProductDao dao_1() throws ClassNotFoundException, SQLException {
		Connection conn = connection();
		JdbcProductDao dao = new JdbcProductDao();
		dao.setConnection(conn); // manual wiring (dependency injection)
		return dao;

	}

	@Bean(name = "jdbc_2")
	public ProductDao dao_2(Connection conn // automatic dependency of this function
	) throws ClassNotFoundException, SQLException {
		JdbcProductDao dao = new JdbcProductDao();
		dao.setConnection(conn); // manual wiring (dependency injection)
		return dao;

	}

	@Bean(name = "jdbc", autowire = Autowire.BY_TYPE)
	public ProductDao dao() {
		return new JdbcProductDao();
	}
}
