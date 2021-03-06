package com.app.spring.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.app.spring.entities.Catalog;
import com.app.spring.entities.Department;
import com.app.spring.entities.Employee;
import com.app.spring.entities.TblTest;
import com.app.spring.entities.User;


@Configuration
public class RepositoryConfig {
	
	public RepositoryConfig() {
	System.out.println("-- repo config");
	}

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;
	@Value("${hibernate.format_sql}")
	private String hibernateFormatSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;
	

	@Bean()
	public DataSource getDataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		htm.setDataSource(getDataSource());
		return htm;
	}

	/*@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}*/

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
		asfb.setDataSource(getDataSource());
		asfb.setHibernateProperties(getHibernateProperties());
		asfb.setAnnotatedClasses(User.class,TblTest.class,Employee.class,Department.class,Catalog.class);
		return asfb;	
	}
	
	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.format_sql", hibernateFormatSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		System.out.println("--- properties: "+properties);
		return properties;
	}

}
