package co.vinod.training.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import co.vinod.training.entity.Product;

@EnableTransactionManagement // Step #1 for Tx management
@Configuration
//@PropertySource({ "classpath:jdbc.properties", "classpath:custom-errors.properties" })
@ComponentScan(basePackages = { "co.vinod.training.dao", "co.vinod.training.web"})
public class AppConfig {
//	@Value("${jdbc.driver}")
//	String driver;
//	@Value("${jdbc.url}")
//	String url;
//	@Value("${jdbc.username}")
//	String username;
//	@Value("${jdbc.password}")
//	String password;

	String driver = "com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost/northwind";
	String username="root";
	String password="Welcome#123";
	
	// loading properties file for custom error messages
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
		bundle.addBasenames("custom-errors");
		return bundle;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver irvr;
		irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}

	// Step #2 for Tx management
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory sf) {
		// This object using AOP injects the transaction-manager into
		// the HibernateTemplate instance which in turn is injected
		// in our HibernateTemplateProductDao
		return new HibernateTransactionManager(sf);
	}
	
	@Bean
	public DataSource ds() {
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

	// this can produce a SessionFactory
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean(); // dependency on DataSource
		factory.setDataSource(ds); // manual wiring (takes care of url, username, password, driver)
		factory.setAnnotatedClasses(Product.class);
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		factory.setHibernateProperties(props);
		return factory;
	}

	@Bean
	public HibernateTemplate template(SessionFactory sf) {
		return new HibernateTemplate(sf); // dependency on SessionFactory
	}

}
